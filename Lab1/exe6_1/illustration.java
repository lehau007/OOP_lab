import javax.swing.JOptionPane;

public class illustration {
    public static void main(String args[]) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket");

        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "YES" : "NO"));
        System.exit(0);
    }
}