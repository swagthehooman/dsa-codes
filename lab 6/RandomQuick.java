import java.util.Random;

public class RandomQuick {
    public static void main(String[] args) {
        int arr[] = { 13, 60, 8, 10, 2, 34, 1, 72, 4, 22 };

        System.out.println("Before: ");
        printArray(arr);

        quickSort(arr);

        System.out.println("After: ");
        printArray(arr);

    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int arr[], int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);
        int p = partition(arr, lowIndex, highIndex, pivot);
        quickSort(arr, lowIndex, p - 1);
        quickSort(arr, p + 1, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int i = lowIndex, j = highIndex;
        while (i < j) {
            while (arr[i] <= pivot && i < j)
                i++;
            while (arr[j] >= pivot && j > i)
                j--;
            swap(arr, i, j);
        }
        swap(arr, highIndex, j);
        return j;
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }
}