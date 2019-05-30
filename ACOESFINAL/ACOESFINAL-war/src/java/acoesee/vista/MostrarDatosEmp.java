/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.Negocio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Dave
 */
public class MostrarDatosEmp {
    
    @Inject
    private Negocio negocio;
        private Usuario user;
    
        public void confirmar() {
        try {
            negocio.modificar(user);
        } catch (ACOESException ex) {
            Logger.getLogger(MostrarDatosEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("empleado.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
