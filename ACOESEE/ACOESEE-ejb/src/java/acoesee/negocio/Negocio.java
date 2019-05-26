
package acoesee.negocio;


import acoesee.entidades.Apadrinamientos;
import acoesee.entidades.Usuario;
import javax.ejb.Local;


@Local
public interface Negocio {
     public void registrarUsuario(Usuario u)throws ACOESException;
     public void eliminarAp(Apadrinamientos ap);
     public void eliminarUsuario(Usuario u);

    public void modificar(Usuario user);

    public void modificar(Apadrinamientos ap);

}

