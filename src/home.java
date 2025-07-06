
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dao.DBConnection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;

public class home extends javax.swing.JFrame {

    private dashboardpage dashboard;

    public home() {
        initComponents();
        setLocationRelativeTo(null);

//        dashboard connection
        dashboard = new dashboardpage(
                lblTotalUsers, lblTotalAssets,
                lblAssignedAssets, lblUnassignedAssets,
                lblMaintenanceAssets
        );
        dashboard.loadDashboardStats();

//        userpage connection
        userpage.loadUserTable(userTable);

//        add user dialog box connection
        btnAdduser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddUserDialog dialog = new AddUserDialog(home.this, true);
                dialog.setVisible(true);
                userpage.loadUserTable(userTable);
                dashboard.loadDashboardStats();
            }
        });

//        tabPanel.setUI(null); // This hides the tab headers
        assetspage.loadassetstable(assetsTable);

        assetsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = assetsTable.getColumnModel().getColumnIndex("Operation");
                int row = assetsTable.rowAtPoint(evt.getPoint());

                // Check if clicked column is the "Operation" column
                if (column == assetsTable.columnAtPoint(evt.getPoint())) {
                    if (assetsTable.getValueAt(row, column).equals("Edit")) {
                        // Get asset details from selected row
                        int assets_id = (int) assetsTable.getValueAt(row, 0);
                        String assets_type = (String) assetsTable.getValueAt(row, 1);
                        String serial_no = (String) assetsTable.getValueAt(row, 2);
                        String purchase_date = (String) assetsTable.getValueAt(row, 3);
                        String action = (String) assetsTable.getValueAt(row, 4);
                        String current_owner = (String) assetsTable.getValueAt(row, 5);
                        String description = (String) assetsTable.getValueAt(row, 6);

                        // Open dialog and pass values
                        AddAssetsDialog dialog = new AddAssetsDialog(null, true);
                        dialog.loadAssetsData(assets_id, assets_type, serial_no, purchase_date, action, current_owner, description);
                        dialog.setVisible(true);

                        assetspage.loadassetstable(assetsTable); // Refresh table after editing
                    }
                }
            }
        });

        assetsTable.getColumn("Operation").setCellRenderer(new ButtonRenderer());

        btnAddassets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddAssetsDialog dialog = new AddAssetsDialog(home.this, true);
                dialog.setVisible(true);
                assetspage.loadassetstable(assetsTable); // Refresh user table after dialog closes
                dashboard.loadDashboardStats();

            }
        }
        );

        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(0); // Dashboard tab
            }
        });

        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(1); // User Management tab
            }
        });

        btnAssetsMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(2); // User Management tab
            }
        });
        btnAssetsHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(3); // User Management tab
            }
        });
        btnAssetsSta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabPanel.setSelectedIndex(4); // User Management tab
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
        btnUser = new javax.swing.JButton();
        btnAssetsMan = new javax.swing.JButton();
        btnAssetsHis = new javax.swing.JButton();
        btnAssetsSta = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        mainpanel = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        dashboardpanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblTotalUsers = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblTotalAssets = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblAssignedAssets = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblMaintenanceAssets = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUnassignedAssets = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userpanel = new javax.swing.JPanel();
        topBtnPanel = new javax.swing.JPanel();
        btnAdduser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        assetspanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddassets = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        assetsTable = new javax.swing.JTable();
        historypanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        statuspanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 144, 226));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Assets Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 22, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users.png"))); // NOI18N
        jLabel2.setText("Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 72, -1, -1));

        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDashboard.setText("Dashboard");
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 202, -1));

        btnUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUser.setText("User Management");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 202, -1));

        btnAssetsMan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAssetsMan.setText("Assets Management");
        jPanel1.add(btnAssetsMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnAssetsHis.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAssetsHis.setText("Assets History");
        jPanel1.add(btnAssetsHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 202, -1));

        btnAssetsSta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAssetsSta.setText("Assets Status");
        jPanel1.add(btnAssetsSta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 202, -1));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogout.setText("Logout");
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 202, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainpanel.setPreferredSize(new java.awt.Dimension(1120, 768));
        mainpanel.setLayout(new java.awt.CardLayout());

        dashboardpanel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(250, 100));

        lblTotalUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalUsers.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Total Users");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblTotalUsers))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel11)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        dashboardpanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jPanel7.setPreferredSize(new java.awt.Dimension(250, 100));

        lblTotalAssets.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalAssets.setText("0");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Total Assets");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblTotalAssets))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel12)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalAssets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        dashboardpanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jPanel8.setPreferredSize(new java.awt.Dimension(250, 100));

        lblAssignedAssets.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAssignedAssets.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Assigned Assets");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblAssignedAssets))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel13)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAssignedAssets, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dashboardpanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jPanel9.setPreferredSize(new java.awt.Dimension(250, 100));

        lblMaintenanceAssets.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblMaintenanceAssets.setText("0");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Maintenance");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblMaintenanceAssets))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel14)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaintenanceAssets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        dashboardpanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        lblUnassignedAssets.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblUnassignedAssets.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Unassigned Assets");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblUnassignedAssets, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUnassignedAssets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        dashboardpanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 250, 100));

        tabPanel.addTab("Dashboard", dashboardpanel);

        userpanel.setBackground(new java.awt.Color(255, 255, 255));
        userpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBtnPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnAdduser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdduser.setText("Add User");
        topBtnPanel.add(btnAdduser);

        userpanel.add(topBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        userTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Department", "Email", "Phone", "Status", "Operation"
            }
        ));
        userTable.setRowHeight(30);
        userTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(userTable);

        userpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1070, 640));

        tabPanel.addTab("User Management", userpanel);

        assetspanel.setBackground(new java.awt.Color(255, 255, 255));
        assetspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddassets.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddassets.setText("Add Assets");
        btnAddassets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddassetsActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddassets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        assetspanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 50));

        assetsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        assetsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assets Id", "Assets Type", "Serial No.", "Purchase Date", "Action", "Current Owner", "Description", "Operation"
            }
        ));
        assetsTable.setRowHeight(30);
        assetsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assetsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(assetsTable);

        assetspanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 66, 1070, 640));

        tabPanel.addTab("Assets Management", assetspanel);

        historypanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Assets Id", "Employee Id", "Action", "Date", "Note"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        historypanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1078, 700));

        tabPanel.addTab("Assets History", historypanel);

        jLabel7.setText("status");

        javax.swing.GroupLayout statuspanelLayout = new javax.swing.GroupLayout(statuspanel);
        statuspanel.setLayout(statuspanelLayout);
        statuspanelLayout.setHorizontalGroup(
            statuspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statuspanelLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(745, Short.MAX_VALUE))
        );
        statuspanelLayout.setVerticalGroup(
            statuspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statuspanelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel7)
                .addContainerGap(580, Short.MAX_VALUE))
        );

        tabPanel.addTab("Assets Status", statuspanel);

        mainpanel.add(tabPanel, "card2");

        getContentPane().add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 768));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserActionPerformed

    private void assetsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assetsTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_assetsTableMouseClicked

    private void btnAddassetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddassetsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddassetsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Edit" : value.toString());
            return this;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assetsTable;
    private javax.swing.JPanel assetspanel;
    private javax.swing.JButton btnAddassets;
    private javax.swing.JButton btnAdduser;
    private javax.swing.JButton btnAssetsHis;
    private javax.swing.JButton btnAssetsMan;
    private javax.swing.JButton btnAssetsSta;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel dashboardpanel;
    private javax.swing.JPanel historypanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAssignedAssets;
    private javax.swing.JLabel lblMaintenanceAssets;
    private javax.swing.JLabel lblTotalAssets;
    private javax.swing.JLabel lblTotalUsers;
    private javax.swing.JLabel lblUnassignedAssets;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel statuspanel;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JPanel topBtnPanel;
    private javax.swing.JTable userTable;
    private javax.swing.JPanel userpanel;
    // End of variables declaration//GEN-END:variables
}
