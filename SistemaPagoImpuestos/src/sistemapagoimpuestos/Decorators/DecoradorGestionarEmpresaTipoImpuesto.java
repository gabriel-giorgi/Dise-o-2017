/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaTipoImpuesto extends ExpertoGestionarEmpresaTipoImpuesto{
    
    @Override
    public List iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    @Override
    public List buscarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.buscarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    @Override
    public List ingresarDatosETI(String nombreTipoImpuesto, String nombreEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.ingresarDatosETI(nombreTipoImpuesto, nombreEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
}
}