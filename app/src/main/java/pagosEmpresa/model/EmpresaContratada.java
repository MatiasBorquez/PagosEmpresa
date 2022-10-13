package pagosEmpresa.model;

import java.util.List;

public class EmpresaContratada {
    private String nombre;
    private String cuit;
    private String descripcion;
    private Double costoServicio;
    private Boolean pagado;

    public EmpresaContratada(String nombre, String cuit, String descripcion) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.descripcion = descripcion;
        this.costoServicio = 0.0;
        pagado = false;
    }

    public EmpresaContratada(String nombre, String cuit, String descripcion, Double costoServicio) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.descripcion = descripcion;
        this.costoServicio = costoServicio;
        pagado = false;
    }

    public Double pagarServicio() {
        pagado = true;
        return costoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(Double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

}
