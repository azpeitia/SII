/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */

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

@Named (value="empleadoscontroller")
@SessionScoped
public class EmpleadosController {
    private List<Empleado> listaempleados;
    
    public List<Empleado> getEmpleados(){
        return listaempleados;
    }
    
    public void setEmpleados(List<Empleado> listemp){
        listaempleados = listemp;
    }
}
