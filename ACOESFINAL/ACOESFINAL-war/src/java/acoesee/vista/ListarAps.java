/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.CuentaInexistenteException;
import acoesee.negocio.Negocio;
import java.util.ArrayList;
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
@Named(value = "listaraps")
@RequestScoped
public class ListarAps {
    
    private static final long serialVersionUID = 1L;
    
    private static final ArrayList<Apadrinamientos> personList = new ArrayList<>();
	
    private static final Apadrinamientos[] aps = new Apadrinamientos[]{};
    
    private Negocio negocio;

               
    public ArrayList<Apadrinamientos> getPersonList() {
 
		return personList;
                
	}
	
	public String saveAction() throws ACOESException {
	    
		//get all existing value but set "editable" to false 
		for (Apadrinamientos ap : personList){
			ap.setEditable(false);
                        negocio.modificar(ap);
		}
		
		//return to current page
		return null;
		
	}
        
        public String deleteAction(Apadrinamientos ap) {
		personList.remove(ap);
                negocio.eliminarAp(ap);

		return null;
	}
	
	public String editAction(Apadrinamientos ap) {
	    
		ap.setEditable(true);
		return null;
	}
        
}
