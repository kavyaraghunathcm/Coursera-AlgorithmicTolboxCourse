import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        Map<Double,Integer> map =new TreeMap<>(Comparator.comparingDouble(d -> (double) d).reversed());
        for (int i = 0; i < values.length; i++) {
            map.put(((double) values[i]/weights[i]),weights[i] );
        }
        double W= capacity;
        for (double maxCost : map.keySet()) {
            double cm =maxCost;
            double wm = map.get(maxCost);
            double amount= Math.min(W, wm);
            value=value+(double) (maxCost*amount);
            W=W-amount;
            if (capacity==0){
                break;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
