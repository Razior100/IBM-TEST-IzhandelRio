package bean;

import java.sql.Date;

public class Proveedor {

    private int id;
    private String nombre;
    private Date fecha;
    private String idCliente;



    public Proveedor(int id, String nombre, Date fecha, String idCliente){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.idCliente = idCliente;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
