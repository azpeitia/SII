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

/**
 *
 * @author Antonio
 */
@Named(value = "njcontrol")
@RequestScoped
public class NjControl {
    @Inject
    private Negocio negocio;
    
    @Inject
    private InfoSesion sesion;
    
    private Jovenes nj;
    
    public void setNj(Jovenes nj){
        this.nj = nj;
    }
    
    public Jovenes getNj(){
        return nj;
    }
    
    public String insertarNj(){
        negocio.insertarNj(nj);
        sesion.refrescarUsuario();
        return "listarnjs.xhtml";
        
    }
    
    public List<Jovenes> getNjs(){return null;}
    
    
}
