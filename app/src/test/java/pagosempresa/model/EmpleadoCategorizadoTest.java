package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pagosEmpresa.model.*;

public class EmpleadoCategorizadoTest {
    @Test
    void testEmpleado(){
        EmpleadoCategorizado empleado = new EmpleadoCategorizado("nombre","apellido",123456,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
        assertEquals("nombre", empleado.getNombre());
        assertEquals("apellido", empleado.getApellido());
        assertEquals(Integer.valueOf(123456), empleado.getCuil());
        assertEquals(Integer.valueOf(456789), empleado.getCbu());
        assertEquals(Double.valueOf(20000.0), empleado.getSueldoBase());
        assertEquals("nombre", empleado.getCategoria().getNombreCategoria());
        assertEquals(Double.valueOf(20.0), empleado.getCategoria().getIncrementoxCategoria());
    }

    @Test
    void testCalcularSalario() {
        EmpleadoCategorizado empleado = new EmpleadoCategorizado("nombre","apellido",123456,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado.setBono(20.0);
        assertEquals(Double.valueOf(24024.0), empleado.CalcularSalario());
        
    }
}
