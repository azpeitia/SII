
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
@Named (value="nj")
@SessionScoped
public class NJBean implements Serializable{
    
    private Jovenes nj;
    
    public NJBean(){
        
    }

    public Jovenes getNj() {
        return nj;
    }

    public void setNj(Jovenes nj) {
        this.nj = nj;
    }
    
}
