/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;
import acoesee.entidades.Jovenes;
import acoesee.entidades.Usuario;
import acoesee.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import acoesee.negocio.*;
import java.util.List;
import javax.ejb.EJB;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author Antonio
 */
@Named (value = "njControl")
@RequestScoped
public class NjControl {
    @Inject
    private Negocio negocio;
    
    @Inject
    private InfoSesion sesion;
    
    private Jovenes nj;
    
    private String fechnacaux;
    
    private String fechaltaux;
    
    public NjControl(){
        nj = new Jovenes();
        
    }
    
    public void setNj(Jovenes nj){
        this.nj = nj;
    }
    
    public Jovenes getNj(){
        return nj;
    }
    
    public String getFechnacaux(){
        return fechnacaux;
    }
    
    public void setFechnacaux(String fechnacaux){
        this.fechnacaux = fechnacaux;
    }
    
    public String getFechaltaux(){
        return fechaltaux;
    }
    
    public void setFechaltaux(String fechaltaux){
        this.fechaltaux = fechaltaux;
    }
    
    public Date parseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;

    }
    
    public String insertarNj(){
        nj.setFecha_nacimiento(parseFecha(fechnacaux));
        nj.setFecha_alta(parseFecha(fechaltaux));
        negocio.insertarNj(nj);
        sesion.refrescarUsuario();
        return "admin.xhtml";
        
    }
    
    public List<Jovenes> getNjs(){return null;}
    
    
}
