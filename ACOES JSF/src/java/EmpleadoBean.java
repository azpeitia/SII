
import java.io.Serializable;
import javax.faces.bean.RequestScoped;
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
@Named(value = "empleado")
@SessionScoped
public class EmpleadoBean implements Serializable{

    private Empleado emp;
    
    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
        
    public EmpleadoBean(){
    }
    
}
