package pagosEmpresa.model;

public class Empleado {
    private CategoriaEmpleado categoria;
    private String nombre;
    private String apellido;
    private Integer cbu;
    private String banco;
    private Integer cuil;
    private Double sueldoBasico;
    private Double pago;
    private Integer antiguedad;

    public Empleado(CategoriaEmpleado categoria, String nombre, String apellido, Integer cbu, String banco,
            Integer cuil, Double sueldoBasico, Integer antiguedad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cbu = cbu;
        this.banco = banco;
        this.cuil = cuil;
        this.sueldoBasico = sueldoBasico;
    }

    public Double sueldo(){
        return sueldoBasico * categoria.getIncrementoPorAntiguedad() * categoria.getIncrementoSalarioCategoria();
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    

}
