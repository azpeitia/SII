
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
@Named (value="listaapController")
@SessionScoped
public class listarapController implements Serializable{
    
    private List<Apadrinamientos> listaap;
    
    public listarapController(){
        Apadrinamientos ap=new Apadrinamientos();
        ap.setId_apadrinamiento(Long.MIN_VALUE);
        ap.setStatus("Correcto");

    }
    
   

    public List<Apadrinamientos> getlistaap() {
        return listaap;
    }

    public void setlistaap(List<Apadrinamientos> listaap) {
        this.listaap = listaap;
    }
    
}
