/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarLiquidacion;

import static datosPrueba.DatosPrueba.generarDatosPrueba;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javafx.util.converter.LocalDateStringConverter;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Entity.Liquidacion;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sistemapagoimpuestos.Entity.Operacion;
/**
 *
 * @author vande
 */
public class IUGestionarLiquidacion extends javax.swing.JFrame {

    /**
     * Creates new form IUGestionarLiquidacion
     */
    public IUGestionarLiquidacion() {
        //LLENA EL COMBO BOX TIPO EMPRESA, Y INICIALIZA EL DE EMRPESA CON "TODOS"
        initComponents();
        jComboBoxEmpresa.setEditable(false);
        jComboBoxTipoImpuesto.addItem("Todos");
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = ControladorGestionarLiquidacion.getInstance().obtenerTipoImpuestos();  
         for(DTOTipoImpuesto obj : listDtoTipoImpuesto){
             jComboBoxTipoImpuesto.addItem(obj.getNombreDTOTipoImpuesto());
           }  
         jComboBoxEmpresa.removeAllItems();
        jComboBoxEmpresa.addItem("Todos");
         List<DTOEmpresa> listDtoDTOEmpresa = ControladorGestionarLiquidacion.getInstance().obtenerEmpresarelacionadaATipoImpuesto(jComboBoxTipoImpuesto.getItemAt(jComboBoxTipoImpuesto.getSelectedIndex()));
       for(DTOEmpresa obj : listDtoDTOEmpresa){
            jComboBoxEmpresa.addItem(obj.getNombreEmpresa());}     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEmpresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserCombodesde = new datechooser.beans.DateChooserCombo();
        dateChooserCombohasta = new datechooser.beans.DateChooserCombo();
        jButtonConsultarLiquidaciones = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        jButtonMostrar = new javax.swing.JButton();
        jButtonAprobar = new javax.swing.JButton();
        jButtonAnular = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liquidaciones");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Tipo Impuesto");

        jComboBoxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpresaActionPerformed(evt);
            }
        });

        jLabel2.setText("Empresa");

        jLabel3.setText("Fecha desde Liquidacion");

        jLabel4.setText("Fecha hasta Liquidacion");

        dateChooserCombodesde.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        dateChooserCombohasta.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        jButtonConsultarLiquidaciones.setText("Consultar Liquidaciones");
        jButtonConsultarLiquidaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarLiquidacionesActionPerformed(evt);
            }
        });

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Liquidacion", "Fecha Liquidacion", "fecha desde", "fecha hasta", "Empresa", "Tipo Impuesto", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jComboBoxTipoImpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoImpuestoItemStateChanged(evt);
            }
        });
        jComboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        jButtonAprobar.setText("Aprobar");
        jButtonAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAprobarActionPerformed(evt);
            }
        });

        jButtonAnular.setText("Anular");
        jButtonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonConsultarLiquidaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButtonMostrar)
                        .addGap(168, 168, 168)
                        .addComponent(jButtonAprobar)
                        .addGap(222, 222, 222)
                        .addComponent(jButtonAnular)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButtonConsultarLiquidaciones)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostrar)
                    .addComponent(jButtonAprobar)
                    .addComponent(jButtonAnular))
                .addGap(77, 77, 77))
        );

        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleName("");
        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarLiquidacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarLiquidacionesActionPerformed
  //Limpia la tabla
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            while (model.getRowCount()>0) {
            model.removeRow(0);
        }
     //manda a buscar con los parametros       
        Date fechadesde = dateChooserCombodesde.getCurrent().getTime();
       Date fechahasta = dateChooserCombohasta.getCurrent().getTime();
        ArrayList <DTOLiquidacion> listDtoLiquidacion = ControladorGestionarLiquidacion.getInstance().buscarLiquidacionConFiltro(jComboBoxTipoImpuesto.getItemAt(jComboBoxTipoImpuesto.getSelectedIndex()), jComboBoxEmpresa.getItemAt(jComboBoxEmpresa.getSelectedIndex()),fechadesde,fechahasta);
        
        //LLena la tabla
        for (int i = 0; i < listDtoLiquidacion.size(); i++) {

            model.addRow(new Object[]{});
            jTable2.isCellEditable(i, 0);
            jTable2.isCellEditable(i, 1);
            jTable2.isCellEditable(i, 2);
            jTable2.isCellEditable(i, 3);
            jTable2.isCellEditable(i, 4);
            jTable2.isCellEditable(i, 5);
            jTable2.isCellEditable(i, 6);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getNumeroLiquidacion(), i, 0);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getFechaHoraLiquidacion(), i, 1);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getFechaHoraDesdeLiquidacion(), i, 2);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getFechaHoraHastaLiquidacion(), i, 3);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getNombreEmpresa(), i, 4);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getNombreTipoImpuesto(), i, 5);
            jTable2.setValueAt(listDtoLiquidacion.get(i).getNombreEstadoLiquidacion(), i, 6);
        }
    }//GEN-LAST:event_jButtonConsultarLiquidacionesActionPerformed

    private void jComboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoImpuestoActionPerformed
        jComboBoxEmpresa.removeAllItems();
        jComboBoxEmpresa.addItem("Todos");
         List<DTOEmpresa> listDtoDTOEmpresa = ControladorGestionarLiquidacion.getInstance().obtenerEmpresarelacionadaATipoImpuesto(jComboBoxTipoImpuesto.getItemAt(jComboBoxTipoImpuesto.getSelectedIndex()));
       for(DTOEmpresa obj : listDtoDTOEmpresa){
            jComboBoxEmpresa.addItem(obj.getNombreEmpresa());}     
    }//GEN-LAST:event_jComboBoxTipoImpuestoActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited
//delete THIS
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    
    }//GEN-LAST:event_formWindowActivated

    private void jComboBoxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmpresaActionPerformed

    private void jComboBoxTipoImpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoImpuestoItemStateChanged
        
    /*   ArrayList<DTOEmpresa> listDtoDTOEmpresa = ControladorGestionarLiquidacion.getInstance().obtenerEmpresarelacionadaATipoImpuesto();
         for(DTOEmpresa obj : listDtoDTOEmpresa){
             jComboBoxTipoImpuesto.addItem(obj.getNombreEmpresa()); }   */
    }//GEN-LAST:event_jComboBoxTipoImpuestoItemStateChanged

    private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularActionPerformed
      int opcion = JOptionPane.showConfirmDialog(rootPane, "Desea Anular la liquidacion numero "+jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        switch (opcion) {
            case 0:System.out.println("---------------ACEPTO------------");
               if(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString().equals("ARecalcular")||jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString().equals("Aprobado")){
                        JOptionPane.showMessageDialog(null,
                        "Solo se pueden anular liquidaciones en estado Recalculada o Creada",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                        break;
               }
                ControladorGestionarLiquidacion.getInstance().AnularLiquidacion(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
            
              
                break;
            default:
                throw new AssertionError();
            case 1 : System.out.println("--------------NO------------");
                    
            break;
            case 2 : System.out.println("------------CANCEL----------");
        }
    }//GEN-LAST:event_jButtonAnularActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed

       
        
        
        String nliquidacion =  jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String fechaDesde =  jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();
        String fechaHasta =  jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
        String fechaliquidacion =jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        String tipoImpuesto =  jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString();
        String empresa =  jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString();
       List<Operacion> listOperacion = ControladorGestionarLiquidacion.getInstance().mostrar(nliquidacion,fechaliquidacion,tipoImpuesto,empresa);
        
          //Muestra la pantalla
        IUMostrar mostrar = new IUMostrar();
        mostrar.setVisible(true);
        mostrar.setLocation(300, 200);
        //LLena los labels
        IUMostrar.jLabelEmpresa.setText(empresa);
        IUMostrar.jLabelTipoImpuesto.setText(tipoImpuesto);
        IUMostrar.jLabelFechaLiquidacion.setText(fechaliquidacion);
        IUMostrar.jLabelNrodeLiquidacion.setText(nliquidacion);
        IUMostrar.jLabelPeriodo.setText(fechaDesde);
        IUMostrar.jLabelPeriodo2.setText(fechaHasta);
        
        double montoTotla = 0;

        for (int i = 0; i < listOperacion.size(); i++) {
           
            // AGREGAR UNA FILA CADA VEZ QUE CREO OTRA OPERACION
            DefaultTableModel model = (DefaultTableModel) IUMostrar.jTableOperacion.getModel();
            model.addRow(new Object[]{});
            IUMostrar.jTableOperacion.isCellEditable(i, 0);
            IUMostrar.jTableOperacion.isCellEditable(i, 1);
            IUMostrar.jTableOperacion.isCellEditable(i, 2);
            IUMostrar.jTableOperacion.isCellEditable(i, 3);
            IUMostrar.jTableOperacion.setValueAt(listOperacion.get(i).getNumeroOperacion(), i, 0);
            IUMostrar.jTableOperacion.setValueAt(listOperacion.get(i).getNroComprobanteFacturaOperacion(), i, 1);
            IUMostrar.jTableOperacion.setValueAt(listOperacion.get(i).getValorComisionOperacion(), i, 2);
            IUMostrar.jTableOperacion.setValueAt(listOperacion.get(i).getImportePagadoOperacion(), i, 3);

            montoTotla = montoTotla + listOperacion.get(i).getValorComisionOperacion();
        }
          
        // Metodo van den bosch,  nose como convertir double a string
        IUMostrar.jTextFieldMontoTotal.setText("" + montoTotla);
        
       
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void jButtonAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAprobarActionPerformed
      //MOSTRAR CARLEL DE OK
      //JOptionPane.showMessageDialog(rootPane, "picachu");
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Desea Aprobar la liquidacion numero " + jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        switch (opcion) {
            case 0:
                System.out.println("---------------ACEPTO------------");

                ControladorGestionarLiquidacion.getInstance().AprobarLiquidacion(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());

                break;
            default:
                throw new AssertionError();
            case 1:
                System.out.println("--------------NO------------");

                break;
            case 2:
                System.out.println("------------CANCEL----------");
        }
       
    }//GEN-LAST:event_jButtonAprobarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IUGestionarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IUGestionarLiquidacion pantallaPrincipal = new IUGestionarLiquidacion();
                pantallaPrincipal.setVisible(true);
               // new IUGestionarLiquidacion().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombodesde;
    private datechooser.beans.DateChooserCombo dateChooserCombohasta;
    private javax.swing.JButton jButtonAnular;
    private javax.swing.JButton jButtonAprobar;
    private javax.swing.JButton jButtonConsultarLiquidaciones;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JComboBox<String> jComboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
