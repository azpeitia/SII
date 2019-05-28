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
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "empleadoControl")
@SessionScoped
public class EmpleadoControl implements Serializable {

    @Inject
    private Negocio negocio;
    @Inject
    private Usuario usuario;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public EmpleadoControl() {
    }
    
    public List<Usuario> getEmpleados() throws ACOESException{
        Rol r = new Rol("empleado");
        return negocio.getUsuarios(r);
    }
    
    public void eliminarEmpleado(Usuario u) throws ACOESException{
        negocio.eliminarUsuario(u);
    }
   
    public String modificar(Usuario c) {
        usuario = c;
        return "mostrardatpsemp.xhtml";
    }
    
}
