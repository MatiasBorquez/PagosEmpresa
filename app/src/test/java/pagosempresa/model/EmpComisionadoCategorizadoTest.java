package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import pagosEmpresa.model.*;

public class EmpComisionadoCategorizadoTest {

    @Test
    void EmpComisionadoCategorizado(){
        EmpComisionadoCategorizado empleado = new EmpComisionadoCategorizado("nombre","apellido",123456,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
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
        EmpComisionadoCategorizado empleado = new EmpComisionadoCategorizado("nombre","apellido",123456,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado.setBono(20.0);
        Comision com1 = new Comision(LocalDate.now(), 20.0);
        List<Comision> comisiones = new ArrayList<>();
        comisiones.add(com1);
        empleado.setComisiones(comisiones);
        assertEquals(Double.valueOf(24060), empleado.CalcularSalario());
        
    }
}
