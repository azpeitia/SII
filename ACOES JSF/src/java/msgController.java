
import java.io.Serializable;
import java.util.List;
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
@Named (value="msgcontroller")
@SessionScoped
public class msgController implements Serializable{
    
    private List<Mensaje> msgs;

    public msgController(){
        
    }
    
    public List<Mensaje> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Mensaje> msgs) {
        this.msgs = msgs;
    }
}
