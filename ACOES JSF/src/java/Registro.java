
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "registro")
@javax.enterprise.context.RequestScoped
public class Registro {
    
    private Socio registrar = new Socio();
    
    //@Inject
    
    //@EJB
    private Socio socio;
    
    private String repass;

    private String cuenta;
    private String codigoValidacion;

    private String mensajeValidacion;
    private boolean validacionOK;

    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Registro() {
        socio = new Socio();
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setUsuario(Socio usuario) {
        this.socio = usuario;
    }

    public String registrarUsuario() {
        if (!socio.getPassword().equals(repass)) {
            FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
            FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
            return null;
        }
        //negocio.registrarUsuario(socio);
        registroOK = true;
        return "index.xhtml";
    }

    /*public String validarCuenta() {
        try {
            if (cuenta != null && codigoValidacion != null) {
                negocio.validarCuenta(cuenta, codigoValidacion);
            }
            mensajeValidacion = "La validación ha sido correcta, ahora puede acceder con este usuario.";
            validacionOK = true;
        } catch (AgendaException e) {
            mensajeValidacion = "Ha habido un error con la validación, compruebe que la URL es correcta.";
            validacionOK = false;
        }
        return null;
    }*/

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public boolean isValidacionOK() {
        return validacionOK;
    }

}
