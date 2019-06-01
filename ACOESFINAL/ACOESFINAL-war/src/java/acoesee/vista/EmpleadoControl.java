/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acoesee.vista;


 
import acoesee.entidades.Rol;
import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.Negocio;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "EmpleadoControl")
@RequestScoped
public class EmpleadoControl {

    @Inject
    private Negocio negocio;
    
    @Inject
    private InfoSesion sesion;
    
    private Usuario usuario;
    
   public EmpleadoControl(){
       usuario=new Usuario();
   }
    
    public List<Usuario> getEmpleados() throws ACOESException{
        
        return negocio.getUsuarios2("Empleado");
    }
    
    public void setUsuario(Usuario user) {
        this.usuario = user;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    public void eliminarEmpleado(Usuario u) throws ACOESException{
        negocio.eliminarUsuario(u);
    }
   
    public String modificar(Usuario c) {
        usuario = c;
        return "mostrardatosemp.xhtml";
    }
    
}
