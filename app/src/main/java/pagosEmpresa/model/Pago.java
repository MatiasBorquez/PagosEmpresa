package pagosEmpresa.model;

import java.util.List;

public interface Pago {
    public void pagarServicio(AgendaEmpleados empleados, ListasEmpresasContratadas empresas);
    public Double consultarPagos(AgendaEmpleados empleados, ListasEmpresasContratadas empresas);
}
