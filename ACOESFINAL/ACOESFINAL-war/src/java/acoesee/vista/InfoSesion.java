/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acoesee.vista;


 
import acoesee.entidades.Usuario;
import acoesee.negocio.Negocio;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import acoesee.negocio.ACOESException;

/**
 *
 * @author francis
 */
@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    @Inject
    private Negocio negocio;
    private Usuario usuario;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }
    
    
    public synchronized String invalidarSesion()
    {
        if (usuario != null)
        {
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
   
    
    public boolean isAdmin(){
        return this.getUsuario().getRol().getNombre().equals("Administrador");
        
    }
    
    
        public boolean isEmpleado(){
        return this.getUsuario().getRol().getNombre().equals("Empleado");
        
    }
    
        public synchronized void refrescarUsuario()
    {
        try {
        if (usuario != null)
        {
            usuario = negocio.refrescarUsuario(usuario);
        } 
        }
        catch (ACOESException e) {
            // TODO
        }
    }    
   
    
}
