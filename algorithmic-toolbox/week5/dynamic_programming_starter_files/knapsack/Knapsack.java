import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] b) {
        // int[][] d = new int[W + 1][b.length + 1];
        // for(int i = 0; i <= W; ++i){
        //   d[i][0] = 0;
        // }
        // for(int j = 0; j <= b.length; ++j){
        //   d[0][j] = 0;
        // }

        // for(int w = 1; w <= W; ++w){
        //   for(int i = 1; i <= b.length; ++i){
        //     d[w][i] = d[w][i-1];
        //     if(b[i-1] <= w){
        //       int val =
        //     }
        //   }
        // }
        // for(int i = 1; i <= b.length; ++i){
        //     for(int j = 1; j <= W; ++j){
        //       d[j][i] = d[j][i-1];
        //       if(b[i - 1] <= j){
        //         int val = d[W-b[i - 1]][i - 1] + b[i - 1];
        //         if(d[j][i] < val && val <= W){
        //           d[j][i] = val;
        //         }
        //       }
        //     }
        // }

        int i, w;

        int [][]K = new int[b.length+1][W+1];
        for (i = 0; i <= b.length; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (b[i-1] <= w)
                    K[i][w] = Math.max(b[i-1] + K[i-1][w-b[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        return K[b.length][W];

        // return d[W][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
