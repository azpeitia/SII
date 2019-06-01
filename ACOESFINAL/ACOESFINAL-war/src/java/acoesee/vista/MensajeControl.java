/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Mensaje;
import java.io.Serializable;
import java.util.List;
import acoesee.negocio.Negocio;
import acoesee.negocio.ACOESException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Javier
 */
@Named (value="mensajeControl")
@RequestScoped
public class MensajeControl implements Serializable{
    
    
    @Inject
    private Negocio negocio;
    
    
    
   

    

    

    
    
    
}
