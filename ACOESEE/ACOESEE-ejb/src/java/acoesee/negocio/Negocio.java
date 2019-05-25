
package acoesee.negocio;


import acoesee.entidades.Usuario;
import javax.ejb.Local;


@Local
public interface Negocio {
     public void registrarUsuario(Usuario u)throws ACOESException;
     
}

