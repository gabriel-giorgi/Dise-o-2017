/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author facun
 */
public class DecoradorGestionarLiquidacion extends ExpertoGestionarLiquidacion {

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

    @Override
    public void consultarLiquidacion() {

    }
    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        ArrayList<DTOTipoImpuesto> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerTipoImpuestos(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
        
    }
@Override
    public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nomreTipoImpuesto){
        ArrayList<DTOEmpresa> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerEmpresarelacionadaATipoImpuesto(nomreTipoImpuesto); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
        
    }


}
