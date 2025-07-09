public class Main {
    public static void main(String[] args) {
        // Replace "3" with the actual user ID you want to load
        String userId = "13";

        javax.swing.SwingUtilities.invokeLater(() -> {
            user userFrame = new user(userId);
            userFrame.setVisible(true);
        });
    }
}
