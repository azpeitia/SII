/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.negocio;


import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Usuario;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {

    

    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;

    
    @Override
    public void registrarUsuario(Usuario u) throws ACOESException {
        Usuario user = em.find(Usuario.class, u.getNick());
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }

        em.persist(u);

    }
    
    @Override
    public void eliminarAp(Apadrinamientos ap) {
        em.remove(em.merge(ap));
    }
    
    @Override
    public void modificar(Usuario u) {
        compruebaLogin(u.getUsuario());
        
        em.merge(u);
    }

    @Override
    public void eliminarUsuario(Usuario user) {
        compruebaLogin(user.getUsuario());
        em.remove(em.merge(user));
        em.flush();    
    }

}
