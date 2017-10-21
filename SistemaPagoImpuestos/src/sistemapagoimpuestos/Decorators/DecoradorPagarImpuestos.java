/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresaIUPagar;
import sistemapagoimpuestos.Dto.DTOOperacionActual;
import sistemapagoimpuestos.Dto.DTOTipoImpuestoIUPagar;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorPagarImpuestos extends ExpertoPagarImpuestos{

    public DecoradorPagarImpuestos() {
    }

    @Override
    public void validarUsuario()  throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.validarUsuario(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    

    @Override
    public List<DTOTipoImpuestoIUPagar> buscarTipoImpuestos()  throws Exception{
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuestoIUPagar> listaDTOTipoImpuesto = super.buscarTipoImpuestos();
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaDTOTipoImpuesto;
    }

    @Override
    public List<DTOEmpresaIUPagar> buscarEmpresas(String nombreTipoImpuesto)  throws Exception{
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresaIUPagar> listaDTOEmpresa = super.buscarEmpresas(nombreTipoImpuesto);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaDTOEmpresa;
    }

    @Override
    public List<DTOComprobantePantalla> seleccionarEmpresa( String nombreEmpresa, String codigoPagoElectronicoIngres) throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOComprobantePantalla> listadoDTOComprobantepantalla = super.seleccionarEmpresa(nombreEmpresa,codigoPagoElectronicoIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDTOComprobantepantalla;
    }

    @Override
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente) throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOCuentaBancaria> listaCuentasBancarias = super.obtenerCuentas(cuilCliente);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaCuentasBancarias;
    }

    @Override
    public DTOOperacionActual pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String codigoPago)  throws Exception{
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOOperacionActual dtoOperacion = super.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, codigoPago);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoOperacion;
    }

    @Override
    public boolean isMontoEditable(){
        return  super.isMontoEditable();
    }
    
    
}
