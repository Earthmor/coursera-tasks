import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
      // denomination of coins 1, 5, 10
      int n = 0;
      while (m > 0) {
        if(m >= 10){
          n++;
          m -= 10;
        } else if(m >= 5){
          n++;
          m -= 5;
        } else if(m >= 1) {
          n++;
          m -= 1;
        }
      }
      return n;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int m = scanner.nextInt();
      System.out.println(getChange(m));
    }
}
