
package acoesee.negocio;



import acoesee.entidades.Rol;

import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Negocio {
     public void registrarUsuario(Usuario u)throws ACOESException;
     public List<Usuario> getUsuarios(Rol r)throws ACOESException;
     public void eliminarAp(Apadrinamientos ap);
     public void eliminarUsuario(Usuario u);
     public void modificar(Usuario user) throws ACOESException;
     public void modificar(Apadrinamientos ap) throws ACOESException;
     public void compruebaLogin(Usuario u) throws ACOESException;
     public void modificarSocio(Usuario user) throws ACOESException;
     public Usuario refrescarUsuario(Usuario u) throws ACOESException;
     public Apadrinamientos getapadrinamiento(Long dni, Long idnj) throws ACOESException;
     public void insertMensaje(Apadrinamientos ap) throws ACOESException;

}
