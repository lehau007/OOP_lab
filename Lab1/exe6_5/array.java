import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main (String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = keyboard.nextInt(), sum = 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter nums[" + i + "]: ");
            nums[i] = keyboard.nextInt();
            sum += nums[i];
        }

        // Sort the array
        Arrays.sort(nums);

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.println("num[" + i + "] = " + nums[i]);
        }
        System.out.print("The avarage is: " + ((double)sum / n));
    }
}
