package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuestoItems;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DtoItemOrden;
import static sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems.setNuevoTipoImpuesto;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoModificar extends javax.swing.JFrame {

    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    private static List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList = new ArrayList<>();

    public static List<DTOEmpresaTipImpItem> getdTOEmpresaTipImpItemList() {
        return dTOEmpresaTipImpItemList;
    }

    public static void setdTOEmpresaTipImpItemList(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList) {
        IUGestionarTipoImpuestoModificar.dTOEmpresaTipImpItemList = dTOEmpresaTipImpItemList;
    }

    public String getNombre_actual() {
        return nombre_actual.getText();
    }

    public void setNombre_actual(String nombre_actual) {
        this.nombre_actual.setText(nombre_actual);
    }


    
    public static  void adddTOEmpresaTipImpItemList(DTOEmpresaTipImpItem dTOEmpresaTipImpItem){
         if(dTOEmpresaTipImpItemList==null){
            dTOEmpresaTipImpItemList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemList.add(dTOEmpresaTipImpItem);
    }
    public static void removedTOEmpresaTipImpItemList(int index){
       dTOEmpresaTipImpItemList.remove(index);
    }    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
  
    public IUGestionarTipoImpuestoModificar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_deshabilitar = new javax.swing.JLabel();
        label_esEditable = new javax.swing.JLabel();
        textfield_nombre = new javax.swing.JTextField();
        checkbox_habilitado = new javax.swing.JCheckBox();
        checkbox_esEditable = new javax.swing.JCheckBox();
        button_modificar = new javax.swing.JButton();
        nombre_actual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empresa_item_mod = new javax.swing.JTable();
        cancel_button = new javax.swing.JButton();
        button_add_EA = new javax.swing.JButton();
        button_delete_EA = new javax.swing.JButton();
        label_fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nuevo nombre");
        label_nombre.setToolTipText("");

        label_deshabilitar.setText("Habilitado");

        label_esEditable.setText("Es editable");

        textfield_nombre.setToolTipText("");
        textfield_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_nombreActionPerformed(evt);
            }
        });

        button_modificar.setText("Modificar");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
            }
        });

        nombre_actual.setForeground(new java.awt.Color(240, 240, 240));
        nombre_actual.setText("nombreActual");

        jScrollPane1.setViewportView(tabla_empresa_item_mod);

        cancel_button.setText("Cancelar");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        button_add_EA.setText("Añadir");
        button_add_EA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_EAActionPerformed(evt);
            }
        });

        button_delete_EA.setText("Eleminar");
        button_delete_EA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delete_EAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_esEditable)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_deshabilitar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_delete_EA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_EA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 319, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkbox_habilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox_esEditable))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label_fecha))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(nombre_actual)))
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(cancel_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_modificar)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nombre))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label_deshabilitar)
                        .addGap(37, 37, 37)
                        .addComponent(label_esEditable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbox_habilitado)
                            .addComponent(label_fecha))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkbox_esEditable)
                            .addComponent(nombre_actual))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_modificar)
                            .addComponent(cancel_button))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(button_add_EA)
                        .addGap(67, 67, 67)
                        .addComponent(button_delete_EA)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
        try{
            if(textfield_nombre.getText().equals("")){
                textfield_nombre.setText(null);
                throw new java.lang.NumberFormatException();
            }
            controlador.modificarTipoImpuesto(textfield_nombre.getText(), nombre_actual.getText(), checkbox_esEditable.isSelected(), checkbox_habilitado.isSelected(), dTOEmpresaTipImpItemList);
            this.dispose();
            controlador.iniciar();
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Nombre"));
        }
    }//GEN-LAST:event_button_modificarActionPerformed

    private void textfield_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_nombreActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        controlador.iniciar();
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void button_add_EAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_EAActionPerformed
        IUGestionarTipoImpuestoItems pantallaGestionarTIItems = new IUGestionarTipoImpuestoItems();
        pantallaGestionarTIItems.setLocationRelativeTo(null);
        pantallaGestionarTIItems.setVisible(true);
        setNuevoTipoImpuesto(false);
        pantallaGestionarTIItems.setCodigoTemp(textfield_nombre.getText());
        pantallaGestionarTIItems.setEditTemp(checkbox_esEditable.isSelected());
        pantallaGestionarTIItems.setStatusTemp(checkbox_habilitado.isSelected());
        pantallaGestionarTIItems.setdTOEmpresaTipImpItemList(getdTOEmpresaTipImpItemList());
        this.dispose();
    }//GEN-LAST:event_button_add_EAActionPerformed

    private void button_delete_EAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delete_EAActionPerformed
         try {
            DefaultTableModel model = (DefaultTableModel) tabla_empresa_item_mod.getModel();
            int rowSelected = tabla_empresa_item_mod.getSelectedRow();
             removedTOEmpresaTipImpItemList(rowSelected);
            model.removeRow(rowSelected);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_button_delete_EAActionPerformed
    
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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Asociacion con el controlador
                IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();

            }
        });
    }
    
        public void obtenerEmpresaItems(List<DTOEmpresaTipoImpuestoItems> empresaTipoImpuestoItem) {
        
        for (DTOEmpresaTipoImpuestoItems dTOEmpresaTipoImpuestoItems : empresaTipoImpuestoItem) {
            DTOEmpresaTipImpItem dTOEmpresaTipImpItem = new DTOEmpresaTipImpItem();
            dTOEmpresaTipImpItem.setNombreEmpresa(dTOEmpresaTipoImpuestoItems.getdTOEmpresa().getNombreEmpresa());
            dTOEmpresaTipImpItem.setNombreTipoEmpresa(dTOEmpresaTipoImpuestoItems.getdTOTipoEmpresa().getNombreTipoEmpresa());
            dTOEmpresaTipImpItem.setFrecuenciaSincronizacion(dTOEmpresaTipoImpuestoItems.getFrecuenciaSincro());
            for(DTOItem dTOItem : dTOEmpresaTipoImpuestoItems.getdTOItems()){
                //dTOEmpresaTipImpItem.setFrecuenciaSincronizacion(dTOEmpresaTipoImpuestoItems);
                dTOEmpresaTipImpItem.addItem(new DtoItemOrden(dTOItem.getNombreItem(), dTOEmpresaTipImpItem.getFrecuenciaSincronizacion()));
            }
            adddTOEmpresaTipImpItemList(dTOEmpresaTipImpItem);
        }
    }
  public void RecuperarEmpresaItems() {
        // Muestro pantalla de Consultar
        String[] columnas = {"Empresa", "Tipo Empresa", "Frec. Liquidacion", "Items"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }

            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return int.class;
                    case 3:
                        return String.class;
                    default:
                        return null;
                }
            }

        };

        for (DTOEmpresaTipImpItem dTOEmpresaTipImpItem : dTOEmpresaTipImpItemList) {
            Vector<Object> vect = new Vector<>();
            vect.add(dTOEmpresaTipImpItem.getNombreEmpresa());
            vect.add(dTOEmpresaTipImpItem.getNombreTipoEmpresa());
            vect.add(dTOEmpresaTipImpItem.getFrecuenciaSincronizacion());
            vect.add(dTOEmpresaTipImpItem.concatItems());
            dtm.addRow(vect);
        }

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_empresa_item_mod.setModel(dtm);
        tabla_empresa_item_mod.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_empresa_item_mod.getColumnModel().getColumn(1).setCellRenderer(r);
    }

       
        
    // Getters

    public String getTextfield_nombre() {
        return textfield_nombre.getText();
    }

    public void setTextfield_nombre(String text) {
        this.textfield_nombre.setText(text);
    }
    


    public boolean getCheckbox_deshabilitar() {
        return checkbox_habilitado.isSelected();
    }

    public void setCheckbox_Habilitar(boolean habilitado) {
        this.checkbox_habilitado.setSelected(habilitado);
    }

    public boolean getCheckbox_esEditable() {
        return checkbox_esEditable.isSelected();
    }

    public void setCheckbox_esEditable(boolean editable) {
        this.checkbox_esEditable.setSelected(editable);
    }

    public JLabel getLabel_fecha() {
        return label_fecha;
    }

    public void setLabel_fecha(JLabel label_fecha) {
        this.label_fecha = label_fecha;
    }

    public String getLabel_nombre() {
        return label_nombre.getText();
    }

    public void setLabel_nombre(String nombre) {
        this.label_nombre.setText(nombre);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add_EA;
    private javax.swing.JButton button_delete_EA;
    private javax.swing.JButton button_modificar;
    private javax.swing.JButton cancel_button;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JCheckBox checkbox_habilitado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_deshabilitar;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel nombre_actual;
    private javax.swing.JTable tabla_empresa_item_mod;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}
