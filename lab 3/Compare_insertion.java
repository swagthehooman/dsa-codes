import java.util.*;
import java.time.*;

class Compare_insertion {
    public static void main(String[] args) {
        int size[] = { 10000, 20000, 30000, 40000, 50000 };
        for (int temp : size) {
            System.out.println(
                    "Best case time for size= " + temp + " is "
                            + insertionSorting(sortingInAccending(buildArray(temp))));
            System.out.println(
                    "Worst case time for size= " + temp + " is "
                            + insertionSorting(sortingInDescending(buildArray(temp))));
            System.out.println();
        }
    }

    private static int[] buildArray(int n) {
        int arr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        return arr;
    }

    private static double insertionSorting(int arr[]) {
        int n = arr.length;
        double start = LocalTime.now().toNanoOfDay();
        for (int i = 1; i < n; i++) {
            int j = i - 1, key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        double end = LocalTime.now().toNanoOfDay();
        return (end - start) / 1000000000.0;
    }

    private static int[] sortingInAccending(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1, key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private static int[] sortingInDescending(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1, key = arr[i];
            while (j >= 0 && key > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
