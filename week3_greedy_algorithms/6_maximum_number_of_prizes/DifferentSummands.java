import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum=0;

        int i=1;
        while (sum!=n){

            /*if(n-(sum+i)==0){
                 summands.add(i);
            }
            else*/ if (n-(sum+i)<=i){
                i=n-sum;
            }
            summands.add(i);
            sum+=i;
            i++;
        }
        //write your code here
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

