import javax.swing.JOptionPane;

// Enter 2 double numbers
public class caculator {
    public static void main(String[] argc) {
        String a, b;

        a = JOptionPane.showInputDialog("Enter the number a = ");
        b = JOptionPane.showInputDialog("Enter the number b = ");

        Double tempA = Double.parseDouble(a), tempB = Double.parseDouble(b);

        // Sum
        System.out.println("Sum of a and b is: " + (tempA + tempB));

        // Product
        System.out.println("Product: " + (tempA * tempB));

        // Different 
        System.out.println("Different: " + (tempA - tempB));

        // Quotient
        if (tempB != 0) {
            System.out.println("Quotient: " + (tempA / tempB));
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
}