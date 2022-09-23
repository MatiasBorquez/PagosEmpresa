package pagosEmpresa.model;

public class Empleado {
    private CategoriaEmpleado categoria;
    private String nombre;
    private String apellido;
    private Integer cbu;
    private String banco;
    private Integer cuil;
    private Double sueldoNeto;
    private Double sueldoBruto;
    private Double impuestosPagados;
    private Double impuestosCobrados = 0.2;
    private Double ventasRealizadas;

    public Empleado(CategoriaEmpleado categoria, String nombre, String apellido, Integer cbu, String banco,
            Integer cuil, Double ventasRealizadas) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cbu = cbu;
        this.banco = banco;
        this.cuil = cuil;
        this.ventasRealizadas = ventasRealizadas;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public Double totalAPagar(){
        this.sueldoBruto = ((categoria.getSueldoBase() + (categoria.getIncrementoVentaExistosas() * ventasRealizadas) ));
        this.sueldoNeto = sueldoBruto * impuestosCobrados;
        this.impuestosPagados = sueldoBruto - sueldoNeto;
        return sueldoBruto;
    }



    public Double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(Double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public Double getSueldoNeto() {
        return sueldoNeto;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public Double getImpuestosPagados() {
        return impuestosPagados;
    }

    

    
}
