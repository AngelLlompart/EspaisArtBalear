/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

        lblCodi = new javax.swing.JLabel();
        txtCodi = new javax.swing.JTextField();
        lblContrasenya = new javax.swing.JLabel();
        lblConfirmContrasenya = new javax.swing.JLabel();
        btnCodi = new javax.swing.JButton();
        txtContrasenya = new javax.swing.JPasswordField();
        txtConfirmContrasenya = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCodi.setText("Introdueix codi:");

        lblContrasenya.setText("Introdueix nova contrasenya:");

        lblConfirmContrasenya.setText("Confirma la contrasenya:");

        btnCodi.setText("Cofirmar Codi");
        btnCodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtConfirmContrasenya, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasenya, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblConfirmContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblContrasenya, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addComponent(btnCodi)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContrasenya)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblConfirmContrasenya)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                u.setPassword(new String(txtContrasenya.getPassword()));
            }
        }
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
    private javax.swing.JLabel lblCodi;
    private javax.swing.JLabel lblConfirmContrasenya;
    private javax.swing.JLabel lblContrasenya;
    private javax.swing.JTextField txtCodi;
    private javax.swing.JPasswordField txtConfirmContrasenya;
    private javax.swing.JPasswordField txtContrasenya;
    // End of variables declaration//GEN-END:variables
}
