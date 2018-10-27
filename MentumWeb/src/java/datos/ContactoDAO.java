
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Contacto;
import modelo.IEntidades;


public class ContactoDAO extends ManejadoBD implements IDAOPersistencia{

    public ContactoDAO() throws SQLException {
    }

    public ContactoDAO(String driver, String nombreIPServidor, String url, String usuario, String pass, String nombreBD) throws SQLException {
        super(driver, nombreIPServidor, url, usuario, pass, nombreBD);
    }

    
    @Override
    public int crear(IEntidades objeto) throws Exception  {
        int filas = 0;
        Contacto _c = (Contacto) objeto;
        conectar();
        Connection con = getConexion();
        String sentenciaSQL = "INSERT INTO Contacto VALUES (?,?,?,?)";
        PreparedStatement sentencia = crearSentencia(sentenciaSQL);
        sentencia.setString(1, _c.getNombre());
        sentencia.setString(2, _c.getDireccion());
        sentencia.setString(3, _c.getTelefono());
        sentencia.setInt(4, _c.getCliente());
         filas = actualizar(sentencia);
        return filas;
        
    }

    @Override
    public int buscarClienteId(String id) throws Exception{
        int clienteId = 0;
        conectar();
        Connection con = getConexion();
        String sentenciaSQL = "SELECT id FROM Cliente where nombre = ?";
        PreparedStatement sentencia = crearSentencia(sentenciaSQL);
        sentencia.setString(1, id);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            clienteId = rs.getInt("id");
        }
        return clienteId;
    }

    @Override
    public ArrayList<String> nombresClientes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
