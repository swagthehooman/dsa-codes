//Swagnik Das 20051228

import java.util.*;
import java.time.*;

class SortTimeComplexity {
    public static void main(String args[]) {
        int inputSize[] = new int[] { 10000, 20000, 30000, 40000, 50000 };
        for (int size : inputSize) {
            System.out.println("Time for insertion sort with " + size + " inputs= "
                    + insertionSort(buildArray(size)));
            System.out.println("Time for selection sort with " + size + " inputs= "
                    + selectionSort(buildArray(size)));
            System.out.println("Time for bubble sort with " + size + " inputs= "
                    + bubbleSort(buildArray(size)));

            System.out.println("\n");

        }
    }

    // Returns the Randomely filled array of size n
    private static int[] buildArray(int n) {
        int arr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        return arr;
    }

    // insertion sort funtion which returns the running time of insertion sort over
    // the passed array
    private static double insertionSort(int arr[]) {
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

    // bubble sort funtion which returns the running time of bubble sort over the
    // passed array
    private static double bubbleSort(int arr[]) {
        int n = arr.length;
        double start = LocalTime.now().toNanoOfDay();
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
        return (end - start) / 1000000000.0;
    }

    // selection sort funtion which returns the running time of selection sort over
    // the passed array
    private static double selectionSort(int arr[]) {
        int n = arr.length;
        double start = LocalTime.now().toNanoOfDay();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        double end = LocalTime.now().toNanoOfDay();
        return (end - start) / 1000000000.0;
    }
}