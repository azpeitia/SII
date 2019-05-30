/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.vista;

import acoesee.entidades.Usuario;
import acoesee.negocio.ACOESException;
import acoesee.negocio.Negocio;
import java.io.IOException;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Dave
 */
public class AltaEmp {
    
    @Inject
    private Negocio negocio;

    private Usuario emp;
    
    private Long dni;
    private String password;
    private String nick;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private int telefono;

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Usuario getEmp() {
        return emp;
    }

    public void setEmp(Usuario emp) {
        this.emp = emp;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    private Date fecha_nacimiento;
    private String email;
    private Date fecha_alta;
        
    public AltaEmp() {
        
    }
    
    public void confirmar() throws ACOESException, IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            negocio.registrarUsuario(emp);
            context.getExternalContext().redirect("empleado.xhtml");
        } catch (ACOESException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
