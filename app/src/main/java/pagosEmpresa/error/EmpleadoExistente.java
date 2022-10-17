package pagosEmpresa.error;

public class EmpleadoExistente extends Exception{

    public EmpleadoExistente(String empleado) {
        super("El empleado ya existe en la empresa"+empleado);
    }
    
}
