import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static int SIZE = 7000;

    public static void main(String[] args) {
        System.out.println("Enter the total number of elements for Sorting");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Random m = new Random();
        
        for (int i = 0; i < n; i++) {
            a[i] = m.nextInt(10) + 1;
        }
        
        System.out.println("\nThe Elements Before Sorting...");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        long start_time, end_time;
        start_time = System.nanoTime();
        mergeSort(a, 0, n - 1);
        end_time = System.nanoTime();

        System.out.println("\nThe Elements After Sorting....");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        System.out.println("\nThe Time Required for Sorting " + n + " Numbers is: " + (end_time - start_time) + " ns");
    }

    public static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            combine(a, low, mid, high);
        }}
    public static void combine(int a[], int low, int mid, int high) {
        int i, j, k;
        int[] temp = new int[SIZE];
        k = low;
        i = low;
        j = mid + 1;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }
        for (k = low; k <= high; k++) {
            a[k] = temp[k];
        }
    }
}
