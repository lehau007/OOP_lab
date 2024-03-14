import javax.swing.JOptionPane;

public class secondequation {
    public static void main(String args[]) {
        String tempa, tempb, tempc;

        tempa = JOptionPane.showInputDialog("Enter the number a = ");
        tempb = JOptionPane.showInputDialog("Enter the number b = ");
        tempc = JOptionPane.showInputDialog("Enter the number c = ");

        Double a = Double.parseDouble(tempa), b = Double.parseDouble(tempb), c = Double.parseDouble(tempc);
        
        if (a == 0) {
            if (b == 0) {
                if (c == 0) System.out.print("The equation has infinite solution");
                else System.out.print("No solution");
            } else System.out.print("One solution: " + (-c / b));
        } else {
            Double delta = b * b - 4 * a * c;
            if (delta < 0) System.out.print("No solution");
            else if (delta == 0) System.out.print("One solution: " + (-b / (2 * a)));
            else {
                System.out.println("The first solution is: " + ((-b + Math.sqrt(delta)) / (2 * a)));
                System.out.println("The second solution is: " + ((-b - Math.sqrt(delta)) / (2 * a)));
            }
        }
    }
}