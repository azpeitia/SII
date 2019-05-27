/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.negocio;



import acoesee.entidades.Rol;
import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Usuario;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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


    

    public List<Usuario> getUsuarios(Rol r)throws ACOESException{
        List<Usuario> empleados = null;

        Query q = em.createQuery("Select e from usuario e where e.rol = ‘"+r+"’ ");
        empleados=q.getResultList();

        return empleados;
        
    }
    
    

    
    @Override
    public List<Usuario> getUsuarios(Rol r)throws ACOESException{
        List<Usuario> empleados = null;
        
        Query q = em.createQuery("Select e from usuario e where e.rol = ‘"+r+"’ ");
        empleados=q.getResultList();
        
        return empleados;
    }
        
    @Override
    public void eliminarAp(Apadrinamientos ap) {
        em.remove(em.merge(ap));
    }
    

    @Override
    public void modificar(Usuario u) {
        compruebaLogin(u.getUsuario());
        EntityTransaction Ent = em.getTransaction() ;
        Ent.begin();
        em.merge(u);
        Ent.begin();
    }

    @Override
    public void eliminarUsuario(Usuario user) {
        compruebaLogin(user.getUsuario());
        em.remove(em.merge(user));
        em.flush();    
    
    }

    @Override
    public void modificar(Apadrinamientos ap) {

        em.merge(ap);
    }

    @Override
    public void modificarSocio(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compruebaLogin(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario refrescarUsuario(Usuario u) throws ACOESException{
        Usuario user = em.find(Usuario.class, u.getDni());
        if(user == null) throw new CuentaInexistenteException();
        if(!user.getPassword().equals(u.getPassword())) throw new ContraseniaInvalidaException();
        return user;
    }
    
}
