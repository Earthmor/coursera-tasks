import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {

    static class Worker {
        int index;
        long time;

        public Worker(int index, long time) {
            this.index = index;
            this.time = time;
        }
    }

    class WorkerHeap {

      Worker[] workers;
      int size = -1;
      int maxSize = -1;

      public WorkerHeap(int maxSize){
        this.maxSize = maxSize;
        this.workers = new Worker[maxSize];
      }

      public int parent(int i){
        return (i-1)/2;
      }

      public int left(int i){
        return i*2+1;
      }

      public int right(int i){
        return i*2+2;
      }

      public void siftUp(int i){
        while(i>0 && workers[parent(i)].time > workers[i].time){
            Worker tmp = workers[parent(i)];
            workers[parent(i)] = workers[i];
            workers[i] = tmp;
            i = parent(i);
        }
      }

      public void siftDown(int i){
        int maxIndex = i;
        int left = left(i);
        if(left <= size){
          if(workers[left].time == workers[maxIndex].time){
            if(workers[left].index < workers[maxIndex].index){
                maxIndex = left;
            }
          } else {
            if(workers[left].time < workers[maxIndex].time){
                maxIndex = left;
            }
          }
        }
        int right = right(i);
        if(right <= size){
          if(workers[right].time == workers[maxIndex].time){
            if(workers[right].index < workers[maxIndex].index){
                maxIndex = right;
            }
          } else {
            if(workers[right].time < workers[maxIndex].time){
                maxIndex = right;
            }
          }
        }
        if(i != maxIndex){
          Worker tmp = workers[i];
          workers[i] = workers[maxIndex];
          workers[maxIndex] = tmp;
          siftDown(maxIndex);
        }
      }

      public void insert(Worker w){
        if(size == maxSize){
          System.err.println("ERROR: size: ("+size+") must be smoller than maxSize("+maxSize+")");
        }
        size++;
        workers[size] = w;
        // siftUp(size);
      }

      public Worker getFreeWorkers(){
        return workers[0];
      }

      public void changePriority(int i, long t){
        long old = workers[i].time;
        workers[i].time = t;
        if(t < old) {
          siftUp(i);
        } else {
          siftDown(i);
        }
      }
    }

    private WorkerHeap workers;

    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        workers = new WorkerHeap(n);
        for(int i = 0; i < n; ++i){
          workers.insert(new Worker(i,0L));
        }
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
      assignedWorker = new int[jobs.length];
      startTime = new long[jobs.length];
      for (int i = 0; i < jobs.length; i++) {
          int duration = jobs[i];
          Worker bestWorker = workers.getFreeWorkers();

          assignedWorker[i] = bestWorker.index;
          startTime[i] = bestWorker.time;
          workers.changePriority(0, bestWorker.time + duration);
      }

        // TODO: replace this code with a faster algorithm.
        // assignedWorker = new int[jobs.length];
        // startTime = new long[jobs.length];
        // long[] nextFreeTime = new long[numWorkers];
        // for (int i = 0; i < jobs.length; i++) {
        //     int duration = jobs[i];
        //     int bestWorker = 0;
        //     for (int j = 0; j < numWorkers; ++j) {
        //         if (nextFreeTime[j] < nextFreeTime[bestWorker])
        //             bestWorker = j;
        //     }
        //     assignedWorker[i] = bestWorker;
        //     startTime[i] = nextFreeTime[bestWorker];
        //     nextFreeTime[bestWorker] += duration;
        // }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
