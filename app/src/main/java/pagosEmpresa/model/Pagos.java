package pagosEmpresa.model;

import java.util.*;

public class Pagos {
    private Date fecha;
    private List<Empleado> listaEmpleado;

    public Pagos(List<Empleado> lista) {
        listaEmpleado = lista;
    }

    public void realizarPagos(){
        for (Empleado empleado : listaEmpleado) {
            empleado.setPago(empleado.sueldo());
        }
        this.fecha = new Date();
    }

    public List<Empleado> pagosARealizar(){
        List<Empleado> listaEjemplo = listaEmpleado;
        for (Empleado empleado : listaEjemplo) {
            empleado.setPago(empleado.sueldo());
        }
        return listaEjemplo;
    }

    
    
}
