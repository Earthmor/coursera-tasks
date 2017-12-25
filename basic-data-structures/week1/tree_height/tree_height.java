import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
    
    class Node {
    	List<Node> childs = new ArrayList<Node>();
    	public void addChild(Node child) {
    		childs.add(child);
    	}
    	
    	public int height() {
    		int maxHeight = 0;
			for(int i = 0; i < childs.size(); ++i) {
				Node child = childs.get(i);
				int height = child.height();
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight + 1;
    	}
    }

	public class TreeHeight {
		int n;
		int parent[];
		Node tree;
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				nodes[i] = new Node();
			}
			for (int i = 0; i < n; i++) {
				int parentIndex = parent[i];
				if(parentIndex == -1) {
					tree = nodes[i];
				} else {
					nodes[parentIndex].addChild(nodes[i]);
				}
			}
		}

		int computeHeight() {
            return tree.height();
		}
	}

	public static void main(String[] args) throws IOException {
	    new Thread(null, new Runnable() {
	            public void run() {
	                try {
	                    new tree_height().run();
	                } catch (IOException e) {}
	            }
	        }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
