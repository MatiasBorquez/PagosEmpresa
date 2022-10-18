package pagosempresa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    ListasEmpresasContratadas empresas;
    Double pagos;

    @BeforeEach
    public void beforeEach(){
        empleado1 = new EmpleadoComisionado("nombre","apellido",123456,456789,20000.0);
        empleado2 = new EmpleadoCategorizado("nombre","apellido",654321,654321,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado3 = new EmpComisionadoCategorizado("nombre","apellido",456789,456789,20000.0,new CategoriaEmpleado("nombre", 20.0));
        empleado4 = new EmpleadoAsalariado("nombre","apellido",987654,654321,20000.0);
        empleado1.AddComision(LocalDate.now(), 20.0);
        empleado3.AddComision(LocalDate.now(), 30.0);
        empleado1.setBono(20.0);
        empleado2.setBono(20.0);
        empleado3.setBono(20.0);
        empleado4.setBono(20.0);
        empleados.agregarEmpleado(empleado1);
        empleados.agregarEmpleado(empleado2);
        empleados.agregarEmpleado(empleado3);
        empleados.agregarEmpleado(empleado4);
        liquidacion = new Liquidacion();
        empresa1 = new EmpresaContratada("nmbre", "a1567", "a",3500.0);
        empresa2 = new EmpresaContratada("null", "null", "null", 2000.0);
        empresas = new ListasEmpresasContratadas();
        empresas.agregarEmpresaContratada(empresa1);
        empresas.agregarEmpresaContratada(empresa2);
        pagos = empleado1.CalcularSalario()+empleado2.CalcularSalario()+empleado3.CalcularSalario()+empleado4.CalcularSalario()+empresa1.getCostoServicio()+empresa2.getCostoServicio();

    }

    @Test
    void testConsultarPagos() {
        assertEquals( liquidacion.consultarPagos(empleados, empresas), pagos);
    }

    @Test
    void testPagarServicio() {
        liquidacion.pagarServicio(empleados, empresas);
        assertEquals(liquidacion.getTotal(), pagos);
    }
}
