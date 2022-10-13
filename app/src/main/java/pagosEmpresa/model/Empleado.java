package pagosEmpresa.model;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private Integer cuil;
    private Integer cbu;
    private Double bono;
    private Double salario;
    private Double sueldoBase; 
 
    public Empleado(String nombre, String apellido, Integer cuil, Integer cbu, Double sueldoBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.cbu = cbu;
        this.sueldoBase = sueldoBase;
    }

    public Double CalcularSalario(){
        return sueldoBase + bono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCuil() {
        return cuil;
    }

    public void setCuil(Integer cuil) {
        this.cuil = cuil;
    }

    public Integer getCbu() {
        return cbu;
    }

    public void setCbu(Integer cbu) {
        this.cbu = cbu;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }



    public Double getSueldoBase() {
        return sueldoBase;
    }



    public void setSueldoBase(Double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    
    
}
