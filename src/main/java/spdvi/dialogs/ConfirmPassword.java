/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi.dialogs;

import spdvi.helpers.DataAccess;
import spdvi.pojos.User;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Joan Andreu
 */
public class ConfirmPassword extends javax.swing.JDialog {

    private String email;
    private String codi;

    /**
     * Creates new form ConfirmPassword
     */
    public ConfirmPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCodi = new javax.swing.JLabel();
        lblContrasenya = new javax.swing.JLabel();
        lblConfirmContrasenya = new javax.swing.JLabel();
        btnCodi = new javax.swing.JButton();
        txtContrasenya = new javax.swing.JPasswordField();
        txtConfirmContrasenya = new javax.swing.JPasswordField();
        txtCodi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodi.setText("Introdueix codi:");
        lblCodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCodiMouseExited(evt);
            }
        });
        jPanel1.add(lblCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblContrasenya.setText("Introdueix nova contrasenya:");
        lblContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblContrasenyaMouseExited(evt);
            }
        });
        jPanel1.add(lblContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        lblConfirmContrasenya.setText("Confirma la contrasenya:");
        lblConfirmContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConfirmContrasenyaMouseExited(evt);
            }
        });
        jPanel1.add(lblConfirmContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btnCodi.setText("Cofirmar Codi");
        btnCodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodiActionPerformed(evt);
            }
        });
        jPanel1.add(btnCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 120, 30));
        jPanel1.add(txtContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 190, -1));
        jPanel1.add(txtConfirmContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, -1));
        jPanel1.add(txtCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/azul.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodiActionPerformed
        String password = new String(txtContrasenya.getPassword());
        
        Pattern passwordRegEx = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");
        if (passwordRegEx.matcher(password).matches()) {
        
        DataAccess da = new DataAccess();
        ArrayList<User> users = da.getUsers();
        boolean userExists = false;

        if (codi.equals(txtCodi.getText())) {
            JOptionPane.showMessageDialog(null, "El codi introduit es correcte"); 
        } else {
            JOptionPane.showMessageDialog(null, "El codi introduit esta malement");
        }
        
        if(!new String(txtContrasenya.getPassword()).equals(new String(txtConfirmContrasenya.getPassword()))) {
            JOptionPane.showMessageDialog(null, "La contrasenya no coincideix");
        }
        
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                try {
                    da.updatePassword(new String(txtContrasenya.getPassword()), u.getUserName());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        setVisible(false);
        
        } else if (!passwordRegEx.matcher(password).matches()) {
            JOptionPane.showMessageDialog(null, "La contrasenya no cumpleix els minims requerits: " +
                    "\n" +
                    "Al menys 8 caracters\n" +
                    "\n" +
                    "Conte al menys un dígit\n" +
                    "\n" +
                    "Conte una Minuscula i una Mayuscula\n" +
                    "\n" +
                    "No conte espais, tabulacións, etc.");
        }
    }//GEN-LAST:event_btnCodiActionPerformed

    private void lblCodiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCodiMouseExited
        lblCodi.setForeground(Color.black);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblCodiMouseExited

    private void lblContrasenyaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContrasenyaMouseExited
        lblContrasenya.setForeground(Color.black);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblContrasenyaMouseExited

    private void lblConfirmContrasenyaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmContrasenyaMouseExited
        lblContrasenya.setForeground(Color.black);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblConfirmContrasenyaMouseExited

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
            java.util.logging.Logger.getLogger(ConfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmPassword dialog = new ConfirmPassword(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodi;
    private javax.swing.JLabel lblConfirmContrasenya;
    private javax.swing.JLabel lblContrasenya;
    private javax.swing.JTextField txtCodi;
    private javax.swing.JPasswordField txtConfirmContrasenya;
    private javax.swing.JPasswordField txtContrasenya;
    // End of variables declaration//GEN-END:variables

}