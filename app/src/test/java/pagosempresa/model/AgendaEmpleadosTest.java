package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pagosEmpresa.model.*;

public class AgendaEmpleadosTest {

    AgendaEmpleados empleados = new AgendaEmpleados();
    EmpleadoCategorizado empleado2;
    EmpleadoComisionado empleado1;
    EmpComisionadoCategorizado empleado3;
    EmpleadoAsalariado empleado4;
    @BeforeEach
    public void beforeEach(){
        empleado1 = new EmpleadoComisionado("nombre","apellido",123456,456789,20000.0);
        empleado2 = new EmpleadoCategorizado("nombre","apellido",654321,654321,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado3 = new EmpComisionadoCategorizado("nombre","apellido",456789,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado4 = new EmpleadoAsalariado("nombre","apellido",987654,654321,20000.0);
        empleados.agregarEmpleado(empleado1);
        empleados.agregarEmpleado(empleado2);
        empleados.agregarEmpleado(empleado3);
        empleados.agregarEmpleado(empleado4);
    }

    @Test
    void testAgregarEmpleado() {
        assertEquals(empleados.encontrarEmpleado(empleado1.getCuil()).getCuil(), Integer.valueOf(123456));
        assertEquals(empleados.encontrarEmpleado(empleado2.getCuil()).getCuil(), Integer.valueOf(654321));
    }

    @Test
    void testCantidadDeEmpleados() {
        assertEquals(empleados.encontrarEmpleado(empleado3.getCuil()).getCuil(), Integer.valueOf(456789));
        assertEquals(empleados.encontrarEmpleado(empleado4.getCuil()).getCuil(), Integer.valueOf(987654));
    }

    @Test
    void testEliminarEmpleado() {
        empleados.eliminarEmpleado(Integer.valueOf(123456));
        assertEquals(empleados.cantidadDeEmpleados(), Integer.valueOf(3));
    }

    @Test
    void testEncontrarEmpleado() {
        EmpleadoComisionado empleado5 = new EmpleadoComisionado("nombre","apellido",147258,456789,20000.0);
        empleado5.setBono(20.0);
        Comision com1 = new Comision(LocalDate.now(), 20.0);
        List<Comision> comisiones = new ArrayList<>();
        comisiones.add(com1);
        (empleado5).setComisiones(comisiones);
        empleados.agregarEmpleado(empleado5);
        assertEquals((empleados.encontrarEmpleado(empleado5.getCuil())).CalcularSalario(), empleado5.CalcularSalario());
        assertEquals(((EmpleadoCategorizado) empleados.encontrarEmpleado(empleado2.getCuil())).getCategoria().getNombreCategoria(), "nombre");
    
    }

    @Test
    void testModificarEmpleado() {
        EmpleadoComisionado empleado5 = new EmpleadoComisionado("nombre","apellido",147258,456789,20000.0);
        empleados.modificarEmpleado(empleado1, empleado5);
        assertEquals(empleados.existeEmpleado(147258), Boolean.valueOf(true));
        assertEquals(empleados.existeEmpleado(123456), Boolean.valueOf(false));
        assertEquals(empleado5, empleados.encontrarEmpleado(Integer.valueOf(147258)));
    }
}
