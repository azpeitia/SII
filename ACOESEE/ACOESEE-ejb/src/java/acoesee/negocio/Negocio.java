
package acoesee.negocio;


import acoesee.entidades.Rol;
import acoesee.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Negocio {
     public void registrarUsuario(Usuario u)throws ACOESException;
     public List<Usuario> getUsuarios(Rol r)throws ACOESException;
     
}

