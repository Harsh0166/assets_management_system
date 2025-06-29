
import javax.swing.JOptionPane;
import dao.DBConnection;
import java.sql.*;

public class AddAssetsDialog extends javax.swing.JDialog {

    public AddAssetsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblAssetstype = new javax.swing.JLabel();
        lblSerialno = new javax.swing.JLabel();
        lblPurchasedatr = new javax.swing.JLabel();
        lblAction = new javax.swing.JLabel();
        lblCurrentowner = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtSerialno = new javax.swing.JTextField();
        txtPurchasedate = new javax.swing.JTextField();
        txtCurrentowner = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        comboboxAssetstype = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        comboboxAction = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Add Assets");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 890, 10));

        lblAssetstype.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAssetstype.setText("Assets Type");
        jPanel1.add(lblAssetstype, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblSerialno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSerialno.setText("Serial No.");
        jPanel1.add(lblSerialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lblPurchasedatr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPurchasedatr.setText("Purchase Date");
        jPanel1.add(lblPurchasedatr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lblAction.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAction.setText("Action");
        jPanel1.add(lblAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        lblCurrentowner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCurrentowner.setText("Current Owner");
        jPanel1.add(lblCurrentowner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        lblDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescription.setText("Description");
        jPanel1.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        txtSerialno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSerialno.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(txtSerialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtPurchasedate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPurchasedate.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(txtPurchasedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        txtCurrentowner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCurrentowner.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(txtCurrentowner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        comboboxAssetstype.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAssetstype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Phone", "Software", "Printer" }));
        comboboxAssetstype.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(comboboxAssetstype, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, -1));

        btnSave.setBackground(new java.awt.Color(51, 204, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, -1, -1));

        comboboxAction.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assigned", "Unassigned", "Maintenance", "Retired" }));
        comboboxAction.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(comboboxAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 550, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String assets_type = comboboxAssetstype.getSelectedItem().toString();
        String serial_no = txtSerialno.getText();
        String purchase_date = txtPurchasedate.getText();
        String action = comboboxAction.getSelectedItem().toString();
        String current_owner = txtCurrentowner.getText();
        String description = txtDescription.getText();
        
        if(serial_no.isEmpty() || purchase_date.isEmpty() ){
            JOptionPane.showMessageDialog(this, "all fields are required");
            return;
        }
        
        try{
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO assets_detail (assets_type, serial_no, purchase_date, action , current_owner , description) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,assets_type);
            pst.setString(2,serial_no);
            pst.setString(3,purchase_date);
            pst.setString(4,action);
            pst.setString(5,current_owner);
            pst.setString(6,description);
            
            int row = pst.executeUpdate();
            
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Assets added successfully!");
                this.dispose(); // close the dialog
               }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

   
    
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
            java.util.logging.Logger.getLogger(AddAssetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAssetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAssetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAssetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAssetsDialog dialog = new AddAssetsDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboboxAction;
    private javax.swing.JComboBox<String> comboboxAssetstype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAction;
    private javax.swing.JLabel lblAssetstype;
    private javax.swing.JLabel lblCurrentowner;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblPurchasedatr;
    private javax.swing.JLabel lblSerialno;
    private javax.swing.JTextField txtCurrentowner;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPurchasedate;
    private javax.swing.JTextField txtSerialno;
    // End of variables declaration//GEN-END:variables
}
