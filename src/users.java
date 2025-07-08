import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import dao.DBConnection;

public class users extends JFrame {

    private JLabel lblUserId, lblName, lblDept, lblEmail, lblPhone;
    private JLabel lblAssetId, lblAssetType, lblSerialNo;
    private JButton helpButton;

    public users(String userId) {
         setTitle("User Dashboard");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel heading = new JLabel("User & Asset Information", JLabel.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 22));
        heading.setForeground(new Color(26, 188, 156));
        mainPanel.add(heading, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(9, 2, 2, 2));

        Font fieldFont = new Font("Segoe UI", Font.BOLD, 14);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 14);

        Color fieldBg = new Color(41, 128, 185); // Blue
        Color valueBg = Color.WHITE;

        // Add rows
        tablePanel.add(createFieldLabel("User ID:", fieldFont, fieldBg));
        lblUserId = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblUserId);

        tablePanel.add(createFieldLabel("Name:", fieldFont, fieldBg));
        lblName = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblName);

        tablePanel.add(createFieldLabel("Department:", fieldFont, fieldBg));
        lblDept = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblDept);

        tablePanel.add(createFieldLabel("Email:", fieldFont, fieldBg));
        lblEmail = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblEmail);

        tablePanel.add(createFieldLabel("Phone:", fieldFont, fieldBg));
        lblPhone = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblPhone);

        tablePanel.add(createFieldLabel("Asset ID:", fieldFont, fieldBg));
        lblAssetId = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblAssetId);

        tablePanel.add(createFieldLabel("Asset Type:", fieldFont, fieldBg));
        lblAssetType = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblAssetType);

        tablePanel.add(createFieldLabel("Serial Number:", fieldFont, fieldBg));
        lblSerialNo = createValueLabel(valueFont, valueBg);
        tablePanel.add(lblSerialNo);

        // Help Button row
        tablePanel.add(createFieldLabel("Need Help?", fieldFont, fieldBg));
        helpButton = new JButton("Request Help / Maintenance");
        helpButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        helpButton.setBackground(new Color(26, 188, 156));
        helpButton.setForeground(Color.WHITE);
        helpButton.setFocusPainted(false);
        helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        helpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Redirecting to complaint/help form...");
        });
        JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnWrapper.setBackground(valueBg);
        btnWrapper.add(helpButton);
        tablePanel.add(btnWrapper);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        loadUserData(userId);
        setVisible(true);
    }

    private JLabel createFieldLabel(String text, Font font, Color bg) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    private JLabel createValueLabel(Font font, Color bg) {
        JLabel label = new JLabel();
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    private void loadUserData(String userId) {
        try {
            Connection conn = DBConnection.getConnection();

            // Fetch user details
            String userSql = "SELECT user_id, name, department, email, phone FROM user_detail WHERE user_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(userSql);
            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                lblUserId.setText(rs1.getString("user_id"));
                lblName.setText(rs1.getString("name"));
                lblDept.setText(rs1.getString("department"));
                lblEmail.setText(rs1.getString("email"));
                lblPhone.setText(rs1.getString("phone"));
            }

            // Fetch assigned asset details
            String assetSql = """
                SELECT ad.assets_id, ad.assets_type, ad.serial_no
                FROM assets_detail ad
                INNER JOIN assets_history ah ON ad.assets_id = ah.asset_id
                WHERE ah.employee_id = ? AND ah.action = 'Assigned'
                ORDER BY ah.date DESC LIMIT 1
            """;
            PreparedStatement ps2 = conn.prepareStatement(assetSql);
            ps2.setString(1, userId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                lblAssetId.setText(rs2.getString("assets_id"));
                lblAssetType.setText(rs2.getString("assets_type"));
                lblSerialNo.setText(rs2.getString("serial_no"));
            } else {
                lblAssetId.setText("No asset assigned");
                lblAssetType.setText("-");
                lblSerialNo.setText("-");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user or asset data.");
        }
    }
}
