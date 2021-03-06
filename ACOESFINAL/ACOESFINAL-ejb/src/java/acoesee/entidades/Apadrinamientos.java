package acoesee.entidades;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Santi
 */
@Entity
public class Apadrinamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_apadrinamiento;
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;
    private String status;
    boolean editable;

    /*----REALACIONES---*/
   
    @ManyToOne
    private Jovenes joven;  //Relación Muchos a Uno con Jovenes
    @ManyToOne
    private Usuario usuario;       //Relación Muchos a Uno con Socio
    //con el atributo apadhist modelamos la relacion uno a muchos que va desde apadrinamientos a historial_apadrinamientos
    @OneToMany (mappedBy="apadrinamiento")
    private List<Historial_apadrinamientos> h_apadrinamientos;      //Relación Uno a Muchos con Historial de Apadrinameitnos
    
    @OneToMany (mappedBy="ap")
    private List<Mensaje> msgs;
    

    public boolean isEditable() {
	return editable;
    }

    public void setEditable(boolean editable) {
	this.editable = editable;
    }
    
    public List<Historial_apadrinamientos> getApadhist(){
        return h_apadrinamientos;
    }
    
    public void setApadhist(List<Historial_apadrinamientos> a2){
        h_apadrinamientos = a2;
    }
    
    public Long getId_apadrinamiento() {
        return id_apadrinamiento;
    }
    
    public void setId_apadrinamiento(Long id) {
        this.id_apadrinamiento = id;
    }
    
     public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_apadrinamiento != null ? id_apadrinamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apadrinamientos)) {
            return false;
        }
        Apadrinamientos other = (Apadrinamientos) object;
        if ((this.id_apadrinamiento == null && other.id_apadrinamiento != null) || (this.id_apadrinamiento != null && !this.id_apadrinamiento.equals(other.id_apadrinamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Apadrinamientos[ id=" + id_apadrinamiento + " ]";
    }
    
    
    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Jovenes getJoven() {
        return joven;
    }

    public void setJoven(Jovenes joven) {
        this.joven = joven;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Historial_apadrinamientos> getH_apadrinamientos() {
        return h_apadrinamientos;
    }

    public void setH_apadrinamientos(List<Historial_apadrinamientos> h_apadrinamientos) {
        this.h_apadrinamientos = h_apadrinamientos;
    }

    public List<Mensaje> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Mensaje> msgs) {
        this.msgs = msgs;
    }
    
    
}
