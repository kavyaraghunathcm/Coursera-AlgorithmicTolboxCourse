import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }


    public static long fibonacciSumHugeLastDigit(long n){
        return calc_fib_sum((int) (n%60L))%10 ;
    }
    private static long calc_fib_sum(int n) {
        if (n <= 1)
            return n;
        else {
            long sum=1;
            long fibNMinusTwo = 0;
            long fibNMinusOne = 1;

            for (int i = 2; i <= n; i++) {
                long temp = fibNMinusTwo;
                fibNMinusTwo = fibNMinusOne;
                fibNMinusOne = fibNMinusOne + temp;
                sum=sum+fibNMinusOne;

            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = fibonacciSumHugeLastDigit(n);
        System.out.println(s);
        /*for (int i = 0; i <100 ; i++) {
            System.out.println(getFibonacciSumNaive(i)+" "+ fibonacciSumHugeLastDigit(i));
        }*/
    }
}

