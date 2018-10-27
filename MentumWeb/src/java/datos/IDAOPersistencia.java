
package datos;

import java.util.ArrayList;
import modelo.IEntidades;


public interface IDAOPersistencia {
    public int crear(IEntidades objeto) throws Exception;
    public int buscarClienteId (String nombre) throws Exception;    
    public ArrayList<String> nombresClientes( ) throws Exception;
    
}
