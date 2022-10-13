package pagosEmpresa.model;

public class EmpleadoCategorizado extends Empleado{
    private CategoriaEmpleado categoria;

    public EmpleadoCategorizado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase,
            CategoriaEmpleado categoria) {
        super(nombre, apellido, cuil, cbu, sueldoBase);
        this.categoria = categoria;
    }

    public Double CalcularSalario() {
        return super.CalcularSalario() * ((categoria.getIncrementoxCategoria()/100)+1);
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

}
