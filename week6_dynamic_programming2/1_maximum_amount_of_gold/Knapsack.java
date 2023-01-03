import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] weights) {
        //write you code here
        int n=weights.length;
        int[][] maxWeights=new int[W+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                maxWeights[w][i]=maxWeights[w][i-1];
                if(w>=weights[i-1]){
                    int maxWeight= maxWeights[w-weights[i-1]][i-1]+weights[i-1];
                    if(maxWeight>maxWeights[w][i] && maxWeight<=w){
                        maxWeights[w][i]=maxWeight;
                    }
                }
            }
        }
        return maxWeights[W][n];
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

