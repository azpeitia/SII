
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
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
@Named (value="socio")
@SessionScoped
public class SocioBean implements Serializable{
    
    private Socio socio;
    private boolean quiereap;
    
    public SocioBean(){
        
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public boolean isQuiereap() {
        return quiereap;
    }

    public void setQuiereap(boolean quiereap) {
        this.quiereap = quiereap;
    }
    
}
