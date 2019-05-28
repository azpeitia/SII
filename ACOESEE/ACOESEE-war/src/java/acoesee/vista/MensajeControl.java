/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Apadrinamientos;
import acoesee.negocio.Negocio;
import acoesee.entidades.Mensaje;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dosgr
 */
@Named(value = "SocioControl")
@RequestScoped
public class MensajeControl {
    private Long dni ;
    private Long idjoven;
    
        
    @Inject
    private Negocio negocio;
    private Mensaje mensaje ; 
    

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public void setIdjoven(Long idjoven) {
        this.idjoven = idjoven;
    }

    public Long getDni() {
        return dni;
    }

    public Long getIdjoven() {
        return idjoven;
    }
    
    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Negocio getNegocio() {
        return negocio;
    }
    
    public void altaMensaje(){
        Apadrinamientos ap ;
        ap = negocio.getapadrinamiento(dni, idjoven);
        negocio.insertMensaje(ap) ;
    }
    
}
