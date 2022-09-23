package pagosEmpresa.model;

public class EmpresasContratadas {
    private String nombre;
    private String cuit;
    private Double pago;
    private String descripcion;

    public EmpresasContratadas(String nombre, String cuit, Double pago, String descripcion) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.pago = pago;
        this.descripcion = descripcion;
    }

    public Double getPago() {
        return pago;
    }

    

    
}
