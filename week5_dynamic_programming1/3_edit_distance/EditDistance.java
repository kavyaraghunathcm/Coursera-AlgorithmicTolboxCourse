import java.util.*;

class EditDistance {
  public static int editDistance(String s, String t) {
    int slength=s.length();
    int tlength=t.length();
    
    //write your code here
    int[][] d =new int[slength+1][tlength+1];
    for (int i = 0; i <=s.length() ; i++) {
        d[i][0]=i;      
    }
    for (int j = 0; j <=t.length() ; j++) {
      d[0][j]=j;
    }
    for (int j = 1; j <=tlength ; j++) {
      for (int i = 1; i <= slength; i++) {
        int insertion=d[i][j-1]+1;
        int deletion= d[i-1][j]+1;
        int mismatch= d[i-1][j-1]+1;
        int match= d[i-1][j-1];
        if(s.charAt(i-1)==t.charAt(j-1)){
          d[i][j]=Math.min(match,Math.min(insertion,deletion));
        }
        else {
          d[i][j]=Math.min(mismatch,Math.min(insertion,deletion));
        }
      }
    }

    return d[slength][tlength];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
  }

}
