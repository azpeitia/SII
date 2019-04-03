/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACOES;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Antonio
 */
public class Historial_apadrinamientos {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_h_apadrinamientos;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    @Temporal(TemporalType.DATE)
    private Date fecha_baja;
    
    
    public Long getId_h_apadrinamientos() {
        return id_h_apadrinamientos;
    }

    public void setId_h_apadrinamientos(Long id_h_apadrinamientos) {
        this.id_h_apadrinamientos = id_h_apadrinamientos;
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
    
    @Override
    public boolean equals(Object o){
    Historial_apadrinamientos h2 = (Historial_apadrinamientos) o;
    return this.id_h_apadrinamientos.equals(h2.id_h_apadrinamientos);
    }
    
    @Override 
    public String toString(){
        return "ACOES.Historial_apadrinamientos[ id=" + id_h_apadrinamientos + " ]";
    }
}

