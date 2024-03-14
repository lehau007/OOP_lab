import javax.swing.JOptionPane;

public class firstequation {
    public static void main(String args[]) {
        String tempa, tempb;

        tempa = JOptionPane.showInputDialog("Enter the number a = ");
        tempb = JOptionPane.showInputDialog("Enter the number b = ");

        Double a = Double.parseDouble(tempa), b = Double.parseDouble(tempb);
        
        if (a == 0) {
            System.out.println("The equation has non-solution");
        } else System.out.print("The solution of " + a + " x + "+ b + "is: " + (-b / a));
    }
}