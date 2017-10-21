/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Empresa.ConsultarLiquidacion;

import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.*;
import static java.awt.Dialog.DEFAULT_MODALITY_TYPE;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorConsultarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Utils.Printer;


/**
 *
 * @author vande
 */
public class IUMostrar extends javax.swing.JDialog {

    /**
     * Creates new form IUMostrar
     */
    public IUMostrar(String nliquidacion) {
        initComponents();
        ControladorConsultarLiquidacion controlador = new ControladorConsultarLiquidacion();
       DTOLiquidacion dtoLiquidacion = controlador.buscarLiquidacion(nliquidacion);
       
        jLabelEmpresa.setText(dtoLiquidacion.getNombreEmpresa());
        jLabelTipoImpuesto.setText(dtoLiquidacion.getNombreTipoImpuesto());
        jLabelNrodeLiquidacion.setText(nliquidacion);
        jLabelFechaLiquidacion.setText(dtoLiquidacion.getFechaHoraLiquidacion().toString());
       
        jLabelPeriodo.setText(dtoLiquidacion.getFechaHoraDesdeLiquidacion().toString());
        jLabelPeriodo2.setText(dtoLiquidacion.getFechaHoraHastaLiquidacion().toString());
        NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
        jTextFieldMontoTotal.setText(nf.format(dtoLiquidacion.getTotalLiquidado()));
        DefaultTableModel model = (DefaultTableModel)jTableOperacion.getModel();
        
        for (int i = 0; i < dtoLiquidacion.getListOperacionComision().size(); i++) {
            model.addRow(new Object[]{});
            jTableOperacion.setValueAt(dtoLiquidacion.getListOperacionComision().get(i).getNumeroOperacion(), i, 0);
            jTableOperacion.setValueAt(dtoLiquidacion.getListOperacionComision().get(i).getNroComprobanteFactura(), i, 1);
            jTableOperacion.setValueAt(dtoLiquidacion.getListOperacionComision().get(i).getImportePagadoOperacion(), i, 2);
            jTableOperacion.setValueAt(nf.format(dtoLiquidacion.getListOperacionComision().get(i).getValorComision()), i, 3);
             
            
        }
        
       /* DTOLiquidacion liquidacion = controlador.(nliquidacion);
        
        DefaultTableModel model = (DefaultTableModel)jTableOperacion.getModel();
        Double montoTotal = 0.0;
        for (int i = 0; i < liquidacion.getListOperacionComision().size(); i++) {
            model.addRow(new Object[]{});
            jTableOperacion.setValueAt(liquidacion.getListOperacionComision().get(i).getNumeroOperacion(), i, 0);
            jTableOperacion.setValueAt(liquidacion.getListOperacionComision().get(i).getNroComprobanteFactura(), i, 1);
            jTableOperacion.setValueAt(liquidacion.getListOperacionComision().get(i).getValorComision(), i, 2);
            jTableOperacion.setValueAt(liquidacion.getListOperacionComision().get(i).getImportePagadoOperacion(), i, 3);
             System.out.println(liquidacion.getListOperacionComision().get(i).getValorComision());
            montoTotal= liquidacion.getListOperacionComision().get(i).getValorComision() +montoTotal;
        }
       System.out.println(montoTotal);
       jTextFieldMontoTotal.setText(montoTotal.toString());
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Operaciones");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
*/
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOperacion = new javax.swing.JTable();
        jLabelEmpresa = new javax.swing.JLabel();
        jLabelTipoImpuesto = new javax.swing.JLabel();
        jLabelNrodeLiquidacion = new javax.swing.JLabel();
        jLabelFechaLiquidacion = new javax.swing.JLabel();
        jLabelPeriodo = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldMontoTotal = new javax.swing.JTextField();
        jLabelPeriodo2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonDescargar = new javax.swing.JButton();

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

        setTitle("Operaciones");

        jLabel1.setText("Empresa:");

        jLabel2.setText("Tipo Impuesto");

        jLabel3.setText("Nro de liquidacion");

        jLabel4.setText("Fecha liquidacion");

        jLabel5.setText("Periodo liquidado:");

        jTableOperacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jTableOperacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "nroOperacion", "nroComprobante", "importePagado", "montoComision"
            }
        ));
        jScrollPane2.setViewportView(jTableOperacion);

        jLabelEmpresa.setText("jLabel6");

        jLabelTipoImpuesto.setText("jLabel7");

        jLabelNrodeLiquidacion.setText("jLabel8");

        jLabelFechaLiquidacion.setText("jLabel9");

        jLabelPeriodo.setText("jLabel10");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Monto Comision Total");

        jTextFieldMontoTotal.setEditable(false);
        jTextFieldMontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMontoTotalActionPerformed(evt);
            }
        });

        jLabelPeriodo2.setText("jLabel6");

        jLabel6.setText("-");
        jLabel6.setEnabled(false);

        buttonDescargar.setText("Imprimir");
        buttonDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addComponent(jLabelNrodeLiquidacion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFechaLiquidacion))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEmpresa)
                                    .addComponent(jLabelTipoImpuesto)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPeriodo)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPeriodo2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonDescargar)
                            .addComponent(jButtonCancelar))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTipoImpuesto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelNrodeLiquidacion)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelFechaLiquidacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelPeriodo)
                    .addComponent(jLabel6)
                    .addComponent(jLabelPeriodo2))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDescargar)
                .addGap(13, 13, 13)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMontoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMontoTotalActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void buttonDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDescargarActionPerformed
       PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.PORTRAIT);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new Printer(this), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(IUMostrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       /* MessageFormat header = new MessageFormat("Operaciones");
      MessageFormat footer = new MessageFormat("Pagina 1");
      try {
          jTableOperacion.print(JTable.PrintMode.NORMAL, header, footer);
      } catch(Exception e){
          JOptionPane.showMessageDialog(this,e.getMessage());
      }*/
       
       /*
         String pdfFilename = "‪D:\\UTN\\reports\\reportTest.pdf";
  PrinterPDF printReport = new PrinterPDF();
  printReport.createPDF(pdfFilename);
       */
    }//GEN-LAST:event_buttonDescargarActionPerformed

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
            java.util.logging.Logger.getLogger(IUMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUMostrar("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDescargar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabelEmpresa;
    public static javax.swing.JLabel jLabelFechaLiquidacion;
    public static javax.swing.JLabel jLabelNrodeLiquidacion;
    public static javax.swing.JLabel jLabelPeriodo;
    public static javax.swing.JLabel jLabelPeriodo2;
    public static javax.swing.JLabel jLabelTipoImpuesto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jTableOperacion;
    public static javax.swing.JTextField jTextFieldMontoTotal;
    // End of variables declaration//GEN-END:variables
}
