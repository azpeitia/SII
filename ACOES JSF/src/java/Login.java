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


@ManagedBean
@RequestScoped
public class Login {

    
    private String username;
    private String password;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Socio> socios = new ArrayList<>();
    
    
    public void login() {
        
        
        Socio s = new Socio();
        s.setNombre("pepe");
        s.setPassword("asdf");
        socios.add(s);
        
        Empleado e1 = new Empleado();
        e1.setNombre("emp");
        e1.setPassword("emp");
        e1.setRol("emp");
        
        Empleado e2 = new Empleado();
        e2.setNombre("admin");
        e2.setPassword("admin");
        e2.setRol("admin");
        
        empleados.add(e1);
        empleados.add(e2);

        
        FacesContext context = FacesContext.getCurrentInstance();
        int cont = 0;
        
        while(cont < empleados.size() && !this.username.equals(empleados.get(cont).getNombre())) {
            cont++;
        }
        if(cont < empleados.size() && this.password.equals(empleados.get(cont).getPassword())){
            context.addMessage(null, new FacesMessage("TOPOTA"));

            context.getExternalContext().getSessionMap().put("user", username);
            if(empleados.get(cont).getRol().getNombre().equals("emp")){
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
            while(cont < socios.size()  && !this.username.equals(socios.get(cont).getNombre())) {
                cont++;
            }
            if(cont < socios.size() && this.password.equals(socios.get(cont).getPassword())){
            context.addMessage(null, new FacesMessage("POTA"));

                context.getExternalContext().getSessionMap().put("user", username);
                try {
                    context.getExternalContext().redirect("socio.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                context.addMessage(null, new FacesMessage("Error al autenticar"));
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