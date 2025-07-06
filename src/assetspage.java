
import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class assetspage {
    public static void loadassetstable(JTable assetsTable) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT assets_id, assets_type, serial_no,purchase_date,action,current_owner,description FROM assets_detail";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) assetsTable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int assets_id = rs.getInt("assets_id");
                String assets_type = rs.getString("assets_type");
                String serial_no = rs.getString("serial_no");
                String purchase_date = rs.getString("purchase_date");
                String action = rs.getString("action");
                String current_owner = rs.getString("current_owner");
                String description = rs.getString("description");
                model.addRow(new Object[]{assets_id, assets_type, serial_no, purchase_date, action, current_owner, description, "Edit"});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
