import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Keyboard input

        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();

        // Loop for rows
        for (int i = 0; i < n; i++) {
            // Loop for columns
            for (int j = i + 1; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            // End row
            System.out.println();
        }

        scanner.close();
    }
}
