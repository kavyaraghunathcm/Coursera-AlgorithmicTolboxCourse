import java.util.Scanner;

public class ChangeDP {

    private static int[] coins={1,3,4};
    private static int getChange(int money) {
        //write your code here
        int[] minNoofCoins= new int[money+1];
        minNoofCoins[0]=0;
        for (int m = 1; m <= money; m++) {
            minNoofCoins[m]=money+1;
            for (int i = 0; i < coins.length; i++) {
                if(m>=coins[i]){
                    int numCoins=minNoofCoins[m-coins[i]]+1;
                    if(numCoins<minNoofCoins[m])
                    {
                        minNoofCoins[m]=numCoins;
                    }
                }
            }
        }

        return minNoofCoins[money];
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            System.out.println(getChange(m));


    }
}

