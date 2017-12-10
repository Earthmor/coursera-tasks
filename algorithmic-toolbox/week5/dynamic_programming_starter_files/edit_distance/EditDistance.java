import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    return levDistanceCalc(s.toCharArray(), t.toCharArray());
  }

  public static int levDistanceCalc(char[] s, char[] t){
    int[][] d = new int[s.length + 1][t.length + 1];
    for(int i = 0; i <= s.length; ++i){
      d[i][0] = i;
    }
    for(int j = 0; j <= t.length; ++j){
      d[0][j] = j;
    }

    for(int j = 1; j <= t.length; ++j){
      for(int i = 1; i <= s.length; ++i){
        int cost = 0;
        if(s[i-1] == t[j-1]){
          cost = 0;
        } else {
          cost = 1;
        }
        d[i][j] = Math.min(
          d[i-1][j] + 1,
          Math.min(
            d[i][j-1] + 1,
            d[i-1][j-1] + cost
          )
        );
      }
    }
    return d[s.length][t.length];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
