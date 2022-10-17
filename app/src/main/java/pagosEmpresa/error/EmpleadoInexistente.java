package pagosEmpresa.error;

public class EmpleadoInexistente extends Exception{

    public EmpleadoInexistente() {
        super("El empleado no existe en la base de datos");
    }
     
}
