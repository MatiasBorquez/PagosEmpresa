package pagosEmpresa.model;

import java.time.LocalDate;
import java.util.*;

import pagosEmpresa.error.LiquidacionInexistenteExc;

public class LibroDeLiquidaciones {
    private Set<Liquidacion> liquidaciones;
    
    public LibroDeLiquidaciones() {
        liquidaciones = new HashSet<>();
    }

    public void agregarLiquidacion(ListasEmpresasContratadas empresas, AgendaEmpleados empleados){
        Liquidacion liquidacion = new Liquidacion();
        
        try {
            if ((this.existeLiquidacion(liquidacion.getFechaLiquidcion()))) {
                liquidacion.pagarServicio(empleados, empresas);
                liquidaciones.add(liquidacion);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarLiquidacion(ListasEmpresasContratadas empresas, AgendaEmpleados empleados, LocalDate fecha){
        Liquidacion liquidacion = new Liquidacion(fecha);
        try {
            if ((this.existeLiquidacion(liquidacion.getFechaLiquidcion()))) {
                liquidacion.pagarServicio(empleados, empresas);
                liquidaciones.add(liquidacion);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarLiquidacion(LocalDate fecha) {
        Liquidacion liquidacion;
        try {
            if (existeLiquidacion(fecha)) {
                liquidacion = encontrarLiquidacion(fecha);
                liquidaciones.remove(liquidacion);
            }
        } catch (LiquidacionInexistenteExc e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Integer cantidadDeLiquidacion(){
        return liquidaciones.size();
    }

    public Liquidacion encontrarLiquidacion(LocalDate fecha){
        Liquidacion liquidacion = null;
        try {
            if(existeLiquidacion(fecha)){
                for (Liquidacion e : liquidaciones) {
                    if (e.getFechaLiquidcion().equals(fecha)) {
                        liquidacion = e;
                    }
                }
            }
        } catch (LiquidacionInexistenteExc e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return liquidacion;
    }

    public Boolean existeLiquidacion(LocalDate fecha) throws LiquidacionInexistenteExc{
        Boolean existe = false;
        for (Liquidacion liquidacion : liquidaciones) {
            if ((liquidacion.getFechaLiquidcion().getMonth()).equals(fecha.getMonth())) {
                if (Integer.valueOf(liquidacion.getFechaLiquidcion().getYear()).equals(Integer.valueOf(fecha.getYear()))) {
                    existe = true;
                }
            }
        }
        if (!existe) {
            throw new LiquidacionInexistenteExc();
        }
        return existe;
    }
}
