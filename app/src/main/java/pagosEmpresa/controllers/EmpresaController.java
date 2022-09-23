package pagosEmpresa.controllers;

import java.util.*;

import javax.swing.JOptionPane;

import pagosEmpresa.model.CategoriaEmpleado;
import pagosEmpresa.model.Empleado;
import pagosEmpresa.model.Empresa;
import pagosEmpresa.model.EmpresasContratadas;
import pagosEmpresa.model.Pagos;

public class EmpresaController implements IEmpresaController{
    /*public void agregarEmpleados(CategoriaEmpleado categoria, String nombre, String apellido, Integer cbu, String banco,
    Integer cuil, Integer antiguedad, Double ventasRealizadas){*/

    private Empresa empresa;

    

    public EmpresaController() {
        String nombre = JOptionPane.showInputDialog(null,"Nombre de la empresa");
        String cuit = JOptionPane.showInputDialog(null,"Cuit de la empresa");
        empresa = new Empresa(nombre, cuit);
    }

    @Override
    public void AgregarEmpleados() {
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del empleado");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado");
        Integer cbu = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cbu del empleado"));
        String banco = JOptionPane.showInputDialog(null, "Ingrese el banco del empleado");
        Integer cuil = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cuil del empleado"));
        Double ventasRealizadas = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el ventas realizadas del empleado"));
        List<CategoriaEmpleado> categorias = empresa.getListaCategorias();
        Integer seleccionCategoria = Integer.parseInt(JOptionPane.showInputDialog("Introdusca id de la categoria deseada", categorias));
        CategoriaEmpleado categoria = categorias.get(seleccionCategoria - 1);
        empresa.agregarEmpleados(categoria, nombre, apellido, cbu, banco, cuil, ventasRealizadas);

    }

    @Override
    public void AñadirEmpresasContratadas() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la empresa");
        String cuit = JOptionPane.showInputDialog(null, "Ingrese el cuit de la empresa");
        Double pago = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el pago a realizar la empresa"));
        String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripcion de lo realizado por la empresa");
        empresa.agregarEmpresas(nombre, cuit, pago, descripcion);
    }

    @Override
    public void AñadirCategorias() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la categoria");
        Double incrementoPorVentaExitosa = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nombre de la categoria"));
        Double sueldoBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nombre de la categoria"));
        empresa.agregarCategoria(nombre, incrementoPorVentaExitosa, sueldoBase);
        
    }

    @Override
    public void consultarPagos() {
        Double pagototal = 0.0;
        List<Empleado> listEmpleado = empresa.consultarPagoAEmpleados();
        List<EmpresasContratadas> listEmpresas = empresa.consultarPagoAEmpresas();
        JOptionPane.showMessageDialog(null, listEmpleado, "Empleado", 0);
        JOptionPane.showMessageDialog(null, listEmpresas, "Empresas", 0);
        for (EmpresasContratadas empresasContratadas : listEmpresas) {
            pagototal += empresasContratadas.getPago();
        }
        for (Empleado empleado : listEmpleado) {
            pagototal += empleado.getSueldoBruto();
        }
        JOptionPane.showMessageDialog(null,"Pago total: " +pagototal);
    }

    @Override
    public void RealizarPagos() {
        empresa.RealizarPagos();
        Integer ultimo = empresa.getListaEmpleado().size();
        empresa.getListaEmpleado().get(ultimo);
        JOptionPane.showMessageDialog(null, empresa.getListaEmpleado().get(ultimo));
        JOptionPane.showMessageDialog(null, empresa.getListaEmpresasContratadas().get(ultimo));
        JOptionPane.showMessageDialog(null, empresa.getListaPagos());
    }

    @Override
    public void RevisarPagosRealizados() {
        for (Pagos pago : empresa.getListaPagos()) {
            JOptionPane.showMessageDialog(null, pago.getListaEmpleado());
            JOptionPane.showMessageDialog(null, pago.getListaEmpresasContratadas());
            JOptionPane.showMessageDialog(null, pago.getPagoTotal());
        }
    }

    @Override
    public void ReavisarEmpleados() {
        JOptionPane.showMessageDialog(null, empresa.getListaEmpleado());
        
    }
    
}
