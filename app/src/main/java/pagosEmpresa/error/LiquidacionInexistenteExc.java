package pagosEmpresa.error;

public class LiquidacionInexistenteExc extends Exception{

    public LiquidacionInexistenteExc() {
        super("no Existe la liquidacion Buscada");
    }
    
}
