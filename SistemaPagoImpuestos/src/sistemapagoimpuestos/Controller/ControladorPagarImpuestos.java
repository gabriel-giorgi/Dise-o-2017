/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;
import sistemapagoimpuestos.View.User.IUPagarImpuestoComprobantes;
import sistemapagoimpuestos.View.User.IUPagarImpuestoCuentas;

/**
 *
 * @author mvissio
 */
public class ControladorPagarImpuestos {

    private ExpertoPagarImpuestos experto = (ExpertoPagarImpuestos) FabricaExpertos.getInstancia().crearExperto("CU02");

    public ControladorPagarImpuestos() {
    }

    public void validadarUsuario() {
        try {
            experto.validarUsuario();
            IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
            iUPagarImpuesto.setVisible(true);

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es cliente");
        }
    }

    // Método para recuperar los Tipo de Impuestos
    public List<DTOTipoImpuesto> buscarTipoImpuestos() {
        List<DTOTipoImpuesto> listado = experto.buscarTipoImpuestos();
        return listado;
    }

    // Método para recuperar las Empresas
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) {
        return experto.buscarEmpresas(nombreTipoImpuesto);
    }

    // Método para buscar las cuentas y saldos
    public void obtenerCuentas(String cuilCliente, IUPagarImpuestoComprobantes pantallaComprobantes) {
        IUPagarImpuestoCuentas pantallaCuentas = new IUPagarImpuestoCuentas(experto.obtenerCuentas(cuilCliente), pantallaComprobantes);
        pantallaCuentas.setVisible(true);
    }

    public void seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres) {
        IUPagarImpuestoComprobantes pantallaComprobantes = new IUPagarImpuestoComprobantes(
                experto.seleccionarEmpresa(
                        nombreEmpresaIng, 
                        codigoPagoElectronicoIngres));
        if (experto.isMontoEditable()) {
            pantallaComprobantes.setearEditable();
        } else {
            
        }
        pantallaComprobantes.setVisible(true);
    }

    // Pagar impuesto
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String CodigoPago) {
        return experto.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, CodigoPago);
    }
}
