import java.util.*;

public class SearchMinMaxRecur {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array to build");
        int n = scan.nextInt();
        findMaxAndMin(n);
        scan.close();
    }

    private static void findMaxAndMin(int n) {
        Random rand = new Random();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        print(arr);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIndex = 0, minIndex = 0;
        int maxSecond = Integer.MIN_VALUE, minSecond = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxSecond && i != maxIndex && arr[i] != max) {
                maxSecond = arr[i];
            }
            if (arr[i] < minSecond && i != minIndex && arr[i] != min) {
                minSecond = arr[i];
            }
        }
        System.out.println("Second Max=" + maxSecond);
        System.out.println("Second Min=" + minSecond);
    }

    private static void print(int arr[]) {
        System.out.println("The built Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
