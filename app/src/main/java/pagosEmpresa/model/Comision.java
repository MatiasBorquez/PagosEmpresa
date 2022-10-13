package pagosEmpresa.model;

import java.time.LocalDate;

public class Comision {
    LocalDate fechaComision;
    Double valorComision;
    public Comision(LocalDate fechaComision, Double valorComision) {
        this.fechaComision = fechaComision;
        this.valorComision = valorComision;
    }
    public LocalDate getFechaComision() {
        return fechaComision;
    }
    public Double getValorComision() {
        return valorComision;
    }

    
}
