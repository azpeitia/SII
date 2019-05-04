/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dave
 */
public class AltaEmp {
    
    private Empleado emp;
        
    public AltaEmp() {
        
    }
    
    public void confirmar() {
        FacesContext context = FacesContext.getCurrentInstance();
        emp.setNif_emp(Long.MIN_VALUE);                             //Una vez haya permanencia usar identificador unico
        try {
            context.getExternalContext().redirect("admin.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
