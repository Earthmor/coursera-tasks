import java.util.*;

public class LCM {

  private static long lcm(int a, int b) {
    if(a < 1 || b < 1){
      return 0;
    }
    return (long) a*b/gcd(a, b);
  }

  private static long gcd(long a, long b) {
    if(b > 0){
      return gcd(b, (a % b));
    } else {
      return a;
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
