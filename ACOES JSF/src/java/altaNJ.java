/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Javier
 */
public class altaNJ{
    
    private Jovenes nj;
        
    public altaNJ() {
        
    }
    
    public void confirmar() {
        FacesContext context = FacesContext.getCurrentInstance();
        nj.setId(Long.MIN_VALUE);                             
        try {
            context.getExternalContext().redirect("empleado.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
