package pagosEmpresa.model;

import java.util.List;

public class EmpComisionadoCategorizado extends EmpleadoComisionado{
    private CategoriaEmpleado categoria;

    public EmpComisionadoCategorizado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase,
            CategoriaEmpleado categoria) {
        super(nombre, apellido, cuil, cbu, sueldoBase);
        this.categoria = categoria;
    }

    public EmpComisionadoCategorizado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase,
            List<Comision> comisiones, CategoriaEmpleado categoria) {
        super(nombre, apellido, cuil, cbu, sueldoBase, comisiones);
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
