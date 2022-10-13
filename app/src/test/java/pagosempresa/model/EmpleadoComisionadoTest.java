package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.Test;

import pagosEmpresa.model.*;

public class EmpleadoComisionadoTest {
    @Test
    void testAddComision() {
        Comision com1 = new Comision(LocalDate.of(2000, 10, 20), 20.0);
        assertEquals(LocalDate.of(2000, 10, 20), com1.getFechaComision());
        assertEquals(Double.valueOf(20.0), com1.getValorComision());
    }

    @Test
    void testEmpleadoComisionado(){
        EmpleadoComisionado empleado = new EmpleadoComisionado("nombre","apellido",123456,456789,20000.0);
        assertEquals("nombre", empleado.getNombre());
        assertEquals("apellido", empleado.getApellido());
        assertEquals(Integer.valueOf(123456), empleado.getCuil());
        assertEquals(Integer.valueOf(456789), empleado.getCbu());
        assertEquals(Double.valueOf(20000.0), empleado.getSueldoBase());
    }

    @Test
    void testCalcularSalario() {
        EmpleadoComisionado empleado = new EmpleadoComisionado("nombre","apellido",123456,456789,20000.0);
        empleado.setBono(20.0);
        Comision com1 = new Comision(LocalDate.now(), 20.0);
        List<Comision> comisiones = new ArrayList<>();
        comisiones.add(com1);
        empleado.setComisiones(comisiones);
        assertEquals(Double.valueOf(20050), empleado.CalcularSalario());
        
    }
}
