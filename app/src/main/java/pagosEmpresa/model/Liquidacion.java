package pagosEmpresa.model;

import java.time.LocalDate;

public class Liquidacion implements Pago {
    private LocalDate fechaLiquidcion;
    private AgendaEmpleados empleadosLiquidados;
    private ListasEmpresasContratadas empresasLiquidadas;
    private Double Total;

    public Liquidacion(LocalDate fechaLiquidcion) {
        this.fechaLiquidcion = fechaLiquidcion;
    }

    public Liquidacion() {
        fechaLiquidcion = LocalDate.now();
    }

    public LocalDate getFechaLiquidcion() {
        return fechaLiquidcion;
    }

    public void setFechaLiquidcion(LocalDate fechaLiquidcion) {
        this.fechaLiquidcion = fechaLiquidcion;
    }

    public AgendaEmpleados getEmpleadosLiquidados() {
        return empleadosLiquidados;
    }

    public void setEmpleadosLiquidados(AgendaEmpleados empleadosLiquidados) {
        this.empleadosLiquidados = empleadosLiquidados;
    }

    @Override
    public Double consultarPagos(AgendaEmpleados empleados, ListasEmpresasContratadas empresas) {
        pagarServicioEmpleados(empleados);
        pagarServicioEmpresas(empresas);
        return Total;
    }

    @Override
    public void pagarServicio(AgendaEmpleados empleados, ListasEmpresasContratadas empresas) {
        pagarServicioEmpleados(empleados);
        pagarServicioEmpresas(empresas);

    }

    private void pagarServicioEmpleados(AgendaEmpleados empleados) {
        for (Empleado empleado : empleados.getEmpleados()) {
            empleado.setSalario(empleado.CalcularSalario());
            empleadosLiquidados.agregarEmpleado(empleado);
            Total += ((Empleado) empleado).getSalario();
        }

    }

    private void pagarServicioEmpresas(ListasEmpresasContratadas empresas) {
        for (EmpresaContratada empresa : empresas.getEmpresas()) {
            empresa.pagarServicio();
            empresasLiquidadas.agregarEmpresaContratada(empresa);
            Total += empresa.getCostoServicio();
        }
        empresas.LimpiarLista();
    }

}
