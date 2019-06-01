
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author dosgr
 */
@Named
@RequestScoped
public class SolicitudControl {
    @Inject
    private Negocio negocio;
    @Inject
    private InfoSesion infoSesion;
    
    private Usuario user;
    private boolean terms;
    
    public SolicitudControl(){
        
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }
    
    public String accion(){
        if(terms){
            
            try{
                negocio.insertarSolicitud(infoSesion.getUsuario());
            }catch(ACOESException e){
                
            }
            
            return "socio.xhtml";
        }
        else{
            
            
            
            return "Socio.xhtml";
        }
        
        
    }
}
