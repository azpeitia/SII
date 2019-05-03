/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class Jovenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre ;
    private String apellido1 ;
    private String apellido2 ;
    private String estado ;
    private String foto_joven ;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento ;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta ;
    @Temporal(TemporalType.DATE)
    private Date fecha_baja ;
    private int grado_curso;
    private String procedencia ;
    private String colonia_actual ;
    private String observaciones ;
    /*-------RELACIÓN---*/
    @OneToMany (mappedBy="joven")
    private List<Apadrinamientos> apadrinamientos;   //Relación Uno a Muchos con Apadrinamientos
    
    
    public List<Apadrinamientos> getapadrinamientos(){
        return apadrinamientos;
    }
    
    public void setApadhist(List<Apadrinamientos> a2){
        apadrinamientos = a2;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto_joven() {
        return foto_joven;
    }

    public void setFoto_joven(String foto_joven) {
        this.foto_joven = foto_joven;
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

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getGrado_curso() {
        return grado_curso;
    }

    public void setGrado_curso(int grado_curso) {
        this.grado_curso = grado_curso;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getColonia_actual() {
        return colonia_actual;
    }

    public void setColonia_actual(String colonia_actual) {
        this.colonia_actual = colonia_actual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jovenes)) {
            return false;
        }
        Jovenes other = (Jovenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Jovenes[ id=" + id + " ]";
    }
    
}
