/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida;

import java.awt.Component;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Utils.MetodosPantalla;

public class IUGestionarEmpresaAdheridaModificacion extends javax.swing.JFrame {

    DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
    
   ControladorGestionarEmpresaAdherida controlador = new ControladorGestionarEmpresaAdherida();
    public IUGestionarEmpresaAdheridaModificacion(DTOEmpresaExistente dtoEe) {
        initComponents();
        this.setLocationRelativeTo(null);
        TextField_Cuit.setText(dtoEe.getCuitEmpresaExistente());
        TextField_Nombre.setText(dtoEe.getNombreEmpresaExistente());
        TextField_Direccion.setText(dtoEe.getDireccionEmpresaExistente());
        CheckBox_Habilitada.setText(dtoEe.getHabilitadaEmpresaExistente());
        comboBoxTipoImpuesto.setSelectedItem(dtoEe.getTipoImpuestoEmpresaEmpresaExistente().toString());
        comboBoxTipoEmpresa.setSelectedItem(dtoEe.getNombreTipoEmpresaEmpresaExistente().toString());
        
        SpinnerNumberModel sf = new SpinnerNumberModel();
        sf.setMinimum(0);
        sf.setValue(Integer.parseInt(dtoEe.getFrecuenciaLiquidacionEmpresaTipoImpuesto()));
        spinner_Frecuencia.setModel(sf);
        
        
        //TextField_frec.setText(dtoEe.);
        List<DTOTipoEmpresa> listTipoEmpresa = controlador.buscarTipoEmpresa();
        llenarComboTipoEmpresa(listTipoEmpresa);
        List<DTOTipoImpuesto> listTipoImpuesto = controlador.buscarTipoImpuesto();
        llenarComboTipoImpuesto(listTipoImpuesto);
        this.dtoEe = dtoEe;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CheckBox_Habilitada = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextField_Nombre = new javax.swing.JTextField();
        TextField_Direccion = new javax.swing.JTextField();
        Button_Guardar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();
        TextField_Cuit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        GestionarItems = new javax.swing.JButton();
        comboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        comboBoxTipoEmpresa = new javax.swing.JComboBox<>();
        label_frec = new javax.swing.JLabel();
        spinner_Frecuencia = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Direccion");

        jLabel2.setText("Nombre");

        CheckBox_Habilitada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_HabilitadaActionPerformed(evt);
            }
        });

        jLabel1.setText("Cuit");

        jLabel4.setText("Habilitada ");

        TextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_NombreActionPerformed(evt);
            }
        });

        TextField_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_DireccionActionPerformed(evt);
            }
        });

        Button_Guardar.setText("Guardar");
        Button_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_GuardarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");
        Button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelarActionPerformed(evt);
            }
        });

        TextField_Cuit.setEditable(false);
        TextField_Cuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CuitActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de Impuesto");

        jLabel6.setText("Tipo de Empresa");

        GestionarItems.setText("Gestionar Items");
        GestionarItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarItemsActionPerformed(evt);
            }
        });

        comboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        label_frec.setText("Frecuencia Liquidacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GestionarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Button_Cancelar)
                        .addGap(19, 19, 19)
                        .addComponent(Button_Guardar)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(label_frec))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboBoxTipoEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxTipoImpuesto, 0, 266, Short.MAX_VALUE)
                                .addComponent(TextField_Direccion)
                                .addComponent(TextField_Nombre)
                                .addComponent(TextField_Cuit))
                            .addComponent(CheckBox_Habilitada)
                            .addComponent(spinner_Frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextField_Cuit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxTipoImpuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_frec)
                    .addComponent(spinner_Frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(CheckBox_Habilitada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cancelar)
                    .addComponent(Button_Guardar)
                    .addComponent(GestionarItems))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
   
    private void Button_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GuardarActionPerformed
    
        String cuit= TextField_Cuit.getText();
        String nombre = TextField_Nombre.getText();
        String nuevoTipoImpuesto = comboBoxTipoImpuesto.getSelectedItem().toString();
        String anteriorTipoImpuesto = dtoEe.getTipoImpuestoEmpresaEmpresaExistente();
        String nuevoTipoEmpresa = comboBoxTipoEmpresa.getSelectedItem().toString();
        String anteriorTipoEmpresa = dtoEe.getNombreTipoEmpresaEmpresaExistente();
        String direccion = TextField_Direccion.getText();
        int frecuenciaLiquidacion = (int) spinner_Frecuencia.getValue();
        boolean habilitada =  CheckBox_Habilitada.isSelected();
       
// Ahora cuando modifica todo, lleva un monton de guasadas :D
        controlador.modificarEmpresa(cuit, nombre, nuevoTipoImpuesto, anteriorTipoImpuesto, nuevoTipoEmpresa, anteriorTipoEmpresa, direccion, habilitada, frecuenciaLiquidacion);
        this.dispose();

    }//GEN-LAST:event_Button_GuardarActionPerformed

    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_Button_CancelarActionPerformed

    private void TextField_CuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CuitActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TextField_CuitActionPerformed

    private void TextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_NombreActionPerformed

    private void GestionarItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarItemsActionPerformed
            Vector vct = new Vector();
            vct.add(dtoEe.getCuitEmpresaExistente());
            vct.add(dtoEe.getNombreEmpresaExistente().toString());
            vct.add(dtoEe.getTipoImpuestoEmpresaEmpresaExistente().toString());
            vct.add(dtoEe.getNombreTipoEmpresaEmpresaExistente());
         
            
            controlador.gestionarItems(vct, controlador);
    }//GEN-LAST:event_GestionarItemsActionPerformed

    private void TextField_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_DireccionActionPerformed

    private void comboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoImpuestoActionPerformed

    private void CheckBox_HabilitadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_HabilitadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_HabilitadaActionPerformed

   

    public JCheckBox getCheckBox_Habilitada() {
        return CheckBox_Habilitada;
    }

    public void setCheckBox_Habilitada(JCheckBox CheckBox_Habilitada) {
        this.CheckBox_Habilitada = CheckBox_Habilitada;
    }

    public JTextField getTextField_Cuit() {
        return TextField_Cuit;
    }

    public void setTextField_Cuit(JTextField TextField_Cuit) {
        this.TextField_Cuit = TextField_Cuit;
    }

    public JTextField getTextField_Direccion() {
        return TextField_Direccion;
    }

    public void setTextField_Direccion(JTextField TextField_Direccion) {
        this.TextField_Direccion = TextField_Direccion;
    }

    public JTextField getTextField_Nombre() {
        return TextField_Nombre;
    }

    public void setTextField_Nombre(JTextField TextField_Nombre) {
        this.TextField_Nombre = TextField_Nombre;
    }

    public JComboBox<String> getComboBoxTipoEmpresa() {
        return comboBoxTipoEmpresa;
    }

    public void setComboBoxTipoEmpresa(JComboBox<String> ComboBoxTipoEmpresa) {
        this.comboBoxTipoEmpresa = ComboBoxTipoEmpresa;
    }

    public JComboBox<String> getComboBoxTipoImpuesto() {
        return comboBoxTipoImpuesto;
    }

    public void setComboBoxTipoImpuesto(JComboBox<String> ComboBoxTipoImpuesto) {
        this.comboBoxTipoImpuesto = ComboBoxTipoImpuesto;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Guardar;
    private javax.swing.JCheckBox CheckBox_Habilitada;
    private javax.swing.JButton GestionarItems;
    private javax.swing.JTextField TextField_Cuit;
    private javax.swing.JTextField TextField_Direccion;
    private javax.swing.JTextField TextField_Nombre;
    private javax.swing.JComboBox<String> comboBoxTipoEmpresa;
    private javax.swing.JComboBox<String> comboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_frec;
    private javax.swing.JSpinner spinner_Frecuencia;
    // End of variables declaration//GEN-END:variables
}
