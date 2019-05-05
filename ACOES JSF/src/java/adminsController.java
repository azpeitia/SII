
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Vert
 */
@Named (value="adminsController")
@SessionScoped
public class adminsController implements Serializable{
    
    private List<Empleado> listadmins;
    
    public adminsController(){
        Empleado em=new Empleado();
        em.setNombre("Arturo");
        em.setApellido1("Lopez");
        em.setApellido2("Castaño");
        em.setTelefono("3123211");
        em.setMovil("65435453");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();
        em.setFecha_alta(date);
        em.setFecha_nacimiento(date);
        

    }
    
   

    public List<Empleado> getlistadmins() {
        return listadmins;
    }

    public void setlistadmins(List<Empleado> listadmins) {
        this.listadmins = listadmins;
    }
    
}
