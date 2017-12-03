import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(long[] a, int left, int right, long x) {
        if(right < left){
          return -1;
        }
        int mid = left + ((right - left) / 2);
        if(x == a[mid]){
          return mid;
        } else if(x < a[mid]){
          return binarySearch(a, left, mid-1, x);
        } else {
          return binarySearch(a, mid+1, right, x);
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        int m = scanner.nextInt();
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextLong();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, 0, a.length - 1, b[i]) + " ");
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
