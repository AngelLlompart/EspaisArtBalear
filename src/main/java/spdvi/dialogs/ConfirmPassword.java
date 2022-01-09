/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi.dialogs;

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
import spdvi.helpers.DataAccess;

/**
 *
 * @author Joan Andreu
 */
public class ConfirmPassword extends javax.swing.JDialog {

    private String email;
    private String codi;
    int xMouse, yMouse;

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
        lblConfirmContrasenya = new javax.swing.JLabel();
        lblContrasenya = new javax.swing.JLabel();
        txtConfirmContrasenya = new javax.swing.JPasswordField();
        txtCodi = new javax.swing.JTextField();
        txtContrasenya = new javax.swing.JPasswordField();
        SeparatorCodi = new javax.swing.JSeparator();
        SeparatorContrasenya = new javax.swing.JSeparator();
        SeparatorConfirmContrasenya = new javax.swing.JSeparator();
        PanelBoto = new javax.swing.JPanel();
        lblText = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodi.setBackground(new java.awt.Color(0, 0, 0));
        lblCodi.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblCodi.setForeground(new java.awt.Color(0, 0, 0));
        lblCodi.setText("Introdueix codi:");
        lblCodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCodiMouseExited(evt);
            }
        });
        jPanel1.add(lblCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblConfirmContrasenya.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblConfirmContrasenya.setForeground(new java.awt.Color(0, 0, 0));
        lblConfirmContrasenya.setText("Confirma la contrasenya:");
        lblConfirmContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConfirmContrasenyaMouseExited(evt);
            }
        });
        jPanel1.add(lblConfirmContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblContrasenya.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblContrasenya.setForeground(new java.awt.Color(0, 0, 0));
        lblContrasenya.setText("Introdueix nova contrasenya:");
        lblContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblContrasenyaMouseExited(evt);
            }
        });
        jPanel1.add(lblContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtConfirmContrasenya.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirmContrasenya.setText("********");
        txtConfirmContrasenya.setBorder(null);
        txtConfirmContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtConfirmContrasenyaMousePressed(evt);
            }
        });
        txtConfirmContrasenya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmContrasenyaActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 190, -1));

        txtCodi.setBackground(new java.awt.Color(255, 255, 255));
        txtCodi.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txtCodi.setForeground(new java.awt.Color(204, 204, 204));
        txtCodi.setText("Ingresi codi");
        txtCodi.setBorder(null);
        txtCodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCodiMousePressed(evt);
            }
        });
        txtCodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodiActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, -1));

        txtContrasenya.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenya.setText("********");
        txtContrasenya.setBorder(null);
        txtContrasenya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContrasenyaMousePressed(evt);
            }
        });
        jPanel1.add(txtContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));
        jPanel1.add(SeparatorCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 250, 10));
        jPanel1.add(SeparatorContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, -1));
        jPanel1.add(SeparatorConfirmContrasenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 250, 10));

        PanelBoto.setBackground(new java.awt.Color(0, 134, 190));

        lblText.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        lblText.setForeground(new java.awt.Color(255, 255, 255));
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("Confirmar Codi");
        lblText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelBotoLayout = new javax.swing.GroupLayout(PanelBoto);
        PanelBoto.setLayout(PanelBotoLayout);
        PanelBotoLayout.setHorizontalGroup(
            PanelBotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelBotoLayout.setVerticalGroup(
            PanelBotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelBoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 120, 30));

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 470, 30));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(0, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 5, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtConfirmContrasenyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmContrasenyaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmContrasenyaActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void lblTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseEntered
        PanelBoto.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_lblTextMouseEntered

    private void lblTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseExited
        PanelBoto.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_lblTextMouseExited

    private void txtCodiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodiMousePressed
        if (txtCodi.getText().equals("Ingresi codi")) {
            txtCodi.setText("");
            txtCodi.setForeground(Color.black);
        }
        if (String.valueOf(txtContrasenya.getPassword()).isEmpty()) {
            txtContrasenya.setText("********");
            txtContrasenya.setForeground(Color.gray);
        }
        if (String.valueOf(txtConfirmContrasenya.getPassword()).isEmpty()) {
            txtConfirmContrasenya.setText("********");
            txtConfirmContrasenya.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCodiMousePressed

    private void txtContrasenyaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContrasenyaMousePressed
        if (String.valueOf(txtContrasenya.getPassword()).equals("********")) {
            txtContrasenya.setText("");
            txtContrasenya.setForeground(Color.black);
        }
        if (txtCodi.getText().isEmpty()) {
            txtCodi.setText("Ingresi codi");
            txtCodi.setForeground(Color.gray);
        }
        if (String.valueOf(txtConfirmContrasenya.getPassword()).isEmpty()) {
            txtConfirmContrasenya.setText("********");
            txtConfirmContrasenya.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtContrasenyaMousePressed

    private void lblTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseClicked
        String password = new String(txtContrasenya.getPassword());

        Pattern passwordRegEx = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");

        if (codi.equals(txtCodi.getText())) {
            if (txtCodi.getText() == "") {
                JOptionPane.showMessageDialog(null, "El codi introduit no es correcte");
            }
            if (passwordRegEx.matcher(password).matches()) {
                DataAccess da = new DataAccess();
                ArrayList<User> users = da.getUsers();

                if (!new String(txtContrasenya.getPassword()).equals(new String(txtConfirmContrasenya.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "La contrasenya no coincideix");
                } else {
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
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contrasenya no cumpleix els minims requerits: "
                        + "\n"
                        + "Al menys 8 caracters\n"
                        + "\n"
                        + "Conte al menys un dígit\n"
                        + "\n"
                        + "Conte una Minuscula i una Mayuscula\n"
                        + "\n"
                        + "No conte espais, tabulacións, etc.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El codi introduit es incorrecte");
        }
    }//GEN-LAST:event_lblTextMouseClicked

    private void txtConfirmContrasenyaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirmContrasenyaMousePressed
        if (String.valueOf(txtConfirmContrasenya.getPassword()).equals("********")) {
            txtConfirmContrasenya.setText("");
            txtConfirmContrasenya.setForeground(Color.black);
        }
        if (txtCodi.getText().isEmpty()) {
            txtCodi.setText("Ingresi codi");
            txtCodi.setForeground(Color.gray);
        }
        if (String.valueOf(txtContrasenya.getPassword()).isEmpty()) {
            txtContrasenya.setText("********");
            txtContrasenya.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtConfirmContrasenyaMousePressed

    private void txtCodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodiActionPerformed

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
    private javax.swing.JPanel Header;
    private javax.swing.JPanel PanelBoto;
    private javax.swing.JSeparator SeparatorCodi;
    private javax.swing.JSeparator SeparatorConfirmContrasenya;
    private javax.swing.JSeparator SeparatorContrasenya;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodi;
    private javax.swing.JLabel lblConfirmContrasenya;
    private javax.swing.JLabel lblContrasenya;
    private javax.swing.JLabel lblText;
    private javax.swing.JTextField txtCodi;
    private javax.swing.JPasswordField txtConfirmContrasenya;
    private javax.swing.JPasswordField txtContrasenya;
    // End of variables declaration//GEN-END:variables

}
