package pagosEmpresa.model;

import java.util.*;

public class Empresa {
    private String nombre;
    private String ciut;
    private List<Empleado> listaEmpleado;
    private List<CategoriaEmpleado> listaCategorias;
    private List<Pagos> listaPagos;
    private List<EmpresasContratadas> listaEmpresasContratadas;

    public Empresa(String nombre, String ciut) {
        this.nombre = nombre;
        this.ciut = ciut;
        listaPagos = new ArrayList<>();
        listaCategorias = new ArrayList<>();
        listaEmpleado = new ArrayList<>();
    }
    
    public void agregarEmpleados(CategoriaEmpleado categoria, String nombre, String apellido, Integer cbu, String banco,
    Integer cuil, Double ventasRealizadas){
        listaEmpleado.add(new Empleado(categoria, nombre, apellido, cbu, banco, cuil, ventasRealizadas));
    }

    public void agregarCategoria(String nombre, Double incrementoPorventaExitosa, Double sueldoBase){
        listaCategorias.add(new CategoriaEmpleado(nombre, incrementoPorventaExitosa, sueldoBase));
    }
    
    public void agregarEmpresas(String nombre, String cuit, Double pago, String descripcion){
        listaEmpresasContratadas.add(new EmpresasContratadas(nombre, cuit, pago, descripcion));
    }

    public void RealizarPagos(){
        Pagos pago = new Pagos(listaEmpleado,listaEmpresasContratadas);
        pago.realizarPagos();
        listaPagos.add(pago);
        listaEmpresasContratadas.clear();
    }

    public List<Empleado> consultarPagoAEmpleados(){
        Pagos pago = new Pagos(listaEmpleado,null);
        return pago.pagosARealizarEmpleados();
    }

    public List<EmpresasContratadas> consultarPagoAEmpresas(){
        Pagos pago = new Pagos(null, listaEmpresasContratadas);
        return pago.pagosAEmpresasContratadas();
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

    public List<EmpresasContratadas> getListaEmpresasContratadas() {
        return listaEmpresasContratadas;
    }

    

}
