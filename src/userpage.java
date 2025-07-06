import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dao.DBConnection;

public class userpage {

    public static void loadUserTable(JTable userTable) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT user_id, name, department, email, phone, status FROM user_detail";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("status")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
