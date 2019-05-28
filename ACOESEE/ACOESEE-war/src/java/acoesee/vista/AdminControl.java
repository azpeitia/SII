package acoesee.vista;

import acoesee.entidades.Usuario;
import acoesee.entidades.Rol;
import acoesee.negocio.ACOESException;
import acoesee.negocio.Negocio;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dosgr
 */

@Named(value = "AdminControl")
@RequestScoped
public class AdminControl {
    
    @Inject
    private Negocio negocio;                
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Usuario> getAdmins() throws ACOESException{
        Rol admin = new Rol("administradores") ;
        return negocio.getUsuarios(admin) ;
    }
    
}
