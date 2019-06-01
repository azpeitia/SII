/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Rol;
import acoesee.entidades.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import acoesee.negocio.*;
/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    @Inject
    private Negocio negocio;

    @Inject
    private InfoSesion sesion;

    private Usuario usuario;

    /**
     * Creates a new instance of login
     */
    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /*
    public String entrarComoSocio(){
    try{
            negocio.compruebaLogin(usuario);
            Usuario user = negocio.refrescarUsuario(usuario);
            if(user.getRol().getNombre()!="Socio") throw new CuentaInexistenteException();
            sesion.setUsuario(user);
            return "socio.xhtml";
            
        }catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }catch (ACOESException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
    
    public String entrarComoEmpleado(){
    try{
            negocio.compruebaLogin(usuario);
            Usuario user = negocio.refrescarUsuario(usuario);
            if(user.getRol().getNombre()!="Empleado") throw new CuentaInexistenteException();
            sesion.setUsuario(user);
            return "empleado.xhtml";
            
        }catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }catch (ACOESException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
    
    public String entrarComoAdministrador(){
    try{
            negocio.compruebaLogin(usuario);
            Usuario user = negocio.refrescarUsuario(usuario);
            if(user.getRol().getNombre()!="Administrador") throw new CuentaInexistenteException();
            sesion.setUsuario(user);
            return "admin.xhtml";
            
        }catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        
        }catch (ACOESException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }*/
    
    public String entrar(){
        try{
            negocio.compruebaLogin(usuario);
            Usuario user = negocio.refrescarUsuario(usuario);
            sesion.setUsuario(user);
            if(user.getRol().getNombre() .equals ("Socio")){
                return "socio.xhtml";
            }else if (user.getRol().getNombre().equals("Administrador")){
                return "admin.xhtml";
            }else{
                return "empleado.xhtml";
            }
        }catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        }catch (ACOESException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

}
