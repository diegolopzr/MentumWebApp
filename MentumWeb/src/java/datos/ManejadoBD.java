
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejadoBD {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String nombreIPServidor ="localhost";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=Mentum";
    private int puerto = 1433;
    private String usuario = "Mentum";
    private String pass = "123";
    private String nombreBD = "Mentum";
    private Connection conexion;

    public ManejadoBD() throws SQLException {
      //  this.url = url+nombreIPServidor+":"+puerto+"/"+nombreBD;
        this.conectar();
    }

    public ManejadoBD(String driver, String nombreIPServidor, String url, String usuario, String pass, String nombreBD) throws SQLException {
        this.driver = driver;
        this.nombreIPServidor = nombreIPServidor;
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
        this.nombreBD = nombreBD;
        this.conectar();
    }
    
    
    public void conectar() throws SQLException 
    {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void desconectar()
    {
        try {
            conexion.close();
        } catch (SQLException ex) {
            conexion = null;
        }
    }
    
    public PreparedStatement crearSentencia(String sql) throws Exception
    {
        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            return sentencia;
        } catch (SQLException ex) {
            Logger.getLogger(ManejadoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int actualizar (PreparedStatement sentencia) throws Exception
    {
        int resultado = 0;
        try {
            resultado = sentencia.executeUpdate();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(ManejadoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public ResultSet consultar(PreparedStatement sentencia) throws Exception
    {
        try {
            ResultSet resultado = sentencia.executeQuery();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(ManejadoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
