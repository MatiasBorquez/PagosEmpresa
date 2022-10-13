package pagosEmpresa.model;

import java.util.List;

public interface Pago {
    public void pagarServicio(List<Object> empleados, List<EmpresaContratada> empresas);
    public Double consultarPagos(List<Object> empleados, List<EmpresaContratada> empresas);
}
