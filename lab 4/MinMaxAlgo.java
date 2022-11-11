import java.util.*;
import java.time.*;

class MinAndMaxData {
    int min, max;

    MinAndMaxData() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}

public class MinMaxAlgo {
    public static void main(String[] args) {
        int[] sizes = { 100000, 200000, 300000, 400000, 500000 };
        for (int size : sizes) {
            MinAndMaxData obj = new MinAndMaxData();
            System.out.println("Time for recursive approach of size " + size + " is= " + timeForRecursive(size, obj));
            MinAndMaxData temp = new MinAndMaxData();
            System.out.println("Time for linear approach of size " + size + " is= " + timeForLinear(size, temp));
            System.out.println();
        }
    }

    public static int[] buildArray(int n) {
        int arr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(n * 10);
        return arr;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void linearMinMax(int arr[], MinAndMaxData obj) {
        for (int i = 0; i < arr.length; i++) {
            if (obj.max < arr[i])
                obj.max = arr[i];
            if (obj.min > arr[i])
                obj.min = arr[i];
        }
    }

    public static void MaxMin(int arr[], int low, int high, MinAndMaxData obj) {
        if (low == high) {
            obj.max = (arr[high] > obj.max) ? arr[high] : obj.max;
            obj.min = (arr[low] < obj.min) ? arr[low] : obj.min;
            return;
        } else if ((high - low) == 1) {
            if (arr[low] < arr[high]) {
                obj.max = (arr[high] > obj.max) ? arr[high] : obj.max;
                obj.min = (arr[low] < obj.min) ? arr[low] : obj.min;
            } else {
                obj.max = (arr[low] > obj.max) ? arr[low] : obj.max;
                obj.min = (arr[high] < obj.min) ? arr[high] : obj.min;
            }
            return;
        } else {
            int mid = (low + high) / 2;
            MaxMin(arr, low, mid, obj);
            MaxMin(arr, mid + 1, high, obj);
        }
    }

    public static double timeForLinear(int n, MinAndMaxData obj) {
        double start = LocalTime.now().toNanoOfDay();
        linearMinMax(buildArray(n), obj);
        double end = LocalTime.now().toNanoOfDay();
        return (end - start) / 1000000000.0;
    }

    public static double timeForRecursive(int n, MinAndMaxData obj) {
        double start = LocalTime.now().toNanoOfDay();
        MaxMin(buildArray(n), 0, n - 1, obj);
        double end = LocalTime.now().toNanoOfDay();
        return (end - start) / 1000000000.0;
    }

}
