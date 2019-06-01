package acoesee.vista;

import acoesee.entidades.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import acoesee.negocio.*;
import java.util.List;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dosgr
 */
@Named
@RequestScoped
public class AdminControl {
    
    @Inject
    private Negocio negocio;

    @Inject
    private InfoSesion sesion;
    
    
    
    public List<Mensaje> getMensajes() {
        try{
            List<Mensaje> mensajes=negocio.getMensajes();
            return mensajes;
        }catch(ACOESException e){
            return null;
        }
    }
    
}
