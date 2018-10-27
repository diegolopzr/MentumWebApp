
package modelo;


public class Contacto implements IEntidades{
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private int id_cliente;

    public Contacto() {
    }

    public Contacto(String _nombre, String _direccion, String _telefono, int _cliente) {
        this.id = 0;
        this.nombre = _nombre;
        this.direccion = _direccion;
        this.telefono = _telefono;
        this.id_cliente = _cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCliente() {
        return id_cliente;
    }

    public void setCliente(int cliente) {
        this.id_cliente = cliente;
    }

   
    @Override
    public Cliente buscarClienteId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(IEntidades objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
