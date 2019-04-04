/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Access(AccessType.FIELD)
public class Jovenes implements Serializable {
    @Id @GeneratedValue
    private long id ;
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
    

    long getID(){
        return id ;
    }
    
   void setID(long id){
       this.id = id ;
   }
   
   String getNombre(){
       return nombre ;
   }
   
   void setNombre(String nombre){
       this.nombre = nombre ;
   }
   
   String getApellido1(){
       return apellido1 ;
   }
   
   void setApellido1(String apellido1){
       this.apellido1 = apellido1 ;
   }
    
   String getApellido2(){
       return apellido2 ;
   }
   
   void setApellido2(String apellido2){
       this.apellido2 = apellido2 ;
   }
   
   String getEstado(){
       return estado ;
   }
   
   void setEstado(String estado){
       this.estado = estado ;
   }
   
   String getFotoJoven(){
       return foto_joven ;
   }
   
   void setFotoJoven(String foto_joven){
       this.foto_joven = foto_joven ;
   }
       @Temporal(TemporalType.DATE)
   Date getFechaNacimiento(){
       return fecha_nacimiento ;
   }
       @Temporal(TemporalType.DATE)
   void setFechaNacimiento(Date fecha_nacimiento){
       this.fecha_nacimiento = fecha_nacimiento ;
   }
       @Temporal(TemporalType.DATE)
   Date getFechaAlta(){
       return fecha_alta ;
   }
       @Temporal(TemporalType.DATE)
   void setFechaAlta(Date fecha_alta){
       this.fecha_alta = fecha_alta ;
   }
       @Temporal(TemporalType.DATE)
   Date getFechaBaja(){
       return fecha_baja ;
   }
       @Temporal(TemporalType.DATE)
   void setFechaBaja(Date fecha_baja){
       this.fecha_baja = fecha_baja ;
   }
   
   int getGradoCurso(){
       return grado_curso ;
   }
   
   void setGradoCurso(int grado_curso){
       this.grado_curso = grado_curso ;
   }
   
   String getProcedencia(){
       return procedencia ;
   }
   
   void setProcedencia(String procedencia){
       this.procedencia = procedencia ;
   }
   
   String getColoniaActual(){
       return colonia_actual ;
   }
   
   void setColoniaActual(String colonia_actual){
       this.colonia_actual = colonia_actual ;
   }
   
   String getObservaciones(){
       return observaciones ;
   }
   
   void setObservaciones(String observaciones){
      this.observaciones = observaciones; 
   }
   
}

