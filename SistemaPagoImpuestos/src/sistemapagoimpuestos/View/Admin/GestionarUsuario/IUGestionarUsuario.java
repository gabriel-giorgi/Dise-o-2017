/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarUsuario;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Controller.ControladorGestionarUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;

/**
 *
 * @author Rodri
 */
public class IUGestionarUsuario extends javax.swing.JFrame {

    ControladorGestionarUsuario controlador = new ControladorGestionarUsuario();
    
    public IUGestionarUsuario() {
        initComponents();
        obtenerUsuario();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_Alta = new javax.swing.JButton();
        button_modificacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuario = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        button_filtrar = new javax.swing.JButton();
        button_Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gestionar Usuario");

        jLabel2.setText("Seleccione una opción");

        button_Alta.setText("Alta");
        button_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AltaActionPerformed(evt);
            }
        });

        button_modificacion.setText("Modificación");
        button_modificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificacionActionPerformed(evt);
            }
        });

        tabla_usuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_usuario);

        button_filtrar.setText("Filtrar");
        button_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_filtrarActionPerformed(evt);
            }
        });

        button_Actualizar.setText("Actualizar");
        button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(460, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_Alta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(button_modificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button_filtrar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_Actualizar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_filtrar)
                    .addComponent(button_Actualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Alta)
                    .addComponent(button_modificacion))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AltaActionPerformed
        controlador.mostrarPantallaAlta();
    }//GEN-LAST:event_button_AltaActionPerformed

    private void button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ActualizarActionPerformed
        obtenerUsuario();
    }//GEN-LAST:event_button_ActualizarActionPerformed

    private void button_modificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificacionActionPerformed
        try{
            int columnaNombre = 0;
            int fila = tabla_usuario.getSelectedRow();
        String nombreUsuario = tabla_usuario.getValueAt(fila, columnaNombre).toString();
        controlador.modificarUsuario(nombreUsuario);
        } catch (Exception e){
            exceptions.Excepciones.getInstance().objetoNoSeleccionado();
        }
        
    }//GEN-LAST:event_button_modificacionActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_usuario.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
        tabla_usuario.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarUsuario().setVisible(true);
            }
        });
    }
    
       public void obtenerUsuario() {

        ArrayList<DTOUsuario> listDtoUsuario = controlador.obtenerUsuario();

        String[] columnas = {"Nombre", "Password", "Fecha Inhabilitacion", "Fecha Ulitmo Acceso", "Tipo Usuario", "Empresa Asociada"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Date.class;
                    case 3:
                        return Date.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;                        
                    default:
                        return null;
                }
            }
        };
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (DTOUsuario dtoUsuario : listDtoUsuario) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoUsuario.getNombreDTOUsuario());
            vect.add(dtoUsuario.getPasswordDTOUsuario());
            vect.add(dtoUsuario.getFechaHoraInhabilitacionDTOUsuario());
            vect.add(dtoUsuario.getFechaHoraUltimoIngresoSistemaDTOUsuario());
            vect.add(dtoUsuario.getTipoUsuarioDTOUsuario());
            vect.add(dtoUsuario.getEmpresaDTOUsuario());

            String fecha = "";
            if (dtoUsuario.getFechaHoraInhabilitacionDTOUsuario() != null) {
                fecha = sdf.format(dtoUsuario.getFechaHoraInhabilitacionDTOUsuario()).toString();
            }
            vect.add(fecha);
            dtm.addRow(vect);
        }
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(jLabel1.CENTER);
                return this;
            }
        };

        tabla_usuario.setModel(dtm);
        tabla_usuario.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_usuario.getColumnModel().getColumn(1).setCellRenderer(r);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Actualizar;
    private javax.swing.JButton button_Alta;
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_modificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla_usuario;
    // End of variables declaration//GEN-END:variables
}
