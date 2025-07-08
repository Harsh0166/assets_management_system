
import dao.DBConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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

    public static void assetseditbtn(JTable assetsTable, home parent) {
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
                        parent.refreshDashboard();
                    }
                }
            }
        });
    }

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
