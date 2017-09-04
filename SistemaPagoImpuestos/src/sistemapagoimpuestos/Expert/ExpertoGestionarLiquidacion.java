/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author facun
 */
public class ExpertoGestionarLiquidacion {

    Usuario usuario = new Usuario();
    TipoUsuario admin = new TipoUsuario(0, "Administrador", null);
    TipoUsuario user = new TipoUsuario(1, "Usuario", null);

    public ExpertoGestionarLiquidacion() {
        usuario.setTipoUsuario(admin);
    }
    // Metodo iniciar

    public String iniciar() {
        return "Administrador";
    }

    public void consultarLiquidacion() {

    }
public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        // Como vuelven de la DB?
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("TipoImpuesto", null);
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        for(Object obj : listObject){
            TipoImpuesto tipoImpuesto = (TipoImpuesto) obj;
            DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
            dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            listDtoTipoImpuesto.add(dtoTipoImpuesto);
        }
        return listDtoTipoImpuesto;
    }
public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(){
public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nombreTipoImpuesto){
    
   List<Object> listObject =  FachadaPersistencia.getInstance().buscar("Empresa", null);
        ArrayList<DTOEmpresa> listDTOEmpresa = new ArrayList<DTOEmpresa>();
        for(Object obj : listObject){
            Empresa empresa = (Empresa) obj;
            DTOEmpresa dtoEmpresa = new DTOEmpresa();
            dtoEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            dtoEmpresa.setCuitEmpresa(empresa.getCuitEmpresa());
            dtoEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
            dtoEmpresa.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
            listDTOEmpresa.add(dtoEmpresa);
   

                                    }
        return listDTOEmpresa;
               }
}



