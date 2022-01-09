/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.dialogs;

import spdvi.dialogs.Register;
import spdvi.helpers.DataAccess;
import spdvi.pojos.User;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import spdvi.dialogs.ForgotPassword;

/**
 *
 * @author angel
 */
public class Login extends javax.swing.JDialog {
   private User loginUser;
    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        
        Font font = lblForgotPassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblForgotPassword.setFont(font.deriveFont(attributes));
        
        Font font2 = lblRegistre.getFont();
        Map attributes2 = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblRegistre.setFont(font.deriveFont(attributes));
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
        jPanel1 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblUserName = new javax.swing.JLabel();
        lblForgotPassword = new javax.swing.JLabel();
        lblRegistre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        PanelBoto = new javax.swing.JPanel();
        lblText = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setBackground(new java.awt.Color(255, 255, 255));
        txtUserName.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setText("Ingresi usuari");
        txtUserName.setToolTipText("");
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserNameMousePressed(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 160, -1));

        lblPassword.setBackground(new java.awt.Color(255, 255, 255));
        lblPassword.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblPassword.setText("Password:");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setToolTipText("");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, -1));

        lblUserName.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 0, 0));
        lblUserName.setText("Username:");
        jPanel1.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        lblForgotPassword.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblForgotPassword.setForeground(new java.awt.Color(0, 0, 255));
        lblForgotPassword.setText("Forgot Password?");
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseExited(evt);
            }
        });
        jPanel1.add(lblForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        lblRegistre.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblRegistre.setForeground(new java.awt.Color(0, 0, 255));
        lblRegistre.setText("Not registred yet?");
        lblRegistre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegistreMouseMoved(evt);
            }
        });
        lblRegistre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblRegistreFocusGained(evt);
            }
        });
        lblRegistre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegistreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegistreMouseExited(evt);
            }
        });
        jPanel1.add(lblRegistre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, 20));

        PanelBoto.setBackground(new java.awt.Color(0, 134, 190));

        lblText.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        lblText.setForeground(new java.awt.Color(255, 255, 255));
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("LOGIN");
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
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(PanelBotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBotoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblText)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelBotoLayout.setVerticalGroup(
            PanelBotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(PanelBotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBotoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblText)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(PanelBoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void lblRegistreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblRegistreFocusGained

    }//GEN-LAST:event_lblRegistreFocusGained

    private void lblRegistreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistreMouseMoved
        //lblRegistre.setForeground(Color.cyan);
    }//GEN-LAST:event_lblRegistreMouseMoved

    private void lblRegistreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistreMouseEntered
        lblRegistre.setForeground(Color.cyan);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblRegistreMouseEntered

    private void lblRegistreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistreMouseExited
        lblRegistre.setForeground(Color.blue);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblRegistreMouseExited

    private void lblForgotPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseEntered
        lblForgotPassword.setForeground(Color.cyan);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblForgotPasswordMouseEntered

    private void lblForgotPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseExited
        lblForgotPassword.setForeground(Color.blue);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblForgotPasswordMouseExited

    private void lblRegistreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistreMouseClicked
        Register r = new Register((Frame) this.getParent(), true);
        r.setVisible(true);
    }//GEN-LAST:event_lblRegistreMouseClicked

    private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseClicked
        ForgotPassword fP = new ForgotPassword((Frame) this.getParent(), true);
        fP.setVisible(true);
    }//GEN-LAST:event_lblForgotPasswordMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(1);
    }//GEN-LAST:event_formWindowClosing

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        enterKey(evt);
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
    }//GEN-LAST:event_formKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        enterKey(evt);
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void lblTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseEntered
        PanelBoto.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_lblTextMouseEntered

    private void lblTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseExited
        PanelBoto.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_lblTextMouseExited

    private void lblTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseClicked
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DataAccess da = new DataAccess();
        ArrayList<User> users = da.getUsers();
        boolean userExists = false;
        String encriptMD5 = DigestUtils.md5Hex(new String (txtPassword.getPassword()));
        for(User u: users){
            if(u.getUserName().equals(txtUserName.getText())){
                userExists = true;
                if(u.getPassword().equals(encriptMD5)){
                    loginUser = u;
                    setVisible(false);
                }else{
                    System.err.println("Incorrect password");
                    JOptionPane.showMessageDialog(null,
                    "Incorrect password",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(!userExists){
            System.err.println("This user does not exist");
            JOptionPane.showMessageDialog(null,
            "This user does not exist",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_lblTextMouseClicked

    private void txtUserNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMousePressed
        if (txtUserName.getText().equals("Ingresi usuari")) {
            txtUserName.setText("");
            txtUserName.setForeground(Color.black);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUserNameMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if (txtUserName.getText().isEmpty()) {
            txtUserName.setText("Ingresi usuari");
            txtUserName.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void enterKey(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
        }
    }
    
    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelBoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegistre;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
