package pagosempresa.model;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import pagosEmpresa.model.*;

public class LiquidacionTest {

    AgendaEmpleados empleados = new AgendaEmpleados();
    EmpleadoCategorizado empleado2;
    EmpleadoComisionado empleado1;
    EmpComisionadoCategorizado empleado3;
    EmpleadoAsalariado empleado4;
    Liquidacion liquidacion;
    EmpresaContratada empresa1;
    EmpresaContratada empresa2;


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
        liquidacion = new Liquidacion();
        
    }

    @Disabled
    @Test
    void testConsultarPagos() {
        liquidacion.consultarPagos(empleados, null);
    }

    @Test
    void testGetEmpleadosLiquidados() {

    }

    @Test
    void testGetFechaLiquidcion() {

    }

    @Test
    void testPagarServicio() {

    }

    @Test
    void testPagarServicioEmpleados() {

    }

    @Test
    void testPagarServicioEmpresas() {

    }
}
