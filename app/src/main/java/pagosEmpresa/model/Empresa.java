package pagosEmpresa.model;

public class Empresa {
    private String nombre;
    private String cuit;
    private AgendaEmpleados empleados;
    private ListasEmpresasContratadas empresas;
    private LibroDeLiquidaciones liquidaciones;
    private static Empresa empresa;
    private Empresa (){
    }
    public static Empresa intancia() {
        if (empresa == null){
            empresa = new Empresa();
        }
        return empresa;
    }
    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        empleados = new AgendaEmpleados();
        empresas = new ListasEmpresasContratadas();
        liquidaciones = new LibroDeLiquidaciones();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.agregarEmpleado(empleado);
    }

    public void agregarEmpresaContratada(EmpresaContratada empresa){
        empresas.agregarEmpresaContratada(empresa);
    }
    
    public void RealizarLiquidacion(){
        liquidaciones.agregarLiquidacion(empresas, empleados);
    }

    public void eliminarEmpleado(Integer cuil){
        empleados.eliminarEmpleado(cuil);
    }

    public void eliminarEmpresaContratada(Integer cuil){
        empresas.eliminarEmpresaContratada(cuit);
    }

    public void modificarEmpleado(Empleado empleadoModificar, Empleado empleadoModificado){
        empleados.modificarEmpleado(empleadoModificar, empleadoModificado);
    }

    public void modificarEmpresa(EmpresaContratada empresaModificar, EmpresaContratada empleadoModificada){
        empresas.modificarEmpresaContratada(empresaModificar, empresaModificar);
    }

    public void buscarEmpleado(Integer cuil){
        empleados.encontrarEmpleado(cuil);
    }

    public void buscarEmpresa(String cuit){
        empresas.encontrarEmpresaContratada(cuit);
    }
}
