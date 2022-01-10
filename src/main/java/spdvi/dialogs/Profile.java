/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import javax.swing.JLabel;
import spdvi.helpers.DataAccess;
import spdvi.pojos.User;

/**
 *
 * @author lawde
 */
public class Profile extends javax.swing.JDialog {

    private User currentUser;
    private boolean deleted = false;
    /**
     * Creates new form Profile
     */
    public Profile(java.awt.Frame parent, boolean modal) {
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
        lblEmailTitle = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsernameTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        lblDelete = new javax.swing.JLabel();
        btnChangeUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmailTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblEmailTitle.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblEmailTitle.setText("Email: ");
        jPanel1.add(lblEmailTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblEmail.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblEmail.setText("email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        lblUsernameTitle.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblUsernameTitle.setText("Username: ");
        jPanel1.add(lblUsernameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lblUsername.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblUsername.setText("username");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        btnChangePassword.setBackground(new java.awt.Color(0, 134, 190));
        btnChangePassword.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("Change Password");
        btnChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangePasswordMouseExited(evt);
            }
        });
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 260, 30));

        lblDelete.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblDelete.setForeground(new java.awt.Color(255, 0, 0));
        lblDelete.setText("Delete User");
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeleteMouseExited(evt);
            }
        });
        jPanel1.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 90, 30));

        btnChangeUser.setBackground(new java.awt.Color(0, 134, 190));
        btnChangeUser.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnChangeUser.setForeground(new java.awt.Color(255, 255, 255));
        btnChangeUser.setText("Change User");
        btnChangeUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangeUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeUserMouseExited(evt);
            }
        });
        btnChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        UpdatePassword updatePassword = new UpdatePassword((Frame) this.getParent(), true);
        updatePassword.setCurrentUser(currentUser);
        updatePassword.setVisible(true);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void lblDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseEntered
        lblDelete.setForeground(Color.magenta);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblDeleteMouseEntered

    private void lblDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseExited
        lblDelete.setForeground(Color.red);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblDeleteMouseExited

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
        ConfirmDelete confirmDelete = new ConfirmDelete((Frame) this.getParent(), true);
        confirmDelete.setVisible(true);
        if(confirmDelete.isConfirm()){
            DataAccess da = new DataAccess();
            da.deleteUser(currentUser);
            deleted = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void btnChangePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePasswordMouseEntered
        btnChangePassword.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnChangePasswordMouseEntered

    private void btnChangePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePasswordMouseExited
        btnChangePassword.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnChangePasswordMouseExited

    private void btnChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeUserActionPerformed
        UpdateUsername updateUsername = new UpdateUsername((Frame) this.getParent(), true);
        updateUsername.setCurrentUser(currentUser);
        updateUsername.getLblOldUsername().setText(currentUser.getUserName());
        updateUsername.setVisible(true);
        if(updateUsername.isChanged()){
            lblUsername.setText(currentUser.getUserName());
        }
    }//GEN-LAST:event_btnChangeUserActionPerformed

    private void btnChangeUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeUserMouseEntered
        btnChangeUser.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnChangeUserMouseEntered

    private void btnChangeUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeUserMouseExited
        btnChangeUser.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnChangeUserMouseExited

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public JLabel getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(JLabel lblUsername) {
        this.lblUsername = lblUsername;
    }

    public boolean isDeleted() {
        return deleted;
    }

    
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Profile dialog = new Profile(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangeUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameTitle;
    // End of variables declaration//GEN-END:variables
}
