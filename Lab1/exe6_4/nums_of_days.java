import java.util.Scanner;

public class nums_of_days {
    // 1 is true, 0 is false
    static int checkLeapYear(int y) {
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) {
                    return 1;
                }
                else return 0;
            } else return 1;
        } return 0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        // Scan month and year
        System.out.print("Enter month: ");
        String month = scanner.nextLine().trim(); 
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        int countDays = 0, m = 0; // We need to m = 0

        // Solve
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < 12; i++) {
            if (month.equals(months[i]) == true) m = i + 1;
        }

        if (m == 2) {
            if (checkLeapYear(year) == 1)
                countDays = 29;
            else 
                countDays = 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11)
            countDays = 30;
        else 
            countDays = 31;

        System.out.print("There are " + countDays + " days in " + month);
    }
}

