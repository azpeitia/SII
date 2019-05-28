/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Usuario;
import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dave
 */
public class MostrarDatosEmp {
    
        private Usuario user;
    
        public void confirmar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("empleado.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
