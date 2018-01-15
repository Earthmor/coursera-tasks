import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      int steps = data.length / 2;
      for (int i = steps; i >= 1; --i) {
        siftDown(i);
      }
    }

    private void siftDown(int i){
      int maxIndex = i;
      int left = left(i);
      int size = data.length;
      if(left <= size && data[left-1] < data[maxIndex-1]){
        maxIndex = left;
      }
      int right = right(i);
      if(right <= size && data[right-1] < data[maxIndex-1]){
        maxIndex = right;
      }
      if(i != maxIndex){
        swaps.add(new Swap(i-1, maxIndex - 1));
        int tmp = data[i-1];
        data[i-1] = data[maxIndex-1];
        data[maxIndex-1] = tmp;
        siftDown(maxIndex);
      }
    }

    private int parent(int i){
      return i/2;
    }

    private int left(int i){
      return 2*i;
    }

    private int right(int i){
      return 2*i+1;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
