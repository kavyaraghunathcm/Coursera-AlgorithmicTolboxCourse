import java.util.*;

public class FibonacciPartialSum {
    private static int getFibonacci(long n)
    {

        int f0 = 0;
        int f1 = 1;

        if (n <=1 )
            return (int) n;
        else
        {
            int rem = (int) (n % 60);
            if(rem == 0)
                return 0;
            for(int i = 2; i < rem + 3; i++)
            {
                int f = (f0 + f1) % 60;
                f0 = f1;
                f1 = f;
            }

            int s = f1 - 1;
            return s;
        }
    }

    private static int getFibonacciPartialSum(long from, long to){
       return  ((int)Math.abs(getFibonacci(to) - getFibonacci(from - 1))) % 10;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
