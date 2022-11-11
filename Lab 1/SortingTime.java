import java.time.LocalTime;
import java.util.*;

class SortingTime {
    public static void main(String[] args) {
        System.out.println("Time to sort 10 elements= " + sort(10));
        System.out.println("Time to sort 1000 elements= " + sort(1000));
        System.out.println("Time to sort 10000 elements= " + sort(100000));
    }

    private static double sort(int n) {
        int arr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10 * n);
        }
        double start = LocalTime.now().toNanoOfDay();
        // System.out.println(start);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        double end = LocalTime.now().toNanoOfDay();
        // System.out.println(end);
        // int timeElapsed=end-start;
        return (end - start) / 1000000000.0;
    }
}
