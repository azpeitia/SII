package acoesee.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dni;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String nick;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido1;
    private String apellido2;
    private String direccion;
    private int telefono;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    
    /*------ RELACIÓN ----*/
    @OneToMany (mappedBy="usuario")
    private List<Apadrinamientos> apadrinamientos;      //Relación Uno a Muchos con Apadrinamientos
    
    @OneToMany (mappedBy="usuario")
    private List<Solicitud> solicitudes;
    
    @ManyToOne
    private Rol rol;
    
    public Usuario() {
        
    }

    
    
    public List<Apadrinamientos> getapadrinamientos(){
        return apadrinamientos;
    }
    
    public void setApadlist(List<Apadrinamientos> a2){
        apadrinamientos = a2;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Usuario[ nif =" + dni + " ]";
    }

    
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento=fecha_nacimiento;
    }
    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fecha_alta
     */
    public Date getFecha_alta() {
        return fecha_alta;
    }
    
    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta=fecha_alta;
    }
    
    
    public String getPassword() {
        return password;
    }

    /**
     * @param password the nombre to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Apadrinamientos> getApadrinamientos() {
        return apadrinamientos;
    }

    public void setApadrinamientos(List<Apadrinamientos> apadrinamientos) {
        this.apadrinamientos = apadrinamientos;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
    public Rol getRol() {
        return rol;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
