
import javax.swing.JOptionPane;
import dao.DBConnection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.BorderFactory;

public class AddUserDialog extends javax.swing.JDialog {

    public AddUserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);

        btnSave.setBackground(new Color(0, 204, 0));
        btnSave.setForeground(Color.WHITE);
        btnSave.setContentAreaFilled(false);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(false);
        btnSave.setFocusPainted(false);

        btnUpdate.setBackground(new Color(0, 51, 204));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setOpaque(true);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setFocusPainted(false);

        btnDelete.setBackground(new Color(255, 102, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setOpaque(true);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);

        btnCancel.setBackground(new Color(255, 0, 0));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);

        Font commonFont = new Font("Segoe UI", Font.PLAIN, 14);
        Dimension fieldSize = new Dimension(300, 30); 


        txtName.setFont(commonFont);
        txtName.setPreferredSize(fieldSize);
        txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        txtDept.setFont(commonFont);
        txtDept.setPreferredSize(fieldSize);
        txtDept.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        txtEmail.setFont(commonFont);
        txtEmail.setPreferredSize(fieldSize);
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        txtPhone.setFont(commonFont);
        txtPhone.setPreferredSize(fieldSize);
        txtPhone.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        txtPassword.setFont(commonFont);
        txtPassword.setPreferredSize(fieldSize);
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        comboBoxStatus.setFont(commonFont);
        comboBoxStatus.setPreferredSize(fieldSize);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblDept = new javax.swing.JLabel();
        txtDept = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 439));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Add User");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 10, 104, 32);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 600, 10);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setText("Name");
        jPanel1.add(lblName);
        lblName.setBounds(20, 60, 50, 25);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtName);
        txtName.setBounds(20, 90, 550, 40);

        lblDept.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDept.setText("Department");
        jPanel1.add(lblDept);
        lblDept.setBounds(20, 140, 110, 25);

        txtDept.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDept);
        txtDept.setBounds(20, 170, 550, 40);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email");
        jPanel1.add(lblEmail);
        lblEmail.setBounds(20, 220, 50, 25);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(500, 140));
        jPanel1.add(txtEmail);
        txtEmail.setBounds(20, 250, 550, 40);

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("Phone");
        jPanel1.add(lblPhone);
        lblPhone.setBounds(20, 300, 54, 25);

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.setPreferredSize(new java.awt.Dimension(500, 140));
        jPanel1.add(txtPhone);
        txtPhone.setBounds(20, 330, 550, 40);

        btnSave.setBackground(new java.awt.Color(0, 204, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorderPainted(false);
        btnSave.setFocusPainted(false);
        btnSave.setMaximumSize(new java.awt.Dimension(90, 32));
        btnSave.setMinimumSize(new java.awt.Dimension(90, 32));
        btnSave.setPreferredSize(new java.awt.Dimension(90, 32));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(20, 550, 80, 32);

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setMaximumSize(new java.awt.Dimension(90, 32));
        btnCancel.setMinimumSize(new java.awt.Dimension(90, 32));
        btnCancel.setPreferredSize(new java.awt.Dimension(90, 32));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(320, 550, 90, 32);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatus.setText("Status");
        jPanel1.add(lblStatus);
        lblStatus.setBounds(20, 460, 60, 25);

        comboBoxStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        comboBoxStatus.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(comboBoxStatus);
        comboBoxStatus.setBounds(20, 490, 550, 40);

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPassword.setText("Password");
        jPanel1.add(lblPassword);
        lblPassword.setBounds(20, 380, 90, 25);

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(550, 40));
        jPanel1.add(txtPassword);
        txtPassword.setBounds(20, 410, 550, 40);

        btnUpdate.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorderPainted(false);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setMaximumSize(new java.awt.Dimension(90, 32));
        btnUpdate.setMinimumSize(new java.awt.Dimension(90, 32));
        btnUpdate.setPreferredSize(new java.awt.Dimension(90, 32));
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(110, 550, 100, 32);

        btnDelete.setBackground(new java.awt.Color(255, 102, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setMaximumSize(new java.awt.Dimension(90, 32));
        btnDelete.setMinimumSize(new java.awt.Dimension(90, 32));
        btnDelete.setPreferredSize(new java.awt.Dimension(90, 32));
        jPanel1.add(btnDelete);
        btnDelete.setBounds(220, 550, 90, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String dept = txtDept.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String password = txtPassword.getText();
        String status = comboBoxStatus.getSelectedItem().toString();

        if (name.isEmpty() || dept.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO user_detail (name,department,email,phone,password,status) VALUES(?, ? ,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, dept);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, password);
            pst.setString(6, status);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "User added successfully!");
                this.dispose(); // close the dialog
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddUserDialog dialog = new AddUserDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDept;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtDept;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
