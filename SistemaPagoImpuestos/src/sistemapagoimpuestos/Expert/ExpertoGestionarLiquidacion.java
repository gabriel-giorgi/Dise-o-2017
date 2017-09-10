/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import sistemapagoimpuestos.Controller.ControladorConsultarLiquidacion;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUMostrar;

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

    public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nombreTipoImpuesto) {
         
        
//CREA LO QUE VA A DEVOLVER
         ArrayList<DTOEmpresa> listDtoEmpresa = new ArrayList<DTOEmpresa>();
         
 //SI ES TODOS , BUSCA TODAS LAS EMPRESAS(otra vez xq no me andubo el this.buscarEmpresa, posiblemente por problemas de list/arraylist)
        if ("Todos".equals(nombreTipoImpuesto)){ 
  
      
   List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        
       
        DTOEmpresa dtoEmpresa;
        
        for (int i = 0; i < empresas.size(); i++) {
            dtoEmpresa = new DTOEmpresa();
            Empresa empresa = (Empresa) empresas.get(i);
            String nombreEmpresa = empresa.getNombreEmpresa();
            dtoEmpresa.setNombreEmpresa(nombreEmpresa);
            listDtoEmpresa.add(dtoEmpresa);
        }
 
  }
    

//SI SELECCIONO UNO BUSCA LAS EMPRESAS DE ESE TIPO IMPUESTO
else{

         List<DTOCriterio> criterios = new ArrayList<>();
       
        
        //BUSCA TIPOIMPUESTO SELECCIONADO EN EL OTRO COMBOBOX y muestra nombre
        
        //BUSCA EL OBJETO TIMPO IMPUESTO
       DTOCriterio criterio2 = new DTOCriterio("nombreTipoImpuesto","=",nombreTipoImpuesto); 
       criterios.clear();
       criterios.add(criterio2);
    TipoImpuesto listTipoImpuesto =  (TipoImpuesto)FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
   
      //BUSCA LA EMPRESA QUE TENGGA EL TIMPO IMPUESTO  
    DTOCriterio criterio1 = new DTOCriterio("tipoImpuesto","=",listTipoImpuesto); 
    criterios.clear();
    criterios.add(criterio1);
    List<Object> listEmpresaTipoImpuesto =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        
       
        for(Object obj : listEmpresaTipoImpuesto){
        EmpresaTipoImpuesto tipoImpuesto = (EmpresaTipoImpuesto)obj;
        DTOEmpresa dtoEmpresa = new DTOEmpresa();
        dtoEmpresa.setNombreEmpresa(tipoImpuesto.getEmpresa().getNombreEmpresa());
        listDtoEmpresa.add(dtoEmpresa);
        }
        
     
     };
     
     return listDtoEmpresa;
    }
    public List<DTOEmpresa> buscarEmpresas() {
        
        //Busqueda de Empresas habilitadas
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        
        List <DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;
        
        for (int i = 0; i < empresas.size(); i++) {
            dtoEmpresa = new DTOEmpresa();
            Empresa empresa = (Empresa) empresas.get(i);
            String nombreEmpresa = empresa.getNombreEmpresa();
            dtoEmpresa.setNombreEmpresa(nombreEmpresa);
            lista.add(dtoEmpresa);
        }
        return lista;
    }

    public ArrayList<DTOLiquidacion> obtenerLiquidacion() {
        List<Object> listLiquidacion =  FachadaPersistencia.getInstance().buscar("Liquidacion", null);
        
        ArrayList<DTOLiquidacion> listDtoLiquidacion = new ArrayList<DTOLiquidacion>();
        for(Object obj : listLiquidacion){
        Liquidacion liquidacion = (Liquidacion)obj;
        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
        
        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
       // dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
             dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().get(liquidacion.getLiquidacionEstado().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
        listDtoLiquidacion.add(dtoLiquidacion);
    }
        return listDtoLiquidacion;
}
//en caso de que  explote mirar los if else
    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String nombreTipoImpuesto,String nombreEmpresa,Date fechaDesde,Date fechaHasta) {
      
        ArrayList<DTOLiquidacion> listDtoLiquidacion = new ArrayList<DTOLiquidacion>();
        List<DTOCriterio> criterios = new ArrayList();
        
//SI ESTA TODOS TODOS BUSCA TODAS LAS LIQUIDACIONES
        if ("Todos".equals(nombreTipoImpuesto) && "Todos".equals(nombreEmpresa)) {
             List<Object> listLiquidacionTodos =  FachadaPersistencia.getInstance().buscar("Liquidacion", null);
            for(Object obj : listLiquidacionTodos){
        Liquidacion liquidacion = (Liquidacion)obj;
        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
        
        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
        //dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
        dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().get(liquidacion.getLiquidacionEstado().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
        listDtoLiquidacion.add(dtoLiquidacion);
         }
            //SI SOLO NOMBRE TIPOIMPUESTO ES TODOS
        }else {
            if ("Todos".equals(nombreTipoImpuesto)){
   //HACE  BUSQUEDA DE EMPRESA , TODOS LOS EMPRESA TIPO IMPUESTO DE ESA EMPRESA Y TODAS LAS LIQUIDACIONES DE TODAS ESAS EMRPESAS TIPO IMPUESTO COOMING SOON
                
   
        //BUSCA LA EMPRESA SELECCIONADA
                 DTOCriterio criterio7 = new DTOCriterio("nombreEmpresa","=",nombreEmpresa); 
                 criterios.clear();
                 criterios.add(criterio7);
                Empresa empresa =(Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
                
        //BUSCA LISTA DE EMPRESA TIPO IMPUESTOS QUE TENGAN ESA EMPRESA(no esta probado puede q falle)
        DTOCriterio criterio8 = new DTOCriterio("empresa","=",empresa); 
        List<Object> listEmpresaTipoImpuesto =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
                        
             List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
                for(Object obj : listLiquidacion){
                Liquidacion liquidacion = (Liquidacion)obj;
                 for(Object obj1:listEmpresaTipoImpuesto){
                     EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto)obj1;
                    if( liquidacion.getEmpresaTipoImpuesto().equals(empresaTipoImpuesto)){
                    
                    DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
                    
                    dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                    dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                    dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                    dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                  //  dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
                            dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().get(liquidacion.getLiquidacionEstado().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
                    dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                    dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                   
                    listDtoLiquidacion.add(dtoLiquidacion);
                    }
                     
                 }   
                }   
            }
            //HACE BUSQUEDA DE TODAS LAS EMPRESAS TIPO IMPUESTO QUE TENGAN EL TIMPO IMPUESTO SELECCIONADO Y BUSCA TODAS LAS LIQUIDACIONES DE ESAS EMPRESAS TIMPO IMPUESTO
        else  if ("Todos".equals(nombreEmpresa)) {
                //BUSCASR TIPO IMPUESTO SELECCIONADO
               
                DTOCriterio criterio10 = new DTOCriterio("nombreTipoImpuesto","=",nombreTipoImpuesto); 
                criterios.add(criterio10);
                TipoImpuesto tipoImpuesto =  (TipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);
                
                
              //BUSCAR EMPRESA TIMPO IMPUESTO DE ESE IMPUESTO
               DTOCriterio criterio11 = new DTOCriterio("tipoImpuesto","=",tipoImpuesto); 
               criterios.add(criterio11);
              List<Object>listEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
              
              
              //BUSCAR LIQUIDACIONES
              List<Object>listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
                
                
                
                for(Object obj : listLiquidacion){
                Liquidacion liquidacion = (Liquidacion)obj;
                 for(Object obj1:listEmpresaTipoImpuesto){
                     EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto)obj1;
                    if( liquidacion.getEmpresaTipoImpuesto().equals(empresaTipoImpuesto)){
                    
                    DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
                    
                    dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                    dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                    dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                    dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                //  dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
                    dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().get(liquidacion.getLiquidacionEstado().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
                    dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                    dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                
                    
                listDtoLiquidacion.add(dtoLiquidacion);
                                                                                      }
                                                        }
                                                }
                                             }
      else {  
        
//BUSCO TIPO IMPUESTO SELECCIONADO       
        DTOCriterio criterio = new DTOCriterio("nombreTipoImpuesto","=",nombreTipoImpuesto);
        criterios.add(criterio);
         TipoImpuesto tipoImpuesto =  (TipoImpuesto)FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        
 //BUSCO EMPRESA SELECCIONADA
         DTOCriterio criterio1 = new DTOCriterio("nombreEmpresa", "=", nombreEmpresa);
         criterios.clear();
         criterios.add(criterio1);
         Empresa empresa =  (Empresa)FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
         
 // BUSCO EMPRESATIPOIMPUESTO QUE CONTEGNA TIPO IMPUESTO Y EMPRESA
        DTOCriterio criterio2 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
        DTOCriterio criterio3 = new DTOCriterio("empresa", "=", empresa);
        criterios.clear();
        criterios.add(criterio2);
        criterios.add(criterio3);        
        EmpresaTipoImpuesto empresaTipoImpuesto =(EmpresaTipoImpuesto)  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);
        
 //BUSCO TODAS LAS LIQUIDACIONES QUE TENGA ESA EMPRESA TIPO IMPUESTO ENTRE LAS FECHAS       
        
        DTOCriterio criterio4 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
        DTOCriterio criterio5 = new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde);
        DTOCriterio criterio6 = new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta);
        criterios.clear();
        criterios.add(criterio4);
        criterios.add(criterio5);
        criterios.add(criterio6);
        List<Object> listLiquidacion =  FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
        
 //LLENO EL DTOLIQUIDACION
     
        for(Object obj : listLiquidacion){
        Liquidacion liquidacion = (Liquidacion)obj;
        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
        
        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
        //dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
         dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().get(liquidacion.getLiquidacionEstado().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
        listDtoLiquidacion.add(dtoLiquidacion);
            }
        }  
    }
        return listDtoLiquidacion;
}
    
    
    
    public ArrayList<DTOOperacion> buscarOperaciones(String numeroLiquidacion){
    
        ArrayList<DTOOperacion> listDTOOperacion = new ArrayList<DTOOperacion>();
         List<DTOCriterio> criterios = new ArrayList<>();
         
         //BUSCA LA LIQUIDACION SELECCIONADA
        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", numeroLiquidacion);
        criterios.add(criterio);
       Liquidacion liquidacion  = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
       //HACE UN GET A  LA LISTA DE OPERACIONES DE ESA LIQUIDACION Y DEJO ACA ME FUI A DORMIR
       liquidacion.getOperacion();
       
        return listDTOOperacion;
    }
    
    public void mostrar(String numeroLiquidacion,String fechaLiquidacion,String tipoImpuesto,String empresa){
    IUMostrar mostrar = new IUMostrar();
    mostrar.setVisible(true);
    mostrar.setLocation(300, 200);
    IUMostrar.jLabelEmpresa.setText(empresa);
    IUMostrar.jLabelTipoImpuesto.setText(tipoImpuesto);
    IUMostrar.jLabelFechaLiquidacion.setText(fechaLiquidacion);
    IUMostrar.jLabelNrodeLiquidacion.setText(numeroLiquidacion);
    
    
    }
    

}