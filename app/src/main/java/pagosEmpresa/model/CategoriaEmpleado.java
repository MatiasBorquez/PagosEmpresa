package pagosEmpresa.model;

public class CategoriaEmpleado {
    private String nombreCategoria;
    private Double incrementoVentaExistosas;
    private Double sueldoBase;
    private Integer id;
    private static Integer count = 1;

    public CategoriaEmpleado(String nombreCategoria, Double incrementoVentaExistosas, Double sueldoBase) {
        this.nombreCategoria = nombreCategoria;
        this.incrementoVentaExistosas = incrementoVentaExistosas;
        this.sueldoBase = sueldoBase;
        id =count++;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public Double getIncrementoVentaExistosas() {
        return incrementoVentaExistosas;
    }

    public Double getSueldoBase() {
        return sueldoBase;
    }
    
    

}
