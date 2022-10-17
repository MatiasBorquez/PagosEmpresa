package pagosEmpresa.error;

public class PagoNegativo extends Exception{

    public PagoNegativo(String message) {
        super("El pago es negativo:" + message);
    }
    
}
