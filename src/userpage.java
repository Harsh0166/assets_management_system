import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dao.DBConnection;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;

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
                int user_id = rs.getInt("user_id");
            String name = rs.getString("name");
            String dept = rs.getString("department");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String status = rs.getString("status");

            model.addRow(new Object[]{user_id, name, dept, email, phone, status, "Edit"});
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public static void UserEditBtn(JTable userTable, home parent) {
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = userTable.getColumnModel().getColumnIndex("Operation");
                int row = userTable.rowAtPoint(evt.getPoint());

                // Check if clicked column is the "Operation" column
                if (column == userTable.columnAtPoint(evt.getPoint())) {
                    if (userTable.getValueAt(row, column).equals("Edit")) {
                        // Get asset details from selected row
                        int user_id = (int) userTable.getValueAt(row, 0);
                        String name = (String) userTable.getValueAt(row, 1);
                        String department = (String) userTable.getValueAt(row, 2);
                        String email = (String) userTable.getValueAt(row, 3);
                        String phone = (String) userTable.getValueAt(row, 4);
                        String status = (String) userTable.getValueAt(row, 5);
                       

                        // Open dialog and pass values
                        AddUserDialog dialog = new AddUserDialog(null, true);
                        dialog.loadUserData(user_id, name, department, email, phone,"", status);
                        dialog.setVisible(true);

                        userpage.loadUserTable(userTable); // Refresh table after editing
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
