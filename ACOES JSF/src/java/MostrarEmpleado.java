/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dosgr
 */
@Named(value = "mE")
@RequestScoped
public class MostrarEmpleado {

    private Empleado emp ;
    
    public MostrarEmpleado() {
        
    }
    
        public void confirmar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("socio.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Empleado getEmp() {
        return emp;
    }
        

    
}
