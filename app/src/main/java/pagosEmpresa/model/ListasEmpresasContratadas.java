package pagosEmpresa.model;

import java.util.ArrayList;
import java.util.List;

import pagosEmpresa.error.EmpresaInexistenteExc;

public class ListasEmpresasContratadas {
    private List<EmpresaContratada> empresas;

    public ListasEmpresasContratadas() {
        empresas = new ArrayList<>();
    }

    public void agregarEmpresaContratada(EmpresaContratada empresa){
        if (!(this.existeEmpresaContratada(empresa.getCuit()))) {
            
        } else {
            empresas.add(empresa);
        }
        
    }

    public void modificarEmpresaContratada(EmpresaContratada empresaModificar, EmpresaContratada empresaModificado) {
        eliminarEmpresaContratada(empresaModificar.getCuit());
        agregarEmpresaContratada(empresaModificado);
    }

    public void eliminarEmpresaContratada(String string) {
        EmpresaContratada empresa;
        if (existeEmpresaContratada(string)) {
            empresa = encontrarEmpresaContratada(string);
            empresas.remove(empresa);
        } else {
            try {
                throw new EmpresaInexistenteExc();
            } catch (EmpresaInexistenteExc e) {
                e.printStackTrace();
            }
        }
    }

    public Integer cantidadDeeEmpresaContratada(){
        return empresas.size();
    }

    public EmpresaContratada encontrarEmpresaContratada(String string){
        EmpresaContratada empresa = null;
        if(existeEmpresaContratada(string)){
            for (EmpresaContratada e : empresas) {
                if (e.getCuit().equals(string)) {
                    empresa = e;
                }
            }
        }
        return empresa;
    }

    public Boolean existeEmpresaContratada(String string){
        Boolean existe = false;
        for (EmpresaContratada empresa : empresas) {
            if (empresa.getCuit().equals(Integer.valueOf(string))) {
                existe = true;
            }
        }
        return existe;
    }

    public void LimpiarLista(){
        empresas.clear();
    }

    public List<EmpresaContratada> getEmpresas() {
        return empresas;
    }

}
