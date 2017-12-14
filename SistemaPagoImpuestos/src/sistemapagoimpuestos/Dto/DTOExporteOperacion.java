/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class DTOExporteOperacion {
    private String fechaOperacion;
    private Integer numeroOperacion;
    private String codigoPagoElectronico;
    private Integer nroComprobante;
    private String tipoImpuesto;
    private double importePagado;

    public DTOExporteOperacion(){
    }
    
    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Integer getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(Integer numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getCodigoPagoElectronico() {
        return codigoPagoElectronico;
    }

    public void setCodigoPagoElectronico(String codigoPagoElectronico) {
        this.codigoPagoElectronico = codigoPagoElectronico;
    }

    public Integer getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(Integer nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public double getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(double importePagado) {
        this.importePagado = importePagado;
    }
}