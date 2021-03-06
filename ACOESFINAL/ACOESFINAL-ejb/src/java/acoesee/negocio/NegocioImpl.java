/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesee.negocio;



import acoesee.entidades.Rol;
import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Mensaje;
import acoesee.entidades.Usuario;
import acoesee.entidades.Mensaje;
import acoesee.entidades.Jovenes;
import acoesee.entidades.Solicitud;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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




    @Override
    public List<Usuario> getUsuarios(Rol r)throws ACOESException{
        List<Usuario> empleados;


        Query q = em.createQuery("Select e from usuario e where e.rol = ‘"+r.getNombre()+"’ ");
        empleados=q.getResultList();

        return empleados;

    }

    public List<Usuario> getUsuarios2 (String s)throws ACOESException{
        Query q = em.createQuery("Select u from Usuario u where u.rol.nombre='"+s+"'");
        return q.getResultList();
    }

    /*
    @Override
    public List<Usuario> getUsuarios(Rol r)throws ACOESException{
        List<Usuario> empleados = null; 
        
        Query q = em.createQuery("Select e from usuario e where e.rol = ‘"+r+"’ ");
        empleados=q.getResultList();
        
        return empleados;
    }*/
        

    @Override
    public void eliminarAp(Apadrinamientos ap) {
        em.remove(em.merge(ap));
        em.flush();
    }


    @Override
    public void modificar(Usuario u) throws ACOESException {
       Usuario user=em.find(Usuario.class, u.getNick());
       em.merge(user);

    }
    
   

    @Override
    public void eliminarUsuario(Usuario user) throws ACOESException {
        //compruebaLogin(user);
        //Usuario u=em.find(Usuario.class, user.getNick());
        //em.remove(em.merge(user));
    }

    @Override
    public void modificar(Apadrinamientos ap) {
        Apadrinamientos apa=em.find(Apadrinamientos.class, ap.getId_apadrinamiento());
       em.merge(apa);
    }


    @Override
    public void compruebaLogin(Usuario u) throws ACOESException {
         //To change body of generated methods, choose Tools | Templates.
         Usuario user = em.find(Usuario.class, u.getNick());
        if (user == null)
            throw new CuentaInexistenteException();
        if(!user.getPassword().equals(u.getPassword())) throw new ContraseniaInvalidaException();


    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws ACOESException{
        Usuario user = em.find(Usuario.class, u.getNick());
        if(user == null) throw new CuentaInexistenteException();
        if(!user.getPassword().equals(u.getPassword())) throw new ContraseniaInvalidaException();
        return user;
    }

    @Override

    public List<Mensaje> getMensajes() throws ACOESException{
        List<Mensaje> msgs = em.createQuery("SELECT m FROM Mensaje m").getResultList();
        if (msgs.isEmpty())
            System.out.println("La lista ESTÄ VACIA...");
        else
            System.out.println("La lista TIENE COSAS");
        return msgs;
    }
    @Override
    public void insertarNj(Jovenes nj){
        em.persist(nj);
    }

     @Override
    public void insertMensaje(Apadrinamientos ap) throws ACOESException{
        Mensaje M = new Mensaje() ;
        M.setAp(ap);
        EntityTransaction Ent = em.getTransaction() ;
        Ent.begin();
        em.persist(M) ;
        Ent.commit();
    }

    @Override
    public Apadrinamientos getapadrinamiento(Long dni, Long idnj) throws ACOESException{
         Apadrinamientos ap ;
         Query q = em.createQuery("Select e from apadrinamientos e where e.joven = "
                 + "(Select e from jovenes e where e.id = "+idnj+") and "
                 + "e.usuario = (Select e form Usuario e where e.dni="+dni+") ");
         ap = (Apadrinamientos) q.getResultList().get(0) ;
        return ap;
    }


    @Override
    public void insertarSolicitud (Usuario u) throws ACOESException{
        Usuario user = em.find(Usuario.class, u.getNick());
        if (user!=null){
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            Solicitud sol= new Solicitud();
            sol.setFecha(date);
            sol.setUsuario(user);
            em.persist(sol);
        }else{

        }

    }

    @Override
    public List<Apadrinamientos> getapadrinamientos() throws ACOESException {
        List<Apadrinamientos> l = new ArrayList<>();
        Query q = em.createQuery("SELECT e FROM Apadrinamientos e");
        l = q.getResultList();
        return l;
    }
    
    public List<Jovenes> getNjs(){
        Query q = em.createQuery("SELECT j FROM (APP.jovenes) j");
        return q.getResultList();
    }

}
