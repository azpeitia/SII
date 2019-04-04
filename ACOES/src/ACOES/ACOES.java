/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACOES;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Javier
 */
public class ACOES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socio socio= new Socio();
        socio.setNombre("Pablo");
        socio.setApellido1("Torres");
        
        //Apadrinamientos apadrinamientos = new Apadrinamientos();
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        EntityManager em = emf.createEntityManager();
        //EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(socio);
        //em.persist(apadrinamientos);
        tx.commit();
        
        
        
        
        em.close();
        emf.close();

        
    }

}
