
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dave
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
 
@ManagedBean(name="socio")
@SessionScoped
public class Socios implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final Socio[] personList = new Socio[]{

		new Socio("David", "Florido", "Ruiz"),
		new Socio("Antonio", "Alcaide", "Jimenez"),
		new Socio("Javier", "Azpeitia", "Muñoz"),
		new Socio("Santiago", "Marin", "Quintero"),
		new Socio("David", "Merida", "Granados")
		
	};
	
        private static final Socio[] sos = new Socio[]{
		
	};
               
	private DataModel<Socio> person = new ArrayDataModel<Socio>(personList);
	
	public DataModel<Socio> getPersonList() {
 
		return person;
 
	}
        
        public void mostrar() {
            FacesContext context = FacesContext.getCurrentInstance();

            try {
                context.getExternalContext().redirect("modificardatos.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}