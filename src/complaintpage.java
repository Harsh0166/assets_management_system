
import java.sql.*;
import dao.DBConnection;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class complaintpage {

    public static void loadComplaints(JTable complaintsTable) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "User ID", "Asset ID", "Type", "Serial No", "Complaint", "Status", "Action"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // make table read-only
            }
        };

        complaintsTable.setModel(model);

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT id, user_id, asset_id, asset_type, serial_no, complaint, status FROM asset_complaints";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("asset_id"),
                    rs.getString("asset_type"),
                    rs.getString("serial_no"),
                    rs.getString("complaint"),
                    rs.getString("status"),
                    "Update"
                });
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading complaints: " + e.getMessage());
        }

        // Set the Action column as a button
        complaintsTable.getColumn("Action").setCellRenderer(new ButtonRenderer());

        // Handle button click
        complaintsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = complaintsTable.rowAtPoint(e.getPoint());
                int col = complaintsTable.columnAtPoint(e.getPoint());

                if (col == complaintsTable.getColumn("Action").getModelIndex()) {
                    int complaintId = (int) complaintsTable.getValueAt(row, 0);
                    String currentStatus = (String) complaintsTable.getValueAt(row, 6);

                    String newStatus = (String) JOptionPane.showInputDialog(
                            null,
                            "Update Status:",
                            "Change Complaint Status",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            new String[]{"Pending", "In Progress", "Resolved"},
                            currentStatus
                    );

                    if (newStatus != null && !newStatus.equals(currentStatus)) {
                        updateComplaintStatus(complaintId, newStatus);
                        loadComplaints(complaintsTable); // Refresh table
                    }
                }
            }
        });

    }

    public static void updateComplaintStatus(int complaintId, String newStatus) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE asset_complaints SET status = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newStatus);
            ps.setInt(2, complaintId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Complaint status updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update complaint status.");
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Action" : value.toString());
        return this;
    }
}
