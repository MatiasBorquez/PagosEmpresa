package pagosEmpresa.model;

import java.time.LocalDate;
import java.util.List;

public class EmpleadoComisionado extends Empleado{

    private List<Comision> comisiones;
    private static final Double multiplicadorComision = 1.5;
    
    public EmpleadoComisionado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase,
            List<Comision> comisiones) {
        super(nombre, apellido, cuil, cbu, sueldoBase);
        this.comisiones = comisiones;
    }

    public EmpleadoComisionado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase) {
        super(nombre, apellido, cuil, cbu, sueldoBase);
    }

    public void AddComision(LocalDate fechaComision, Double valorComision){
        Comision nuevaComision = new Comision(fechaComision, valorComision);
        comisiones.add(nuevaComision);
    }

    @Override
    public Double CalcularSalario() {
        return super.getSueldoBase() + super.getBono() + procesarComision();
    }

    private Double procesarComision(){
        double comisionActual = 0.0;
        for (Comision comision : comisiones) {
            comisionActual += comision.getValorComision();
        }
        return comisionActual * multiplicadorComision;
    }

    public List<Comision> getComisiones() {
        return comisiones;
    }

    public void setComisiones(List<Comision> comisiones) {
        this.comisiones = comisiones;
    }

    
    
}
