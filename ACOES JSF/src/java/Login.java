/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dave
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "login")
@RequestScoped
public class Login {

    
    private String username;
    private String password;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Socio> socios = new ArrayList<>();
    
    
    public void login() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        int cont = 0;
        while(cont < empleados.size()  && empleados.get(cont).getNombre() != this.username) {
            cont++;
        }
        if(cont < empleados.size() && this.password.equals(empleados.get(cont).getPassword())){
            context.getExternalContext().getSessionMap().put("user", username);
            if(empleados.get(cont).getRol().getNombre().equals("empleado")){
                try {
                context.getExternalContext().redirect("empleado.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                context.getExternalContext().redirect("admin.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else  {
            cont = 0;
            while(cont < socios.size()  && socios.get(cont).getNombre() != this.username) {
                cont++;
            }
            if(cont < socios.size() && this.password.equals(socios.get(cont).getPassword())){
                context.getExternalContext().getSessionMap().put("user", username);
                try {
                    context.getExternalContext().redirect("socio.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
            }
        } 
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}