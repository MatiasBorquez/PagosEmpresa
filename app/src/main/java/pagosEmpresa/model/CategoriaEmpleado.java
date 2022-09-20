package pagosEmpresa.model;

public class CategoriaEmpleado {
    private String nombreCategoria;
    private Double incrementoSalarioCategoria;
    private Double incrementoPorAntiguedad;
    
    public CategoriaEmpleado(String nombreCategoria, Double incrementoSalarioCategoria,
            Double incrementoPorAntiguedad) {
        this.nombreCategoria = nombreCategoria;
        this.incrementoSalarioCategoria = incrementoSalarioCategoria;
        this.incrementoPorAntiguedad = incrementoPorAntiguedad;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public Double getIncrementoSalarioCategoria() {
        return incrementoSalarioCategoria;
    }

    public Double getIncrementoPorAntiguedad() {
        return incrementoPorAntiguedad;
    }
    
    

}
