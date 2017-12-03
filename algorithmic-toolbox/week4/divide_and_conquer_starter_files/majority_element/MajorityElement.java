import java.util.*;
import java.io.*;

public class MajorityElement {
    private static long getMajorityElement(long[] a, int left, int right) {
        // TODO THAT realization didn't past the all test, stoped on 5/21. WHY?  
        // if(left > right){
        //   return -1;
        // }
        // if(left == right){
        //   return a[left];
        // }
        // int mid = left + (right - left) / 2;
        // long leftCount = getMajorityElement(a, left, mid);
        // long rightCount = getMajorityElement(a, mid + 1, right);
        //
        // if(leftCount == -1 && rightCount != -1){
        //   int num = count(a, left, right, rightCount);
        //   if(num > (right - left + 1) / 2){
        //     return rightCount;
        //   } else { return -1; }
        // } else if(rightCount == -1 && leftCount != -1){
        //   int num = count(a, left, right, leftCount);
        //   if(num > (right - left + 1) / 2){
        //     return leftCount;
        //   } else { return -1; }
        // } else if(leftCount != -1 && rightCount != -1){
        //   int leftNum = count(a, left, right, leftCount);
        //   int rightNum = count(a, left, right, rightCount);
        //
        //   if(leftNum > (right - left + 1) / 2){
        //     return leftCount;
        //   } else if(rightNum > (right - left + 1) / 2){
        //     return rightCount;
        //   } else { return -1; }
        // } else {
        //   return -1;
        // }
        if(a.length==1){
            return a[0];
        }
        long prev = a[0];
        int count = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] == prev){
                count++;
                if(count > a.length/2) return a[i];
            } else {
                count=1;
                prev = a[i];
            }
        }
        return -1;
    }

    private static long getMajorityElementNaive(long[] a, int left, int right) {
        for(int i = 0; i < a.length; ++i){
          int count = 0;
          for(int j = 0; j < a.length; ++j){
            if(a[i] == a[j]){
              count++;
            }
          }
          if(count > (a.length / 2)) {
            return a[i];
          }
        }
        return -1;
    }

    private static int count(long[] a, int left, int right, long e){
      int count = 0;
      for(int i = left; i < right; ++i){
        if(a[i] == e){
          count++;
        }
      }
      return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        // while(true){
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
          // long na = getMajorityElementNaive(a, 0, a.length - 1);
          // long ta = getMajorityElementNaive(a, 0, a.length - 1);
          // if(na == ta){
          //   System.out.println("DONE!");
          // } else {
          //   System.out.println("na:" + na + ", a:" + a);
          //   for(int i = 0; i < a.length; ++i){
          //       System.out.print("\ta[i]:" + a[i] + " ");
          //   }
          //   break;
          // }
        // }
        if (getMajorityElement(a, 0, a.length - 1) != -1L) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
          return Long.parseLong(next());
        }
    }
}
