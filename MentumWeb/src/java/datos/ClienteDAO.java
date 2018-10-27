package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.IEntidades;

public class ClienteDAO extends ManejadoBD implements IDAOPersistencia {

    public ClienteDAO() throws SQLException {
    }


    public int crear(IEntidades objeto) throws Exception {
        int filas = 0;
        Cliente _c = (Cliente) objeto;
        conectar();
        Connection con = getConexion();
        String sentenciaSQL = "INSERT INTO cliente VALUES (?,?,?,?)";
        PreparedStatement sentencia = crearSentencia(sentenciaSQL);
        sentencia.setString(1, _c.getNombre());
        sentencia.setString(2, _c.getDireccion());
        sentencia.setString(3, _c.getTelefono());
        sentencia.setDate(4, _c.getFecha_creacion());
        filas = actualizar(sentencia);
        return filas;
    }

    @Override
    public ArrayList<String> nombresClientes() throws Exception {
        ArrayList<String> _lista = new ArrayList<String>();
        conectar();
        Connection con = getConexion();
        String sentenciaSQL = "SELECT nombre FROM Cliente ";
        PreparedStatement sentencia = crearSentencia(sentenciaSQL);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            _lista.add(nombre);
        }
        return _lista;
    }

    @Override
    public int buscarClienteId(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
