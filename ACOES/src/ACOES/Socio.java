/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACOES;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier
 */
@Entity
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nif_socio;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido1;
    private String apellido2;
    private String estado;
    private String direccion;
    private String pobacion;
    private int cp;
    private String provincia;
    private int telefono;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    private int movil;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    private String observaciones;
    private String password;
    
    /*------ RELACIÓN ----*/
    @OneToMany (mappedBy="socio")
    private List<Apadrinamientos> apadrinamientos;      //Relación Uno a Muchos con Apadrinamientos
    
    public List<Apadrinamientos> getapadrinamientos(){
        return apadrinamientos;
    }
    
    public void setApadhist(List<Apadrinamientos> a2){
        apadrinamientos = a2;
    }
    
    
    public Long getNif_socio() {
        return nif_socio;
    }

    public void setNif_socio(Long nif) {
        this.nif_socio = nif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif_socio != null ? nif_socio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.nif_socio == null && other.nif_socio != null) || (this.nif_socio != null && !this.nif_socio.equals(other.nif_socio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Socio[ nif =" + nif_socio + " ]";
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return the pobacion
     */
    public String getPobacion() {
        return pobacion;
    }

    /**
     * @param pobacion the pobacion to set
     */
    public void setPobacion(String pobacion) {
        this.pobacion = pobacion;
    }

    /**
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    /**
     * @return the movil
     */
    public int getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(int movil) {
        this.movil = movil;
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

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    /*
    
    public String getpassword() {
        return password;
    }

    /**
     * @param password the nombre to set
     *//*
    public void setpassword(String password) {
        this.password = password;
    }*/
    
}
