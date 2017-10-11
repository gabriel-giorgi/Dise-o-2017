/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import sistemapagoimpuestos.Adaptador.AdaptadorBancoImpl.AdaptadorBancoGalicia;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresa;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoCuenta;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Cliente;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.ParametroSistema;
import sistemapagoimpuestos.Entity.TipoCuenta;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionBanco;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionEmpresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {
    
    
    public List<DTOTipoImpuesto> buscarTipoImpuestos(){
            List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
            criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null)); 
            List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
            List<DTOTipoImpuesto> lista = new ArrayList<>();
            DTOTipoImpuesto dtoTipoImpuesto;

            for (int i = 0; i < tipoImpuestos.size(); i++) {
                dtoTipoImpuesto = new DTOTipoImpuesto();
                TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestos.get(i);
                String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
                dtoTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
                lista.add(dtoTipoImpuesto);
            }
            return lista;
    }
    
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto){
            
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));       
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        //Busca instancia de EmpresaTipoImpuesto, aplicando el tipo de impuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        List<DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;
        
        // Recorro los empresaTipoImpuesto, obteniendo las Empresas
        for (int i = 0; i < eti.size(); i++) {
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eti.get(i);
            if(empresaTipoImpuesto.getEmpresa().getFechaHoraInhabilitacionEmpresa()==null){
                 dtoEmpresa = new DTOEmpresa();
                dtoEmpresa.setNombreEmpresa(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                lista.add(dtoEmpresa);
            }
           
        }     
        return lista;
    }

    public List<DTOComprobante> seleccionarEmpresa(String nombreTipoImpuesto, String nombreEmpresaIng, String codigoPagoElectronicoIngres){
        List<DTOCriterio> criterioList = new ArrayList();
        criterioList.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresaIng));
        Empresa empresaSeleccionada = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterioList).get(0);        
        criterioList.clear();
        criterioList.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        TipoImpuesto tipoImpuestoSeleccionado = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioList).get(0);
        criterioList.clear();
        criterioList.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
        criterioList.add(new DTOCriterio("empresa", "=", empresaSeleccionada));
        EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioList).get(0);        
        List<DTOComprobante> listadoComprobantes = FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresaSeleccionada).consultarComprobantes(empresaTI, codigoPagoElectronicoIngres);
        return listadoComprobantes;
    }
    
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente){
        
        List<DTOCuentaBancaria> listaDTOCuentaBancaria = new ArrayList<DTOCuentaBancaria>();
        ParametroSistema parametroSistema = (ParametroSistema) FachadaPersistencia.getInstance().buscar("ParametroSistema", null).get(0);
        List<DTOCriterio> criteriosList = new ArrayList<>();
        criteriosList.add(new DTOCriterio("cuilCuitCliente", "=", cuilCliente));
        Cliente cliente = (Cliente)FachadaPersistencia.getInstance().buscar("Cliente", criteriosList).get(0);
        criteriosList.clear();
        criteriosList.add(new DTOCriterio("cliente", "=", cliente));
        List<Object> listaCuentas = FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosList);
        
        for (Object cuenta : listaCuentas) {      
            CuentaBancaria cuentaTemp = (CuentaBancaria) cuenta;
            TipoCuenta tipoCuentaTemp = (TipoCuenta) cuentaTemp.getTipoCuenta();
            DTOTipoCuenta dtoTipoCuenta = new DTOTipoCuenta();
            dtoTipoCuenta.setNombreTipoCuenta(tipoCuentaTemp.getNombreTipoCuenta());
            DTOCuentaBancaria dtoCuentaBancariaTemp = new DTOCuentaBancaria();
            dtoCuentaBancariaTemp.setCbuCuentaBancaria(cuentaTemp.getCbuCuentaBancaria());
            dtoCuentaBancariaTemp.setTipoCuenta(dtoTipoCuenta);
              dtoCuentaBancariaTemp.setSaldoRecuperado(
                      FactoriaAdaptadorConexionBanco.
                              getInstancia().
                              getAdaptadorConexionBanco(parametroSistema)
                              .consultarSaldo(cuentaTemp.getCbuCuentaBancaria()));
            listaDTOCuentaBancaria.add(dtoCuentaBancariaTemp);
        }
        return listaDTOCuentaBancaria;
    }
    
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, DTOComprobante dtoComprobante, String codigoPagoIngres, String empresaSelec, String tipoImpuestoSelec){
        ParametroSistema parametroSistema = (ParametroSistema) FachadaPersistencia.getInstance().buscar("ParametroSistema", null).get(0);
        if(FactoriaAdaptadorConexionBanco.getInstancia().getAdaptadorConexionBanco(parametroSistema).debitarSaldo(cbuCuentaSeleccionada, montoAbonado)){
            Operacion operacion = new Operacion();
            operacion.setNumeroOperacion(ThreadLocalRandom.current().nextInt(1,1000000000)); // es aleatorio
            operacion.setCodigoPagoElectrionicoOperacion(dtoComprobante.getCodigoDTOComprobante());
            operacion.setFechaHoraOperacion(new Date());
            operacion.setImportePagadoOperacion(montoAbonado);
            operacion.setLiquidadaOperacion(false);    
            operacion.setNroComprobanteFacturaOperacion(dtoComprobante.getNumeroFactura());

            List<DTOCriterio> criteriosList = new ArrayList<>();
            criteriosList.add(new DTOCriterio("cbuCuentaBancaria", "=", cbuCuentaSeleccionada));
            CuentaBancaria cuentaBancaria = (CuentaBancaria) FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosList).get(0);
            operacion.setCuentaBancaria(cuentaBancaria);

            criteriosList.clear();
            criteriosList.add(new DTOCriterio("nombreEmpresa", "=", empresaSelec));
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criteriosList).get(0);
            operacion.setEmpresa(empresa);

            criteriosList.clear();
            criteriosList.add( new DTOCriterio("nombreTipoImpuesto", "=", tipoImpuestoSelec));        
            TipoImpuesto tipoImpuestoSeleccionado = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criteriosList).get(0);
            operacion.setTipoImpuesto(tipoImpuestoSeleccionado);

            criteriosList.clear();
            criteriosList.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
            criteriosList.add(new DTOCriterio("empresa", "=", empresa));
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosList).get(0);
            operacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);

            // Por cada atributo adicional creo un detalle
            List<DTOItem> listadoItems = dtoComprobante.getAtributosAdicionalesDTOComprobante();
            List<DetalleOperacion> detalleOperacionList = new ArrayList<>();
            // Seteo el valor del item
            for (int i = 0; i < listadoItems.size(); i++) {
                // Creo el detalle de la operación
                DetalleOperacion detalle = new DetalleOperacion();
                String valor = listadoItems.get(i).getItemVal();
                detalle.setValorDetalleOperacion(valor);
                String nombreItem = listadoItems.get(i).getNombreItem();
                // Busco el item relacionado
                List<DTOCriterio> criterioItem = new ArrayList();
                criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
                List items = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
                Item itemRecuperado = (Item) items.get(0);
                // Debo setearle el itemEmpresaTipoImpuesto
                List<DTOCriterio> criterioItemEmpresaTipoImpuesto = new ArrayList();
                criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("item", "=", itemRecuperado));
                criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
                List ieti = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemEmpresaTipoImpuesto);
                ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) ieti.get(0);
                detalle.setItemEmpresaTipoImpuesto(itemEmpresaTipoImpuesto);
                detalleOperacionList.add(detalle);
            }
            operacion.setDetalleOperacionList(detalleOperacionList);
            
            FachadaPersistencia.getInstance().guardar(operacion);

            if (FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresa).confirmarPago(Integer.toString(dtoComprobante.getNumeroFactura()), operacion.getNumeroOperacion(), montoAbonado)){

                DTOOperacion dtoOperacion= new DTOOperacion();
                dtoOperacion.setTipoImpuesto(operacion.getTipoImpuesto());
                dtoOperacion.setEmpresa(operacion.getEmpresa());
                dtoOperacion.setNumeroOperacion(operacion.getNumeroOperacion());
                return dtoOperacion;
            }else{
                return null;
            }
        }else{
            return null;
        }        
    }
    
    public boolean MontoEditable(String nombreTipoImpuesto){
        List<DTOCriterio> criterioList = new ArrayList();
        criterioList.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        TipoImpuesto tipoImpuestoSeleccionado = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioList).get(0);
        return tipoImpuestoSeleccionado.isEsMontoEditableTipoImpuesto();
    }
}
