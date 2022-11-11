import java.util.*;

public class SearchMinMax {
    static Scanner scan = new Scanner(System.in);

    public static void main(String... args) {
        System.out.println("Enter size of inputs");
        int n = scan.nextInt();
        findWithUserInputs(n);
        findWithRandomInputs(n);
    }

    private static void findWithUserInputs(int n) {
        int arr[] = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            arr[i] = scan.nextInt();
        }
        printArray(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("The in the given array, max value= " + max + " and min value= " + min);
    }

    private static void findWithRandomInputs(int n) {
        int arr[] = new int[n];
        Random rand = new Random();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10 * n);
        }
        printArray(arr);

        //
        for (int i = 0; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("The in the given array, max value= " + max + " and min value= " + min);
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}