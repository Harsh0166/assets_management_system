
import dao.DBConnection;
import java.sql.*;
import javax.swing.JLabel;

public class dashboardpage {

    private JLabel lblTotalUsers;
    private JLabel lblTotalAssets;
    private JLabel lblAssignedAssets;
    private JLabel lblUnassignedAssets;
    private JLabel lblMaintenanceAssets;
    private JLabel lblRetiredAssets;

    public dashboardpage(JLabel lblTotalUsers, JLabel lblTotalAssets,
            JLabel lblAssignedAssets, JLabel lblUnassignedAssets,
            JLabel lblMaintenanceAssets,JLabel lblRetiredAssets) {
        this.lblTotalUsers = lblTotalUsers;
        this.lblTotalAssets = lblTotalAssets;
        this.lblAssignedAssets = lblAssignedAssets;
        this.lblUnassignedAssets = lblUnassignedAssets;
        this.lblMaintenanceAssets = lblMaintenanceAssets;
        this.lblRetiredAssets = lblRetiredAssets;
       
    }

    public void loadDashboardStats() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM user_detail");
            if (rs1.next()) {
                lblTotalUsers.setText(rs1.getString(1));
            }

            ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM assets_detail");
            if (rs2.next()) {
                lblTotalAssets.setText(rs2.getString(1));
            }

            ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM assets_detail WHERE current_owner IS NOT NULL AND current_owner != 0");
            if (rs3.next()) {
                lblAssignedAssets.setText(rs3.getString(1));
            }

            ResultSet rs4 = stmt.executeQuery("SELECT COUNT(*) FROM assets_detail WHERE action = 'Unassigned'");
            if (rs4.next()) {
                lblUnassignedAssets.setText(rs4.getString(1));
            }

            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) FROM assets_detail WHERE action = 'Maintenance'");
            if (rs5.next()) {
                lblMaintenanceAssets.setText(rs5.getString(1));
            }

            ResultSet rs6 = stmt.executeQuery("SELECT COUNT(*) FROM assets_detail WHERE action = 'Retired'");
            if (rs6.next()) {
                lblRetiredAssets.setText(rs6.getString(1));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
