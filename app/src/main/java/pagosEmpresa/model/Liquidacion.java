package pagosEmpresa.model;

import java.time.LocalDate;
import java.util.List;

public class Liquidacion implements Pago {
    private LocalDate fechaLiquidcion;
    private List<Empleado> empleadosLiquidados;
    private List<EmpresaContratada> empresasLiquidadas;
    private Double Total;

    public Liquidacion(LocalDate fechaLiquidcion, List<Empleado> empleadosLiquidados,
            List<EmpresaContratada> empresasLiquidadas) {
        this.fechaLiquidcion = fechaLiquidcion;
        this.empleadosLiquidados = empleadosLiquidados;
        this.empresasLiquidadas = empresasLiquidadas;
    }

    public LocalDate getFechaLiquidcion() {
        return fechaLiquidcion;
    }

    public void setFechaLiquidcion(LocalDate fechaLiquidcion) {
        this.fechaLiquidcion = fechaLiquidcion;
    }

    public List<Empleado> getEmpleadosLiquidados() {
        return empleadosLiquidados;
    }

    public void setEmpleadosLiquidados(List<Empleado> empleadosLiquidados) {
        this.empleadosLiquidados = empleadosLiquidados;
    }

    @Override
    public Double consultarPagos(List<Object> empleados, List<EmpresaContratada> empresas) {
        pagarServicioEmpleados(empleados);
        pagarServicioEmpresas(empresas);
        return Total;
    }

    @Override
    public void pagarServicio(List<Object> empleados, List<EmpresaContratada> empresas) {
        pagarServicioEmpleados(empleados);
        pagarServicioEmpresas(empresas);
        
    }

    public void pagarServicioEmpleados(List<Object> empleados) {
        for (Object empleado : empleados) {
            ((Empleado) empleado).setSalario(((Empleado) empleado).CalcularSalario());
            empleadosLiquidados.add((Empleado) empleado);
            Total += ((Empleado)empleado).getSalario();
        }

    }

    public void pagarServicioEmpresas(List<EmpresaContratada> empresas) {
        for (EmpresaContratada empresa : empresas) {
            empresa.pagarServicio();
            empresasLiquidadas.add(empresa);
            Total += empresa.getCostoServicio();
        }
        
    }

}
