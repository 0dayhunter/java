import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of elements for sorting: ");
        int n = sc.nextInt();
        
        int[] a = new Random().ints(n, 1, 11).toArray();
        
        System.out.println("\nThe elements before sorting....");
        System.out.println(Arrays.toString(a));
        
        long start_time = System.nanoTime();
        selectionSort(a);
        long end_time = System.nanoTime();
        
        System.out.println("\nThe elements after sorting");
        System.out.println(Arrays.toString(a));
        
        System.out.println("\nThe time required for sorting " + n + " numbers is: " +
                (end_time - start_time) + " ns");
    }

    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }}}}
        
