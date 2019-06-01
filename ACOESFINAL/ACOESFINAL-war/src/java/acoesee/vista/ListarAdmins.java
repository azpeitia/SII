/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Rol;
import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.ContraseniaInvalidaException;
import acoesee.negocio.CuentaInexistenteException;
import acoesee.negocio.Negocio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;


/**
 *
 * @author Dave
 */
@Named(value = "listadmins")
@RequestScoped
public class ListarAdmins {
    
    private static final long serialVersionUID = 1L;
    
    private static List<Usuario> personList = new ArrayList<>();
	
    private static Usuario[] users = new Usuario[]{};
    
    @Inject
    private Negocio negocio;

               
    public List<Usuario> getPersonList() throws ACOESException {
        Rol r = new Rol("Administrador");
        personList = negocio.getUsuarios2(r);
        return personList;
	}
	
	public String saveAction() throws ACOESException {
	    
		//get all existing value but set "editable" to false 
		for (Usuario user : personList){
			user.setEditable(false);
                        negocio.modificar(user);
		}
		
		//return to current page
		return null;
		
	}
        
        public String deleteAction(Usuario user) throws ACOESException {
		personList.remove(user);
                negocio.eliminarUsuario(user);

		return null;
	}
	
	public String editAction(Usuario user) {
	    
		user.setEditable(true);
		return null;
	}
        
}
