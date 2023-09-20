import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of elements for sorting: ");
        int n = sc.nextInt();

        int[] a = new Random().ints(n, 1, 11).toArray();

        System.out.println("\nThe elements before sorting....");
        System.out.println(Arrays.toString(a));

        long start_time = System.nanoTime();
        quickSort(a, 0, n - 1);
        long end_time = System.nanoTime();

        System.out.println("\nThe elements after sorting");
        System.out.println(Arrays.toString(a));

        System.out.println("\nThe time required for sorting " + n + " numbers is: " +
                (end_time - start_time) + " ns");
    }

    static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (a[i] <= pivot && i < high) i++;
            while (a[j] > pivot) j--;
            if (i < j) swap(a, i, j);
        }

        swap(a, low, j);
        return j;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
