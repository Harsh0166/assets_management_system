
import java.sql.*;
import dao.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class user extends javax.swing.JFrame {


    public user(String userId) {
        initComponents();
        setLocationRelativeTo(null);

        pnlUserInfo.setLayout(new GridBagLayout());
        pnlAssets.setLayout(new GridBagLayout());

        createDynamicPanels();      
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
                populateNeedHelpForm(userId);
            }
        });

    }

    private void createDynamicPanels() {
        pnlUserInfo = new JPanel(new GridBagLayout());
        pnlAssets = new JPanel(new GridBagLayout());

        pnlUserInfo.setBackground(new Color(245, 245, 245));
        pnlAssets.setBackground(new Color(245, 245, 245));

        pnlUserInfo.setBorder(new EmptyBorder(20, 20, 10, 20)); 
        pnlAssets.setBorder(new EmptyBorder(10, 20, 20, 20));   

        
        JPanel verticalContainer = new JPanel();
        verticalContainer.setLayout(new BoxLayout(verticalContainer, BoxLayout.Y_AXIS));
        verticalContainer.setBackground(new Color(245, 245, 245));
        verticalContainer.add(pnlUserInfo);
        verticalContainer.add(pnlAssets);

        
        JScrollPane scrollPane = new JScrollPane(verticalContainer);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        
        panelDashboard.removeAll();
        panelDashboard.setLayout(new BorderLayout());
        panelDashboard.add(scrollPane, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        panelDashboard = new javax.swing.JPanel();
        pnlUserInfo = new javax.swing.JPanel();
        pnlAssets = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnNeedhelp = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnlUserInfoLayout = new javax.swing.GroupLayout(pnlUserInfo);
        pnlUserInfo.setLayout(pnlUserInfoLayout);
        pnlUserInfoLayout.setHorizontalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        pnlUserInfoLayout.setVerticalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        panelDashboard.add(pnlUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 130));

        javax.swing.GroupLayout pnlAssetsLayout = new javax.swing.GroupLayout(pnlAssets);
        pnlAssets.setLayout(pnlAssetsLayout);
        pnlAssetsLayout.setHorizontalGroup(
            pnlAssetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        pnlAssetsLayout.setVerticalGroup(
            pnlAssetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        panelDashboard.add(pnlAssets, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 530, 130));

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
        txtUserid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserid.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtUserid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtType.setEditable(false);
        txtType.setBackground(new java.awt.Color(255, 255, 255));
        txtType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtType.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtSerialno.setEditable(false);
        txtSerialno.setBackground(new java.awt.Color(255, 255, 255));
        txtSerialno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSerialno.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel4.add(txtSerialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txtComplaint.setColumns(20);
        txtComplaint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtComplaint.setRows(5);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                user.this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); 
            new Login().setVisible(true); 
        }


    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

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
            } else {
                JOptionPane.showMessageDialog(null, "Submission failed. Try again.");
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private JLabel createFieldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setOpaque(true);
        label.setBackground(new Color(41, 128, 185));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    private JLabel createValueLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    private void loadUserData(String userId) {
        try {
            Connection conn = DBConnection.getConnection();

            String userSql = "SELECT user_id, name, department, email, phone FROM user_detail WHERE user_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(userSql);
            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            int userRow = 0;

            if (rs1.next()) {
                userRow = addUserRow("User ID", rs1.getString("user_id"), pnlUserInfo, userRow);
                userRow = addUserRow("Name", rs1.getString("name"), pnlUserInfo, userRow);
                userRow = addUserRow("Department", rs1.getString("department"), pnlUserInfo, userRow);
                userRow = addUserRow("Email", rs1.getString("email"), pnlUserInfo, userRow);
                userRow = addUserRow("Phone", rs1.getString("phone"), pnlUserInfo, userRow);
            }

            String assetSql = """
                SELECT ad.assets_id, ad.assets_type, ad.serial_no
                FROM assets_detail ad
                INNER JOIN assets_history ah ON ad.assets_id = ah.assets_id
                WHERE ah.user_id = ? AND ah.action = 'Assigned'
                ORDER BY ah.date DESC
            """;
            PreparedStatement ps2 = conn.prepareStatement(assetSql);
            ps2.setString(1, userId);
            ResultSet rs2 = ps2.executeQuery();

            int assetRow = 0;
            int assetCount = 0;

            while (rs2.next()) {
                assetCount++;
                assetRow = addUserRow("Asset ID " + assetCount, rs2.getString("assets_id"), pnlAssets, assetRow);
                assetRow = addUserRow("Asset Type " + assetCount, rs2.getString("assets_type"), pnlAssets, assetRow);
                assetRow = addUserRow("Serial No " + assetCount, rs2.getString("serial_no"), pnlAssets, assetRow);
            }

            if (assetCount == 0) {
                assetRow = addUserRow("No Asset Assigned", "-", pnlAssets, assetRow);
            }

            conn.close();
            pnlUserInfo.revalidate();
            pnlUserInfo.repaint();
            pnlAssets.revalidate();
            pnlAssets.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user or asset data.");
        }
    }

    private int addUserRow(String label, String value, JPanel parentPanel, int row) {
        JPanel rowPanel = new JPanel(new GridLayout(1, 2));
        rowPanel.setOpaque(false);

        JLabel lblField = new JLabel(label);
        lblField.setOpaque(true);
        lblField.setBackground(new Color(41, 128, 185));
        lblField.setForeground(Color.WHITE);
        lblField.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblValue = new JLabel(value);
        lblValue.setOpaque(true);
        lblValue.setBackground(Color.WHITE);
        lblValue.setForeground(Color.BLACK);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblValue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        rowPanel.add(lblField);
        rowPanel.add(lblValue);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(4, 4, 4, 4);

        parentPanel.add(rowPanel, gbc);

        return row + 1;
    }

    public void populateNeedHelpForm(String userId) {
        comboAssetsid.setBackground(Color.WHITE);
        try {
            Connection conn = DBConnection.getConnection();

            txtUserid.setText(userId);
            comboAssetsid.removeAllItems();
            
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

            comboAssetsid.addActionListener(e -> {
                String selectedId = (String) comboAssetsid.getSelectedItem();
                if (selectedId != null && assetInfoMap.containsKey(selectedId)) {
                    String[] info = assetInfoMap.get(selectedId);
                    txtType.setText(info[0]);
                    txtSerialno.setText(info[1]);
                }
            });

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

//public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(() -> {
//            new user("13").setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNeedhelp;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboAssetsid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel pnlAssets;
    private javax.swing.JPanel pnlUserInfo;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextArea txtComplaint;
    private javax.swing.JTextField txtSerialno;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUserid;
    // End of variables declaration//GEN-END:variables
}
