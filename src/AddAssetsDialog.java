
import javax.swing.JOptionPane;
import dao.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddAssetsDialog extends javax.swing.JDialog {

    public AddAssetsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        comboboxAction.addActionListener(e -> {
            String action = comboboxAction.getSelectedItem().toString();
            if (action.equalsIgnoreCase("Unassigned")) {
                txtCurrentowner.setText("");  // clear field
                txtCurrentowner.setEnabled(false); // disable field
            } else {
                txtCurrentowner.setEnabled(true); // enable if not unassigned
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDelete();
            }
        });

        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
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
        btnSave = new javax.swing.JButton();
        comboboxAssetstype = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        comboboxAction = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Add Assets");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 30));
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

        comboboxAssetstype.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAssetstype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Phone", "Software", "Printer" }));
        comboboxAssetstype.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(comboboxAssetstype, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, -1));

        btnDelete.setBackground(new java.awt.Color(255, 102, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(86, 32));
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 90, 34));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        comboboxAction.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assigned", "Unassigned", "Maintenance", "Retired" }));
        comboboxAction.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(comboboxAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 550, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, Short.MAX_VALUE)
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

        if (serial_no.isEmpty() || purchase_date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "all fields are required");
            return;
        }
        // Only check current owner if action is not "Unassigned"
        if (!action.equalsIgnoreCase("Unassigned") && current_owner.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Current Owner is required for this action.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO assets_detail (assets_type, serial_no, purchase_date, action , current_owner , description) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, assets_type);
            pst.setString(2, serial_no);
            pst.setString(3, purchase_date);
            pst.setString(4, action);
            pst.setString(5, current_owner);
            pst.setString(6, description);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                if (action.equalsIgnoreCase("Assigned") || action.equalsIgnoreCase("Maintenance") || action.equalsIgnoreCase("Retired")) {
                    // Get the newly inserted asset ID (auto-increment)
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int insertedAssetId = generatedKeys.getInt(1);

                        // Insert into history
                        String historySql = "INSERT INTO assets_history (assets_id, user_id, action, date, note) VALUES (?, ?, ?, NOW(), ?)";
                        PreparedStatement historyPs = conn.prepareStatement(historySql);
                        historyPs.setInt(1, insertedAssetId);
                        historyPs.setInt(2, Integer.parseInt(current_owner));  // assuming current_owner is user_id
                        historyPs.setString(3, action);
                        historyPs.setString(4, "Asset assigned during creation");
                        historyPs.executeUpdate();
                    }
                }

                JOptionPane.showMessageDialog(this, "Assets added successfully!");
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed
    int assets_id = 0;
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String type = comboboxAssetstype.getSelectedItem().toString();
        String serial = txtSerialno.getText();
        String purchase = txtPurchasedate.getText();
        String action = comboboxAction.getSelectedItem().toString();
        String owner = txtCurrentowner.getText();
        String desc = txtDescription.getText();

        if (assets_id == 0) {
            JOptionPane.showMessageDialog(this, "No asset selected for update.");
            return;
        }

        if (type.isEmpty() || serial.isEmpty() || purchase.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields.");
            return;
        }

        if ((action.equalsIgnoreCase("Assigned") || action.equalsIgnoreCase("Maintenance") || action.equalsIgnoreCase("Retired")) && owner.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Current owner is required for selected action.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE assets_detail SET assets_type=?, serial_no=?, purchase_date=?, action=?, current_owner=?, description=? WHERE assets_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, serial);
            ps.setString(3, purchase);
            ps.setString(4, action);
            ps.setString(5, owner);
            ps.setString(6, desc);
            ps.setInt(7, assets_id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                // Insert history record after successful update
                if (action.equalsIgnoreCase("Assigned") || action.equalsIgnoreCase("Maintenance") || action.equalsIgnoreCase("Retired")) {
                    String historySql = "INSERT INTO assets_history (assets_id, user_id, action, date, note) VALUES (?, ?, ?, NOW(), ?)";
                    PreparedStatement historyPs = conn.prepareStatement(historySql);
                    historyPs.setInt(1, assets_id); // make sure you have asset_id accessible here
                    historyPs.setInt(2, Integer.parseInt(owner));
                    historyPs.setString(3, action);
                    historyPs.setString(4, "Asset updated and assigned");
                    historyPs.executeUpdate();
                }

                JOptionPane.showMessageDialog(this, "Asset updated successfully!");
                this.dispose(); // Close the dialog
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    public void loadAssetsData(int assets_id, String assets_type, String serial_no, String purchase_date,
            String action, String current_owner, String description) {
        this.assets_id = assets_id;
        comboboxAssetstype.setSelectedItem(assets_type);
        txtSerialno.setText(serial_no);
        txtPurchasedate.setText(purchase_date);
        comboboxAction.setSelectedItem(action);
        txtCurrentowner.setText(current_owner);
        txtDescription.setText(description);

        lblTitle.setText("Update Assets");
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);

    }

    private void btnDelete() {
        if (assets_id == 0) {
            JOptionPane.showMessageDialog(this, "No asset selected for deletion.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this asset?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM assets_detail WHERE assets_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, assets_id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Asset deleted successfully!");
                this.dispose(); // Close the dialog
            } else {
                JOptionPane.showMessageDialog(this, "Asset not found or could not be deleted.");
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting asset: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboboxAction;
    private javax.swing.JComboBox<String> comboboxAssetstype;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAction;
    private javax.swing.JLabel lblAssetstype;
    private javax.swing.JLabel lblCurrentowner;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblPurchasedatr;
    private javax.swing.JLabel lblSerialno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCurrentowner;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPurchasedate;
    private javax.swing.JTextField txtSerialno;
    // End of variables declaration//GEN-END:variables
}
