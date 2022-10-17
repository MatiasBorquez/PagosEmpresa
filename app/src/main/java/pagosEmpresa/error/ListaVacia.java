package pagosEmpresa.error;

public class ListaVacia extends Exception{

    public ListaVacia() {
        super("La lista en la que quiere interactuar esta vacia");
    }
    
}
