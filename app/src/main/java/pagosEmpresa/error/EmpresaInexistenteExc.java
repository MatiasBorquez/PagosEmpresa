package pagosEmpresa.error;

public class EmpresaInexistenteExc extends Exception{

    public EmpresaInexistenteExc() {
        super("La empresa buscada no existe");
    }
    
}
