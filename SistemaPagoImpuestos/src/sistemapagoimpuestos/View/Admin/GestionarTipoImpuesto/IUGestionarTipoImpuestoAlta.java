package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import static sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems.setNuevoTipoImpuesto;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoAlta extends javax.swing.JFrame {

    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    
    public IUGestionarTipoImpuestoAlta() {
        initComponents();
    }
    public static List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemAltaList;

    public static List<DTOEmpresaTipImpItem> getDtoetiisModfAlta() {
        return dTOEmpresaTipImpItemAltaList;
    }

    public static void setDtoetiisModfAlta(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem) {
        dTOEmpresaTipImpItem = dTOEmpresaTipImpItem;
    }

    public static void addDtoetiisModfAlta(DTOEmpresaTipImpItem dTOEmpresaTipImpItem) {
        if (dTOEmpresaTipImpItemAltaList == null) {
            dTOEmpresaTipImpItemAltaList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemAltaList.add(dTOEmpresaTipImpItem);
    }

    public static void removeDtoetiisModfAlta(int index) {
        dTOEmpresaTipImpItemAltaList.remove(index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        label_esEditable = new javax.swing.JLabel();
        textField_nombre = new javax.swing.JTextField();
        textfield_codigo = new javax.swing.JTextField();
        checkbox_esEditable = new javax.swing.JCheckBox();
        button_crear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empresa_item = new javax.swing.JTable();
        button_add_EA = new javax.swing.JButton();
        button_delete_EA = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre Tipo Impuesto");

        label_codigo.setText("Código Tipo Impuesto");

        label_esEditable.setText("Es editable");

        textField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_nombreActionPerformed(evt);
            }
        });

        button_crear.setText("Crear");
        button_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_crearActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla_empresa_item);

        button_add_EA.setText("Añadir");
        button_add_EA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_EAActionPerformed(evt);
            }
        });

        button_delete_EA.setText("Eliminar");
        button_delete_EA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delete_EAActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancelar");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_codigo)
                            .addComponent(label_nombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(label_esEditable)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkbox_esEditable)
                        .addGap(85, 85, 85))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cancel_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_crear)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_delete_EA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_EA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(textField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_esEditable)
                    .addComponent(checkbox_esEditable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(button_add_EA)
                        .addGap(67, 67, 67)
                        .addComponent(button_delete_EA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_crear)
                    .addComponent(cancel_button))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_crearActionPerformed
        // Obtengo los valores
        try {
            int codigoTipoImpuestoIngres = Integer.parseInt(textfield_codigo.getText());
            String nombreTipoImpuestoIngres = textField_nombre.getText();
            boolean esMontoEditableIngres = checkbox_esEditable.isSelected();
            List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemIngres = getDtoetiisModfAlta();
            if (codigoTipoImpuestoIngres < 0 || !nombreTipoImpuestoIngres.equals("")) {
                controlador.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres, dTOEmpresaTipImpItemIngres);
                this.dispose();
                controlador.iniciar();
            } else {
                Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo", "Nombre"));
            }

        } catch (java.lang.NumberFormatException e) {
            List<String> campos = Arrays.asList("Codigo del tipo entero");
            Excepciones.getInstance().tipoDatoInvalid(campos);
        }
    }//GEN-LAST:event_button_crearActionPerformed

    private void button_add_EAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_EAActionPerformed
        controlador.mostrarPantallaGestionETI(textfield_codigo.getText(), textField_nombre.getText(), checkbox_esEditable.isSelected());
        this.dispose();
    }//GEN-LAST:event_button_add_EAActionPerformed

    private void button_delete_EAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delete_EAActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tabla_empresa_item.getModel();
            int rowSelected = tabla_empresa_item.getSelectedRow();
            removeDtoetiisModfAlta(rowSelected);
            model.removeRow(rowSelected);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_button_delete_EAActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        controlador.iniciar();
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void textField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarTipoImpuestoAlta().setVisible(true);
            }
        });
    }

    public void generarEmpresaItems() {

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

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_empresa_item.setModel(dtm);
        tabla_empresa_item.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_empresa_item.getColumnModel().getColumn(1).setCellRenderer(r);
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

        for (DTOEmpresaTipImpItem dTOEmpresaTipImpItem : dTOEmpresaTipImpItemAltaList) {
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
        tabla_empresa_item.setModel(dtm);
        tabla_empresa_item.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_empresa_item.getColumnModel().getColumn(1).setCellRenderer(r);
    }

    public boolean getCheckbox_esEditable() {
        return checkbox_esEditable.isSelected();
    }

    public void setCheckbox_esEditable(boolean checkbox_esEditable) {
        this.checkbox_esEditable.setSelected(checkbox_esEditable);
    }

    public String getTextField_nombre() {
        return textField_nombre.getText();
    }

    public void setTextField_nombre(String textField_nombre) {
        this.textField_nombre.setText(textField_nombre);
    }

    public String getTextfield_codigo() {
        return textfield_codigo.getText();
    }

    public void setTextfield_codigo(String textfield_codigo) {
        this.textfield_codigo.setText(textfield_codigo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add_EA;
    private javax.swing.JButton button_crear;
    private javax.swing.JButton button_delete_EA;
    private javax.swing.JButton cancel_button;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JTable tabla_empresa_item;
    private javax.swing.JTextField textField_nombre;
    private javax.swing.JTextField textfield_codigo;
    // End of variables declaration//GEN-END:variables
}
