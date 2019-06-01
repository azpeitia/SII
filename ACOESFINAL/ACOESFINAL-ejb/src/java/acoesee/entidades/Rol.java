package acoesee.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acoesee.negocio.ACOESException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Dave
 */
@Entity
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_rol;
    @Column(nullable=false)
    private String nombre;
    private String descripcion;
    
   /*-------- relacion OneToMany con Apadrinamientos-------*/
    @OneToMany (mappedBy="rol")
    private List<Usuario> usuarios;
    
    public Rol(String usuario) throws ACOESException {
        if(usuario.equalsIgnoreCase("admin") || usuario.equalsIgnoreCase("administrador")) {
            id_rol = 0;
            descripcion = "Rol de administrador";
        } else if(usuario.equalsIgnoreCase("empleado") || usuario.equalsIgnoreCase("emp")) {
            id_rol = 1;
            descripcion = "Rol de empleado";
        }else if(usuario.equalsIgnoreCase("socio")) {
            id_rol = 2;
            descripcion = "Rol de socio";
        } else {
            throw new ACOESException("Rol no válido");
        }
        setNombre(usuario);
    }
    
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public void setempleados(List<Usuario> a2){
        usuarios = a2;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_rol != null ? id_rol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_rol fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id_rol == null && other.id_rol != null) || (this.id_rol != null && !this.id_rol.equals(other.id_rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACOES.Rol[ id=" + id_rol + " ]";
    }
    
    
    
}
