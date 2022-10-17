package pagosEmpresa.model;

import java.util.*;

import pagosEmpresa.error.EmpleadoExistente;
import pagosEmpresa.error.EmpleadoInexistente;

public class AgendaEmpleados{
    private Set<Empleado> empleados;

    public AgendaEmpleados() {
        empleados = new HashSet<>();
    }

    public void agregarEmpleado(Empleado empleado){
        if (this.existeEmpleado(empleado.getCuil())) {
            try {
                throw new EmpleadoExistente(empleado.getApellido());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            empleados.add(empleado);
        }
        
    }

    public void modificarEmpleado(Empleado empleadoModificar, Empleado empleadoModificado) {
        eliminarEmpleado(empleadoModificar.getCuil());
        agregarEmpleado(empleadoModificado);
    }

    public void eliminarEmpleado(Integer cuil) {
        Empleado empleado;
        if (existeEmpleado(cuil)) {
            empleado = encontrarEmpleado(cuil);
            empleados.remove(empleado);
        } else {
            try {
                throw new EmpleadoInexistente();
            } catch (EmpleadoInexistente e) {
                e.printStackTrace();
            }
        }
    }

    public Integer cantidadDeEmpleados(){
        return empleados.size();
    }

    public Empleado encontrarEmpleado(Integer cuil){
        Empleado empleado = null;
        if(existeEmpleado(cuil)){
            for (Empleado e : empleados) {
                if (e.getCuil().equals(cuil)) {
                    empleado = e;
                }
            }
        }
        return empleado;
    }

    public Boolean existeEmpleado(Integer cuil){
        Boolean existe = false;
        for (Empleado empleado : empleados) {
            if (empleado.getCuil().equals(cuil)) {
                existe = true;
            }
        }
        return existe;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }
    
}
