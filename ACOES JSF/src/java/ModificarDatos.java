/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dave
 */

import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ModificarDatos {
    
    private Socio socio;

    public ModificarDatos() {
    }
    
    public void confirmar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("socio.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
