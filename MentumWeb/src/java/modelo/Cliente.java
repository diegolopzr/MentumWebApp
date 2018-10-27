package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente implements IEntidades {

    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fecha_creacion;
    private ArrayList<Contacto> Lcontactos;

    public Cliente() {
        this.id = 0;
        this.nombre = null;
        this.direccion = null;
        this.telefono = null;
        this.fecha_creacion = null;
    }

    public Cliente(int id, String _nombre, String _direccion, String _telefono, Date fecha_creacion) {
        this.id = 0;
        this.nombre = _nombre;
        this.direccion = _direccion;
        this.telefono = _telefono;
        this.fecha_creacion = fecha_creacion;
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

    public ArrayList<Contacto> getLcontactos() {
        return Lcontactos;
    }

    public void setLcontactos(ArrayList<Contacto> Lcontactos) {
        this.Lcontactos = Lcontactos;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date convertirFecha(String fecha) {
        String[] _fecha = fecha.split("-");

        Date _f;
        _f = new Date(Integer.parseInt(_fecha[0]) - 1900, Integer.parseInt(_fecha[1]), Integer.parseInt(_fecha[2]));

        return _f;
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
