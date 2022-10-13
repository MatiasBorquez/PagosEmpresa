package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pagosEmpresa.model.EmpleadoAsalariado;

public class EmpleadoAsalariadoTest {

    @Test
    void testConstructor(){
        EmpleadoAsalariado empleado = new EmpleadoAsalariado("nombre","apellido",123456,456789,20000.0);
        assertEquals("nombre", empleado.getNombre());
        assertEquals("apellido", empleado.getApellido());
        assertEquals(Integer.valueOf(123456), empleado.getCuil());
        assertEquals(Integer.valueOf(456789), empleado.getCbu());
        assertEquals(Double.valueOf(20000.0), empleado.getSueldoBase());
    }

    @Test
    void testCalcularSalario() {
        EmpleadoAsalariado empleado = new EmpleadoAsalariado("nombre","apellido",123456,456789,20000.0);
        empleado.setBono(20.0);
        assertEquals(Double.valueOf(20020.0), empleado.CalcularSalario());
    }
}
