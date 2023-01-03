import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  private static long lcmUsingGcd(int a,int b ){
    return  ((long) a *b)/gcd_euclidean(a,b);
  }

  private  static int gcd_euclidean(int a, int b){
    int max =Math.max(a,b);
    int min=Math.min(a,b);
    if(min==0){
      return max;
    }
    else
    {
      return gcd_euclidean(min,max%min);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));

    System.out.println(lcmUsingGcd(a,b));
  }
}
