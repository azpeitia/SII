
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier
 */
@Named (value="solicitudcontroller")
@SessionScoped
public class solicitudController implements Serializable{
    
    private ArrayList<Solicitud> solicitudes;
    
    public solicitudController(){
        
    }
    
   
    public String testSolicitudes(){
        Socio user=new Socio();
        user.setApellido1("Azpeitia");
        user.setApellido2("Muñoz");
        user.setNombre("Javier");
        
        Solicitud sol=new Solicitud();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();
	sol.setFecha(date);      
        sol.setId(Long.MIN_VALUE);
        sol.setSocio(user);
        
        solicitudes.add(sol);
        return "solicitudes.xhtml";
    }
    
    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
}
