
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
@Named (value="ap")
@SessionScoped
public class ApadrinamientoBean implements Serializable{
    
    private Apadrinamientos ap;
    
    public ApadrinamientoBean(){
        
    }

    public Apadrinamientos getAp() {
        return ap;
    }

    public void setAp(Apadrinamientos ap) {
        this.ap = ap;
    }
    
    
}
