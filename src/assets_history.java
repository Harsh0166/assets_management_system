import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dao.DBConnection;

public class assets_history {

    // Static method to load data into a given JTable
    public static void loadAssignedAssetsHistory(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data

        try {
            Connection conn = DBConnection.getConnection();
            String sql = """
                SELECT h.id, h.assets_id, h.user_id, h.action, h.date, h.note
                FROM assets_history h
                JOIN assets_detail a ON h.assets_id = a.assets_id
                WHERE a.current_owner IS NOT NULL AND a.current_owner != ''
            """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getInt("assets_id"),
                    rs.getInt("user_id"),
                    rs.getString("action"),
                    rs.getString("date"),
                    rs.getString("note")
                });
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading asset history: " + e.getMessage());
        }
    }
}
