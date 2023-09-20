import java.util.Scanner;

public class KnapsackGreedy {
    public static void main(String[] args) {
        int i, j, n;
        float temp, m;
        float[] p = new float[15];
        float[] w = new float[15];
        float[] c = new float[15];
        
        System.out.println("\nEnter Number of Objects:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        System.out.println("\nEnter Weights:");
        for (i = 0; i < n; i++)
            w[i] = sc.nextFloat();
        
        System.out.println("\nEnter Profits:");
        for (i = 0; i < n; i++)
            p[i] = sc.nextFloat();
        
        System.out.println("\nEnter Knapsack Size:");
        m = sc.nextFloat();
        
        for (i = 0; i < n; i++)
            c[i] = p[i] / w[i];
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < n - 1; j++) {
                if (c[j] < c[j + 1]) {
                    temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                    
                    temp = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = temp;
                    
                    temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\nThe Items are Arranged as...\n");
        System.out.println("\n\nItems\tWeights\tProfits");
        
        for (i = 0; i < n; i++)
            System.out.println("\nx[" + i + "]\t" + w[i] + "\t" + p[i]);
        
        knapsack(n, m, w, p);
    }
    
    public static void knapsack(int n, float m, float[] w, float[] p) {
        float[] x = new float[15];
        float U, profit = 0, weight = 0;
        int i;
        U = m;
        
        for (i = 0; i < n; i++) {
            x[i] = 0;
        }
        
        for (i = 0; i < n; i++) {
            if (w[i] > U)
                break;
            
            x[i] = 1;
            U = U - w[i];
        }
        
        if (i < n)
            x[i] = U / w[i];
        
        System.out.println("\nThe Solution Vector is:");
        
        for (i = 0; i < n; i++)
            System.out.println("\n" + i + "\t" + x[i]);
        
        for (i = 0; i < n; i++) {
            w[i] = w[i] * x[i];
            p[i] = p[i] * x[i];
        }
        
        for (i = 0; i < n; i++) {
            profit = profit + p[i];
            weight = weight + w[i];
        }
        
        System.out.println("\nMaximum Profit is:");
        System.out.println("\n\t\t" + profit);
        System.out.println("\nMaximum Weight is:");
        System.out.println("\n\t\t" + weight);
    }
}
