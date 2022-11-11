public class MergeSortAlgo {
    public static void main(String[] args) {
        int arr[] = { 8, 14, 32, 0, 45, 22 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSortAlgo ob = new MergeSortAlgo();
        ob.MergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private void merge(int arr[], int low, int high, int mid) {
        int n1 = mid - low + 1, n2 = high - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[low + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    private void MergeSort(int arr[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            MergeSort(arr, p, q);
            MergeSort(arr, q + 1, r);
            merge(arr, p, r, q);
        }
    }
}
