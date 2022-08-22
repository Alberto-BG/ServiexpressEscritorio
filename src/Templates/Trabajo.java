/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Templates;

import Controller.EmpleadoDAO;
import Controller.ProductoDAO;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;
import Model.Producto;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Bastian
 */
public class Trabajo extends javax.swing.JFrame {

    /**
     * Creates new form Catalogo
     */
    public String rut;
    public String id_hora;
    public String valor;
    public Trabajo() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtValor.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTrabajo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtPatente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtValor = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 420, 150));

        jLabel2.setForeground(java.awt.SystemColor.control);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel3.setForeground(java.awt.SystemColor.control);
        jLabel3.setText("Patente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txtCliente.setEditable(false);
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, -1));

        txtPatente.setEditable(false);
        getContentPane().add(txtPatente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, -1));

        jLabel4.setForeground(java.awt.SystemColor.control);
        jLabel4.setText("Trabajo realizado: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/volver.png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otros", "Mantención de frenos", "Cambio de Aceite", "Reemplazo de pieza", "Alineación y rotación de ruedas", "Sistemas de suspensión" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 220, -1));

        jScrollPane1.setViewportView(txtValor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 170, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abstract-red-gradient-background-red-orange-curve-wallpaper-free-vector.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        this.setVisible(false);
        MisHorasMecanico mh = new MisHorasMecanico(rut);
        mh.rut = this.rut;
        mh.setVisible(true);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        String Diagnostico = txtTrabajo.getText();
        int valor = Integer.valueOf(txtValor.getText());
        String rutCliente = txtCliente.getText();
        String estado = "COMPLETADO";
        String mecanico = this.rut;
        String hora = this.id_hora;
        EmpleadoDAO emp = new EmpleadoDAO();;
        int respuesta=emp.FinalizarTrabajo(Diagnostico,estado,rutCliente,valor,mecanico,hora);
        if (respuesta == 1){
            JOptionPane.showMessageDialog(null, "Servicio Finalizado");
            this.setVisible(false);
            MisHorasMecanico m = new MisHorasMecanico(mecanico);
            m.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Comprueba los campos");
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
               if (evt.getStateChange() == ItemEvent.SELECTED) {
          String item = (String)evt.getItem();
             if (item.equals("Otros")) {
                 this.txtValor.enable();
                 txtValor.setText("0");
                 this.valor = txtValor.getText();
             }else if (item.equals("Mantención de frenos")){
                 txtValor.setText("20000");
                 this.txtValor.setEditable(false);
                 this.valor = txtValor.getText();
             }else if (item.equals("Cambio de Aceite")){
                 txtValor.setText("30000");
                 this.txtValor.setEditable(false);
                 this.valor = txtValor.getText();
             }else if (item.equals("Reemplazo de pieza")){
                 txtValor.setText("15000");
                 this.txtValor.setEditable(false);
                 this.valor = txtValor.getText();
             }else if (item.equals("Alineación y rotación de ruedas")){
                 txtValor.setText("25000");
                 this.txtValor.setEditable(false);
                 this.valor = txtValor.getText();
             }else if (item.equals("Sistemas de suspensión")){
                 txtValor.setText("15000");
                 this.txtValor.setEditable(false);
                 this.valor = txtValor.getText();
             }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
            java.util.logging.Logger.getLogger(Trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trabajo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtPatente;
    public javax.swing.JTextField txtTrabajo;
    private javax.swing.JTextPane txtValor;
    // End of variables declaration//GEN-END:variables

   
    
}