/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Usuario;
import acoesee.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import acoesee.negocio.*;

/**
 *
 * @author dosgr
 */
@Named(value = "SocioControl")
@RequestScoped
public class SocioControl {
    @Inject
    private Negocio negocio;
    private Usuario usuario;
    
    public SocioControl(){
        usuario = new Usuario() ;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String modificarSocio() throws ACOESException{
        negocio.modificarSocio(usuario) ;
        return "socio.xhtml" ;
    }
}
