package pagosEmpresa.model;

import java.util.*;

public class Pagos {
    private Date fecha;
    private List<Empleado> listaEmpleado;
    private List<EmpresasContratadas> listaEmpresasContratadas;
    private Double pagoTotal = 0.0;
    private Double pagoTotalEmpleados = 0.0;
    private Double pagoTotalImpuestos = 0.0;
    private Double pagoTotalEmpresas = 0.0;

    public Pagos(List<Empleado> lEmpleados, List<EmpresasContratadas> lEmpresasContratadas) {
        listaEmpleado = lEmpleados;
        listaEmpresasContratadas = lEmpresasContratadas;
    }

    public void realizarPagos(){
        for (Empleado empleado : listaEmpleado) {
            pagoTotal += empleado.totalAPagar();
            pagoTotalEmpleados += empleado.getSueldoNeto();
            pagoTotalImpuestos += empleado.getImpuestosPagados();
        }
        for (EmpresasContratadas empresasContratadas : listaEmpresasContratadas) {
            pagoTotal += empresasContratadas.getPago();
            pagoTotalEmpresas += empresasContratadas.getPago();
        }
        this.fecha = new Date();
    }

    public List<Empleado> pagosARealizarEmpleados(){
        List<Empleado> listaEjemploEmpleados = listaEmpleado;
        for (Empleado empleado : listaEjemploEmpleados) {
            pagoTotal += empleado.totalAPagar();
            pagoTotalEmpleados += empleado.getSueldoNeto();
            pagoTotalImpuestos += empleado.getImpuestosPagados();
        }
        return listaEjemploEmpleados;
    }

    public List<EmpresasContratadas> pagosAEmpresasContratadas(){
        List<EmpresasContratadas> listaEjemploEmpresas = listaEmpresasContratadas;
        for (EmpresasContratadas empresasContratadas : listaEjemploEmpresas) {
            pagoTotal += empresasContratadas.getPago();
            pagoTotalEmpresas += empresasContratadas.getPago();
        }
        return listaEjemploEmpresas;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public List<EmpresasContratadas> getListaEmpresasContratadas() {
        return listaEmpresasContratadas;
    }

    public Double getPagoTotal() {
        return pagoTotal;
    }

    public Double getPagoTotalEmpleados() {
        return pagoTotalEmpleados;
    }

    public Double getPagoTotalImpuestos() {
        return pagoTotalImpuestos;
    }

    public Double getPagoTotalEmpresas() {
        return pagoTotalEmpresas;
    }

    
    
}
