/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems;


public class IUGestionarEmpresaAdheridaCrear extends javax.swing.JFrame {
 
ControladorGestionarEmpresaAdherida controlador = new ControladorGestionarEmpresaAdherida();
    
    public IUGestionarEmpresaAdheridaCrear(Object controlador) {
        initComponents();
        cargarMetodos();
        setLocationRelativeTo(null);
  ;


    }

//No se si lo de llamar para que se llenen los comboBox va aca :D

    public void cargarMetodos() {
        List<DTOTipoEmpresa> listTipoEmpresa = controlador.buscarTipoEmpresa();
        llenarComboTipoEmpresa(listTipoEmpresa);
        List<DTOTipoImpuesto> listTipoImpuesto = controlador.buscarTipoImpuesto();
        llenarComboTipoImpuesto(listTipoImpuesto);
        List<DTOEmpresa> listEmpresa = controlador.buscarEmpresa();
        llenarComboEmpresa(listEmpresa);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Cancelar = new javax.swing.JButton();
        Button_Guardar = new javax.swing.JButton();
        comboBoxTipoEmpresa = new javax.swing.JComboBox<>();
        comboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Spinner_Frecuencia = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ComboBox_Empresa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Button_Cancelar.setText("Cancelar");
        Button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelarActionPerformed(evt);
            }
        });

        Button_Guardar.setText("Guardar");
        Button_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_GuardarActionPerformed(evt);
            }
        });

        comboBoxTipoEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Empresa" }));

        comboBoxTipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Impuesto" }));
        comboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de Impuesto");

        jLabel6.setText("Tipo de Empresa");

        jLabel7.setText("Frecuencia Liquidacion");

        jLabel8.setText("Empresa");

        ComboBox_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_EmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBox_Empresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxTipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxTipoEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Spinner_Frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_Cancelar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Spinner_Frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cancelar)
                    .addComponent(Button_Guardar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_Button_CancelarActionPerformed

    private void Button_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GuardarActionPerformed

        String nombreEmpresa = ComboBox_Empresa.getSelectedItem().toString();
        String tipoImpuesto = comboBoxTipoImpuesto.getSelectedItem().toString();
        String tipoEmpresa = comboBoxTipoEmpresa.getSelectedItem().toString();
        int frecuencia = (int) Spinner_Frecuencia.getValue();
        

        controlador.ingresarDatosEmpresa(nombreEmpresa, tipoImpuesto, tipoEmpresa, frecuencia);
        // controlador.ingresarDatosEmpresa(cuitEmpresa, nombreEmpresa, direccionEmpresa,  habilitada);
        this.dispose();

    }//GEN-LAST:event_Button_GuardarActionPerformed

    private void ComboBox_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_EmpresaActionPerformed

    private void comboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoImpuestoActionPerformed

    
    //Con esto llena el combo del TipoEmpresa
    public void llenarComboTipoEmpresa(List<DTOTipoEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOTipoEmpresa dTOTipoEmpresa = (DTOTipoEmpresa) list.get(i);
            comboBoxTipoEmpresa.addItem(dTOTipoEmpresa.getNombreTipoEmpresa());
        }
    }
  
  //Con esto llena el combo TipoImpuesto
    public void llenarComboTipoImpuesto(List<DTOTipoImpuesto> list){
        for (int i = 0; i < list.size(); i++) {
            DTOTipoImpuesto dTOTipoImpuesto = (DTOTipoImpuesto) list.get(i);
            comboBoxTipoImpuesto.addItem(dTOTipoImpuesto.getNombreDTOTipoImpuesto());
        }
    }
    
public void llenarComboEmpresa(List<DTOEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOEmpresa dTOEmpresa = (DTOEmpresa) list.get(i);
            ComboBox_Empresa.addItem(dTOEmpresa.getNombreEmpresa());
        }
    }
  

    public static void setDtoetiisModfAlta(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem) {
        dTOEmpresaTipImpItem = dTOEmpresaTipImpItem;
    }
    
    

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
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new IUGestionarEmpresaAdheridaCrear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Guardar;
    private javax.swing.JComboBox<String> ComboBox_Empresa;
    private javax.swing.JSpinner Spinner_Frecuencia;
    private javax.swing.JComboBox<String> comboBoxTipoEmpresa;
    private javax.swing.JComboBox<String> comboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
