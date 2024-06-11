/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package org.uv.bdnc_practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author francisco
 */
public class Departamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Empleados
     */

    public Departamento() throws SQLException {
        initComponents();
       lista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Clave = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

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

        setMinimumSize(new java.awt.Dimension(560, 130));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, 20));

        Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveActionPerformed(evt);
            }
        });
        getContentPane().add(Clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 180, -1));
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));

        jLabel1.setText("Clave");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      PojoDepartamento departamento = new PojoDepartamento();
      DaoDepartamento daodepartamento = new DaoDepartamento();
      departamento.setClave(Integer.parseInt(Clave.getText()));
      departamento.setNombre(Nombre.getText());
      boolean guardado = daodepartamento.guardar(departamento);
      
      if (guardado==true) {
        JOptionPane.showMessageDialog(this, "Se guardo correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Error al guardarr el registro", "Error", JOptionPane.ERROR_MESSAGE);
    }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      PojoDepartamento departamento = new PojoDepartamento();
      DaoDepartamento daodepartamento = new DaoDepartamento();
      departamento.setClave(Integer.parseInt(Clave.getText()));
      departamento.setNombre(Nombre.getText());
   
     boolean editado= daodepartamento.editar(departamento);
      if (editado==true) {
        JOptionPane.showMessageDialog(this, "Se edito correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Error al editar el registro", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      PojoDepartamento departamento = new PojoDepartamento();
      DaoDepartamento daodepartamento = new DaoDepartamento();
      departamento = daodepartamento.buscarid(Integer.parseInt(Clave.getText()));
      Nombre.setText(departamento.getNombre());
    
     
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    
    public void lista() throws SQLException {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("clave");
    model.addColumn("Nombre");
     String url = "jdbc:postgresql://172.17.0.2:5432/Ejemplo";
        String pdw = "password";
        String usr = "postgres";
        Connection con = DriverManager.getConnection(url, usr, pdw);
   
    Statement statement = con.createStatement();
    String query = "SELECT * FROM Departamento"; // Selecciona solo los datos de la tabla Departamento
    ResultSet resultSet = statement.executeQuery(query);
    Object[] departamento = new Object[2];
    model = (DefaultTableModel) jTable1.getModel();

    while (resultSet.next()) {
        departamento[0] = resultSet.getInt("clave");
        departamento[1] = resultSet.getString("nombre");
        model.addRow(departamento);
    }
    jTable1.setModel(model);
}
    

    
    
    
    
    
    
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           DaoDepartamento daodepartamento = new DaoDepartamento();  
             boolean eliminado = daodepartamento.eliminar(Integer.parseInt(Clave.getText()));
    
    if (eliminado) {
        JOptionPane.showMessageDialog(this, "Se eliminó correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveActionPerformed
Clave.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Clave;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
