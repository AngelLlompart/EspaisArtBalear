/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.dialogs;

import spdvi.pojos.User;
import spdvi.dialogs.ConfirmPassword;
import java.awt.Frame;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import spdvi.helpers.DataAccess;
import spdvi.helpers.PasswordGenerator;
import spdvi.helpers.SendEmail;

/**
 *
 * @author angel
 */
public class Register extends javax.swing.JDialog {

    private static DataAccess da = new DataAccess();
    private static ArrayList<User> userlist = new ArrayList<>(da.getUsers());

    public Register(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnShowUsers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblUsername.setText("Username");

        lblEmail.setText("Email");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnShowUsers.setText("Show Users");
        btnShowUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnShowUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblUsername)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegister))
                        .addGap(27, 27, 27)
                        .addComponent(lblEmail))
                    .addComponent(btnCancel))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addComponent(btnShowUsers))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        boolean createUser = true;
        String password = "";

        for (User u : userlist) {
            if (u.getUserName().equals(txtUsername.getText()) || u.getEmail().equals(txtEmail.getText())) {
                password = "";
                createUser = false;
                if (u.getUserName().equals(txtUsername.getText())) {
                    incorrectUsername();
                }
                if (u.getEmail().equals(txtEmail.getText())) {
                    incorrectEmail();
                }
                break;
            } else {
                createUser = true;
            }
            
            if (createUser) {
                password = PasswordGenerator.getPassword(
                        PasswordGenerator.MINUSCULAS
                        + PasswordGenerator.MAYUSCULAS
                        + PasswordGenerator.ESPECIALES, 10);
                //String encriptMD5 = DigestUtils.md5Hex(password);
                User newUser = new User(txtUsername.getText(), txtEmail.getText(), password, false);
                da.insertUser(newUser);
                
                System.out.println(newUser.getPassword());
                
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendEmail(txtEmail);
                
                setVisible(false);
                ConfirmPassword cP = new ConfirmPassword((Frame) this.getParent(), true);
                cP.setVisible(true);
                break;
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void incorrectUsername() {
        System.err.println("Incorrect user");
        JOptionPane.showMessageDialog(null,
                "Aquest usuari ja existeix, introduesqui un diferent",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void incorrectEmail() {
        System.err.println("Incorrect email");
        JOptionPane.showMessageDialog(null,
                "Aquest email ja existeix, introduesqui un diferent",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void btnShowUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowUsersActionPerformed
        System.out.println(da.getUsers());
    }//GEN-LAST:event_btnShowUsersActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Register dialog = new Register(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnShowUsers;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
