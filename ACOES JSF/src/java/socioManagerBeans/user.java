/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socioManagerBeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dosgr
 */
@Named(value = "user")
@ViewScoped
public class user {

    private String name ; 
    private boolean quiereap = false ;
    
    public user() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuiereap(boolean quiereap) {
        this.quiereap = quiereap;
    }


    public String getName() {
        return name;
    }

    public boolean isQuiereap() {
        return quiereap;
    }
    

    
}
