package pagosEmpresa.model;

public class CategoriaEmpleado {
    private String nombreCategoria;
    private Double incrementoxCategoria;

    public CategoriaEmpleado(String nombreCategoria, Double incrementoxCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.incrementoxCategoria = incrementoxCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Double getIncrementoxCategoria() {
        return incrementoxCategoria;
    }

    public void setIncrementoxCategoria(Double incrementoxCategoria) {
        this.incrementoxCategoria = incrementoxCategoria;
    }

}
