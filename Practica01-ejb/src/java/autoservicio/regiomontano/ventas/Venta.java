/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoservicio.regiomontano.ventas;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jon
 */
@ApplicationScoped
public class Venta {
    @NotNull
    @Digits(integer=6,fraction=2)
    private double total;        
    private double neto;
    
    private double impuesto;
    private Conexion c = new Conexion();
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    
    public void calcula(String cadena) throws IOException{                     
        try {
            this.total=Double.parseDouble(cadena);
            this.impuesto=total*.16;    
            this.neto=total-impuesto;
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");   
        }catch (java.lang.NumberFormatException e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");   
        }        
    }
    
}
