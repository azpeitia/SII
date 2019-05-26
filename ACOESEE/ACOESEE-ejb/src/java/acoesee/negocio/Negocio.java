
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
     public void modificar(Usuario user);
     public void modificar(Apadrinamientos ap);
     public void compruebaLogin(Usuario u);
     public void modificarSocio(Usuario user) ;
}
