/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.dialogs;

import java.awt.Color;
import spdvi.pojos.User;
import spdvi.dialogs.ConfirmPassword;
import java.awt.Frame;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
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

        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        PanelBotoRegister = new javax.swing.JPanel();
        lblTextRegister = new javax.swing.JLabel();
        PanelBotoCancel = new javax.swing.JPanel();
        lblTextCancel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(450, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        lblUsername.setText("Username");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(null);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsernameMousePressed(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, -1));

        lblEmail.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 180, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 180, 30));

        PanelBotoRegister.setBackground(new java.awt.Color(0, 134, 190));
        PanelBotoRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelBotoRegisterMousePressed(evt);
            }
        });

        lblTextRegister.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        lblTextRegister.setForeground(new java.awt.Color(255, 255, 255));
        lblTextRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextRegister.setText("Register");
        lblTextRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTextRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTextRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTextRegisterMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelBotoRegisterLayout = new javax.swing.GroupLayout(PanelBotoRegister);
        PanelBotoRegister.setLayout(PanelBotoRegisterLayout);
        PanelBotoRegisterLayout.setHorizontalGroup(
            PanelBotoRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(PanelBotoRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTextRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        PanelBotoRegisterLayout.setVerticalGroup(
            PanelBotoRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(PanelBotoRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTextRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );

        jPanel1.add(PanelBotoRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 90, 30));

        PanelBotoCancel.setBackground(new java.awt.Color(0, 134, 190));

        lblTextCancel.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        lblTextCancel.setForeground(new java.awt.Color(255, 255, 255));
        lblTextCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextCancel.setText("Cancel");
        lblTextCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTextCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTextCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTextCancelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelBotoCancelLayout = new javax.swing.GroupLayout(PanelBotoCancel);
        PanelBotoCancel.setLayout(PanelBotoCancelLayout);
        PanelBotoCancelLayout.setHorizontalGroup(
            PanelBotoCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(PanelBotoCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTextCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        PanelBotoCancelLayout.setVerticalGroup(
            PanelBotoCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(PanelBotoCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTextCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );

        jPanel1.add(PanelBotoCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertUser() {
        String email = txtEmail.getText();
        String username = txtUsername.getText();

        Pattern emailRegEx = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");

        if (emailRegEx.matcher(email).matches()) {
            User newUser = new User(username, email, "defaultpassword", false);
            da.insertUser(newUser);

            this.setVisible(false);

            SendEmail sendEmail = new SendEmail();
            String missatge = sendEmail.sendEmail(txtEmail);

            ConfirmPassword cp = new ConfirmPassword((Frame) this.getParent(), true);
            cp.setEmail(txtEmail.getText());
            cp.setCodi(missatge);
            cp.setVisible(true);
        } else {
            incorrectFormatEmail();
        }
    }

    private void incorrectUsername() {
        System.err.println("Incorrect user");
        JOptionPane.showMessageDialog(null,
                "   Aquest usuari ja existeix \n"
                + "   Introduesqui un diferent",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void incorrectEmail() {
        System.err.println("Incorrect email");
        JOptionPane.showMessageDialog(null,
                "   Aquest email ja existeix \n"
                + "   Introduesqui un diferent",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void incorrectFormatEmail() {
        System.err.println("Incorrect format email");
        JOptionPane.showMessageDialog(null,
                "L'email ha de tenir el següent format: \n"
                + "            aaaa@gmail.com",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);
        }
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtEmailMousePressed

    private void lblTextRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextRegisterMouseEntered
        PanelBotoRegister.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_lblTextRegisterMouseEntered

    private void lblTextRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextRegisterMouseExited
        PanelBotoRegister.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_lblTextRegisterMouseExited

    private void lblTextCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextCancelMouseEntered
        PanelBotoCancel.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_lblTextCancelMouseEntered

    private void lblTextCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextCancelMouseExited
        PanelBotoCancel.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_lblTextCancelMouseExited

    private void PanelBotoRegisterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotoRegisterMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBotoRegisterMousePressed

    private void lblTextRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextRegisterMouseClicked
        boolean createUser = true;

        for (User u : userlist) {
            if (u.getUserName().equals(txtUsername.getText()) || u.getEmail().equals(txtEmail.getText())) {
                createUser = false;
                
                if (u.getUserName().equals(txtUsername.getText())) incorrectUsername();
                if (u.getEmail().equals(txtEmail.getText())) incorrectEmail();
                
                break;
            } else createUser = true;
        }

        if (createUser) insertUser();
    }//GEN-LAST:event_lblTextRegisterMouseClicked

    private void lblTextCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextCancelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_lblTextCancelMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

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
    private javax.swing.JPanel PanelBotoCancel;
    private javax.swing.JPanel PanelBotoRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblTextCancel;
    private javax.swing.JLabel lblTextRegister;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
