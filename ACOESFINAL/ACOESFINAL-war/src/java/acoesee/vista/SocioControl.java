
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Mensaje;
import acoesee.entidades.Rol;
import acoesee.entidades.Usuario;
import acoesee.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import acoesee.negocio.*;
import java.util.List;
/**
 *
 * @author dosgr
 */
@Named
@RequestScoped
public class SocioControl {
    @Inject
    private Negocio negocio;
    @Inject
    private InfoSesion infoSesion;

    private Usuario usuario;

    public SocioControl(){
        usuario=new Usuario();
    }

    public void setUsuario(Usuario usuario) {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public String modificarSocio() throws ACOESException{
        negocio.modificar(usuario) ;
        Usuario user=infoSesion.getUsuario();
        
        switch (user.getRol().getNombre()) {
            case "Administrador":
                return "admin.xhtml";
                
            case "Empleado":
                return "empleado.xhtml";
                
            case "Socio":
                return "socio.xhtml";
        }
        return null;
    }


    public String modificar(Usuario c) {
        usuario = c;
        return "modificarsocio.xhtml";
    }

    public List<Usuario> getSocios() {
        try{
            List<Usuario> socios=negocio.getUsuarios2("Socio");
            return socios;
        }catch(ACOESException e){
            return null;
        }
    }

    

    public String eliminarUsuario (Usuario u){
        
        try{
            negocio.eliminarUsuario(u) ;
        }catch(ACOESException e){
        }
        Usuario user=infoSesion.getUsuario();
        
        switch (user.getRol().getNombre()) {
            case "Administrador":
                return "admin.xhtml";
                
            case "Empleado":
                return "empleado.xhtml";
                
            case "Socio":
                return "socio.xhtml";
        }
        return null;

    }



}
