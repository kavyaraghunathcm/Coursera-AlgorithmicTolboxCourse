import java.util.*;

public class PrimitiveCalculator {
    private enum OPERATIONS{ADDONE(1), MULTIPLYBYTWO(2),MULTIPLYBYTHREE(3);
        int minVal;
        OPERATIONS(int minVal) {
            this.minVal=minVal;
        }
    }

    private static int operate(OPERATIONS operation,int n){
        switch (operation) {
            case ADDONE : {
                if(n!=0){
                n -= 1;break;}
            }
            case MULTIPLYBYTWO: {
                n /= 2;break;
            }
            case MULTIPLYBYTHREE : {
                n /= 3;break;
            }
        }
        return n;
    }
    private static List<Integer> optimal_sequence_greedy(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static int[] optimalSequenceDP(int number){
        int[] minNoOfOperations=new int[number+1];
        minNoOfOperations[0]=0;
        minNoOfOperations[1]=0;
        OPERATIONS[] operations={OPERATIONS.ADDONE,OPERATIONS.MULTIPLYBYTWO,OPERATIONS.MULTIPLYBYTHREE} ;
        OPERATIONS[] optimalOperations= new OPERATIONS[number+1];
        optimalOperations[0]=null;
        optimalOperations[1]=null;
        for (int n = 2; n <=number ; n++) {
            minNoOfOperations[n]=number+1;
            for (OPERATIONS operation: operations) {
                if(n%(operation.minVal)==0){
                    int noOfOperations= minNoOfOperations[operate(operation,n)]+1;
                    if (noOfOperations<minNoOfOperations[n]) {
                        minNoOfOperations[n] = Math.min(noOfOperations, minNoOfOperations[n]);
                        optimalOperations[n]=operation;
                    }
                }
            }
        }
        int n=number;
        int[] sequence = new int[minNoOfOperations[number]+1];
        sequence[0]=1;
        for (int i = sequence.length-1; i >0 ; i--) {
            sequence[i]=n;
            n=operate(optimalOperations[n],n);
        }
        return sequence;
    }
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] sequence = optimalSequenceDP(n);
            System.out.println(sequence.length - 1);
            for (Integer x : sequence) {
                System.out.print(x + " ");
            }
    }
}

