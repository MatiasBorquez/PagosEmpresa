package pagosEmpresa.model;

import java.util.*;

public class Empresa {
    private String nombre;
    private String ciut;
    private List<Empleado> listaEmpleado;
    private List<CategoriaEmpleado> listaCategorias;
    private List<Pagos> listaPagos;

    public Empresa(String nombre, String ciut) {
        this.nombre = nombre;
        this.ciut = ciut;
        listaPagos = new ArrayList<>();
        listaCategorias = new ArrayList<>();
        listaEmpleado = new ArrayList<>();
    }
    
    public void agregarEmpleados(CategoriaEmpleado categoria, String nombre, String apellido, Integer cbu, 
    String banco, Integer cuil, Double sueldoBasico, Integer antiguedad){
        listaEmpleado.add(new Empleado(categoria, nombre, apellido, cbu, banco, cuil, sueldoBasico, antiguedad));
    }

    public void agregarCategoria(String nombre, Double incrementoPorCargo, Double incrementoPorAntiguedad){
        listaCategorias.add(new CategoriaEmpleado(nombre, incrementoPorCargo, incrementoPorAntiguedad));
    }

    public void RealizarPagos(){
        Pagos pago = new Pagos(listaEmpleado);
        pago.realizarPagos();
        listaPagos.add(pago);
    }

    public List<Empleado> consultarPagoARealizar(){
        Pagos pago = new Pagos(listaEmpleado);
        return pago.pagosARealizar();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiut() {
        return ciut;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public List<CategoriaEmpleado> getListaCategorias() {
        return listaCategorias;
    }

    public List<Pagos> getListaPagos() {
        return listaPagos;
    }

    public void setListaCategorias(List<CategoriaEmpleado> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public void setListaPagos(List<Pagos> listaPagos) {
        this.listaPagos = listaPagos;
    }

    

}
