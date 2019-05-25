/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.negocio;


import acoesee.entidades.Usuario;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    

}
