
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
@Named (value= "msg")
@SessionScoped
public class MensajeBean implements Serializable{
    
    private Mensaje msg;
    
    public MensajeBean(){
        
    }

    public Mensaje getMsg() {
        return msg;
    }

    public void setMsg(Mensaje msg) {
        this.msg = msg;
    }
    
    
}
