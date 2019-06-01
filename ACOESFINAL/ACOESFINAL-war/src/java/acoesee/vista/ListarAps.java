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
    
    private static final ArrayList<Apadrinamientos> personList = new ArrayList<>();
	
   
    
    @Inject
    private Negocio negocio;
    
    @Inject
    private InfoSesion sesion;
    
    private Apadrinamientos apadrinamiento;
     
    
    public ListarAps(){
        apadrinamiento=new Apadrinamientos();
    }
    
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
        
        public void setApadrinamiento(Apadrinamientos ap) {
            this.apadrinamiento = ap;
        }

        public Apadrinamientos getApadrinamiento() {
            return apadrinamiento;
        }
    
        
        
        public void deleteAction(Apadrinamientos a) {
		negocio.eliminarAp(a);
                //negocio.eliminarAp(aps);

	}
	
	public String editAction(Apadrinamientos ap) {
	    
		apadrinamiento=ap;
                return "modificarapa.xhtml";
	}
        
}
