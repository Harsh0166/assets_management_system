
import java.sql.*;
import dao.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class user extends javax.swing.JFrame {

    private String userId;

    public user(String userId) {
        initComponents();
        setLocationRelativeTo(null);

//        this.userId = userId;
        loadUserData(userId);

        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(0); // Dashboard tab
            }
        });

        btnNeedhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(1); // User Management tab
            }
        });

        btnNeedhelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tabPanel.setSelectedIndex(1);
                populateNeedHelpForm(userId); // Auto-fill when tab is opened
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnNeedhelp = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        panelDashboard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUserid = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDept = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAssetsid = new javax.swing.JLabel();
        lblAssetstype = new javax.swing.JLabel();
        lblSerialno = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtUserid = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtSerialno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComplaint = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        comboAssetsid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 144, 226));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Dashboard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users.png"))); // NOI18N
        jLabel2.setText("User");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 110, -1));

        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDashboard.setText("Dashboard");
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 220, -1));

        btnNeedhelp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNeedhelp.setText("Need Help ?");
        jPanel1.add(btnNeedhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, -1));

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, -1));

        panelDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridLayout(9, 0, 10, 10));

        jLabel4.setBackground(new java.awt.Color(78, 144, 226));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Id");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4);

        jLabel5.setBackground(new java.awt.Color(78, 144, 226));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5);

        jLabel6.setBackground(new java.awt.Color(78, 144, 226));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Department");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6);

        jLabel7.setBackground(new java.awt.Color(78, 144, 226));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel7.setOpaque(true);
        jPanel2.add(jLabel7);

        jLabel8.setBackground(new java.awt.Color(78, 144, 226));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel8.setOpaque(true);
        jPanel2.add(jLabel8);

        jLabel9.setBackground(new java.awt.Color(78, 144, 226));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Assets id");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9);

        jLabel10.setBackground(new java.awt.Color(78, 144, 226));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Assets Type");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10);

        jLabel11.setBackground(new java.awt.Color(78, 144, 226));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Assets Serial No. ");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setOpaque(true);
        jPanel2.add(jLabel11);

        panelDashboard.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 500, 500));

        jPanel3.setLayout(new java.awt.GridLayout(9, 0, 10, 10));

        lblUserid.setBackground(new java.awt.Color(255, 255, 255));
        lblUserid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUserid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblUserid.setOpaque(true);
        jPanel3.add(lblUserid);

        lblName.setBackground(new java.awt.Color(255, 255, 255));
        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblName.setOpaque(true);
        jPanel3.add(lblName);

        lblDept.setBackground(new java.awt.Color(255, 255, 255));
        lblDept.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblDept.setOpaque(true);
        jPanel3.add(lblDept);

        lblEmail.setBackground(new java.awt.Color(255, 255, 255));
        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblEmail.setOpaque(true);
        jPanel3.add(lblEmail);

        lblPhone.setBackground(new java.awt.Color(255, 255, 255));
        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPhone.setOpaque(true);
        jPanel3.add(lblPhone);

        lblAssetsid.setBackground(new java.awt.Color(255, 255, 255));
        lblAssetsid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAssetsid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblAssetsid.setOpaque(true);
        jPanel3.add(lblAssetsid);

        lblAssetstype.setBackground(new java.awt.Color(255, 255, 255));
        lblAssetstype.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAssetstype.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblAssetstype.setOpaque(true);
        jPanel3.add(lblAssetstype);

        lblSerialno.setBackground(new java.awt.Color(255, 255, 255));
        lblSerialno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSerialno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblSerialno.setOpaque(true);
        jPanel3.add(lblSerialno);

        panelDashboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 550, 500));

        tabPanel.addTab("Dashboard", panelDashboard);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("User Id");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Assets Id");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Assets Type");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Assets Serial No.");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Complaint");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        txtUserid.setEditable(false);
        txtUserid.setBackground(new java.awt.Color(255, 255, 255));
        txtUserid.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtUserid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtType.setEditable(false);
        txtType.setBackground(new java.awt.Color(255, 255, 255));
        txtType.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtSerialno.setEditable(false);
        txtSerialno.setBackground(new java.awt.Color(255, 255, 255));
        txtSerialno.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtSerialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txtComplaint.setColumns(20);
        txtComplaint.setRows(5);
        txtComplaint.setPreferredSize(new java.awt.Dimension(550, 40));
        jScrollPane1.setViewportView(txtComplaint);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 550, -1));

        btnSubmit.setBackground(new java.awt.Color(0, 204, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel4.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, -1, -1));

        comboAssetsid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAssetsid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAssetsid.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(comboAssetsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        tabPanel.addTab("Need Help ?", jPanel4);

        getContentPane().add(tabPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1110, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(
                user.this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Close user window
            new Login().setVisible(true); // Open login window
        }


    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        String userId = txtUserid.getText();
        String assetId = comboAssetsid.getSelectedItem().toString();
        String assetType = txtType.getText();
        String serialNo = txtSerialno.getText();
        String complaint = txtComplaint.getText();

        if (userId.isEmpty() || assetId.isEmpty() || complaint.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO asset_complaints (user_id, asset_id, asset_type, serial_no, complaint) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, assetId);
            ps.setString(3, assetType);
            ps.setString(4, serialNo);
            ps.setString(5, complaint);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Complaint submitted successfully!");
//                txtComplaint.setText(""); // clear complaint field
            } else {
                JOptionPane.showMessageDialog(null, "Submission failed. Try again.");
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void loadUserData(String userId) {
        try {
            Connection conn = DBConnection.getConnection();

            // Fetch user details
            String userSql = "SELECT user_id, name, department, email, phone FROM user_detail WHERE user_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(userSql);
            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                lblUserid.setText(rs1.getString("user_id"));
                lblName.setText(rs1.getString("name"));
                lblDept.setText(rs1.getString("department"));
                lblEmail.setText(rs1.getString("email"));
                lblPhone.setText(rs1.getString("phone"));
            }

            // Fetch assigned asset details
            String assetSql = """
                SELECT ad.assets_id, ad.assets_type, ad.serial_no
                FROM assets_detail ad
                INNER JOIN assets_history ah ON ad.assets_id = ah.assets_id
                WHERE ah.user_id = ? AND ah.action = 'Assigned'
                ORDER BY ah.date DESC LIMIT 1
            """;
            PreparedStatement ps2 = conn.prepareStatement(assetSql);
            ps2.setString(1, userId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                lblAssetsid.setText(rs2.getString("assets_id"));
                lblAssetstype.setText(rs2.getString("assets_type"));
                lblSerialno.setText(rs2.getString("serial_no"));
            } else {
                lblAssetsid.setText("No asset assigned");
                lblAssetstype.setText("-");
                lblSerialno.setText("-");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user or asset data.");
        }
    }

    public void populateNeedHelpForm(String userId) {
    try {
        Connection conn = DBConnection.getConnection();

        txtUserid.setText(userId);

        // Clear combo box before adding
        comboAssetsid.removeAllItems();

        // Map to store asset info based on asset_id
        Map<String, String[]> assetInfoMap = new HashMap<>();

        String sql = """
            SELECT ad.assets_id, ad.assets_type, ad.serial_no
            FROM assets_detail ad
            JOIN assets_history ah ON ad.assets_id = ah.assets_id
            WHERE ah.user_id = ? AND ah.action = 'Assigned'
            ORDER BY ah.date DESC
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String assetId = rs.getString("assets_id");
            String type = rs.getString("assets_type");
            String serial = rs.getString("serial_no");

            comboAssetsid.addItem(assetId);
            assetInfoMap.put(assetId, new String[]{type, serial});
        }

        conn.close();

        // Add selection listener
        comboAssetsid.addActionListener(e -> {
            String selectedId = (String) comboAssetsid.getSelectedItem();
            if (selectedId != null && assetInfoMap.containsKey(selectedId)) {
                String[] info = assetInfoMap.get(selectedId);
                txtType.setText(info[0]);
                txtSerialno.setText(info[1]);
            }
        });

        // Trigger default selection
        if (comboAssetsid.getItemCount() > 0) {
            comboAssetsid.setSelectedIndex(0);
        } else {
            txtType.setText("-");
            txtSerialno.setText("-");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}

    

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new user().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNeedhelp;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboAssetsid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssetsid;
    private javax.swing.JLabel lblAssetstype;
    private javax.swing.JLabel lblDept;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSerialno;
    private javax.swing.JLabel lblUserid;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextArea txtComplaint;
    private javax.swing.JTextField txtSerialno;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUserid;
    // End of variables declaration//GEN-END:variables
}
