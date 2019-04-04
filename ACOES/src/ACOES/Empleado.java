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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dave
 */
@Entity
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nif_emp;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido1;
    private String apellido2;
    private String direccion;
    @Column(nullable=false)
    private String telefono;
    @Column(nullable=false)
    private String movil;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    private String poblacion;
    private String provincia;
    
    /*-------- relacion OneToMany con Apadrinamientos-------*/
    @OneToMany (mappedBy="empleado")
    private List<Apadrinamientos> apadrinamientos;
    @ManyToOne
    private Rol rol;        //Relacion Muchos a uno con Rol
        

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public Long getNif_emp() {
        return nif_emp;
    }

    public void setNif_emp(Long nif_emp) {
        this.nif_emp = nif_emp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif_emp != null ? nif_emp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nif_emp fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.nif_emp == null && other.nif_emp != null) || (this.nif_emp != null && !this.nif_emp.equals(other.nif_emp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Empleado[ id=" + nif_emp + " ]";
    }
    
}
