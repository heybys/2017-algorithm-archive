import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 두 개의 네비게이션
public class Main {

	static Scanner scan = new Scanner(System.in);
	static int N;
	static int M;
	
	static Node node[];
	static Queue<Node> que = new LinkedList<Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		M = scan.nextInt();
		node = new Node[N+1];
		for(int i=1;i<=N;i++){
			node[i] = new Node(i);
		}
		for(int i=0;i<M;i++){
			int A = scan.nextInt();
			int B = scan.nextInt();
			int P = scan.nextInt();
			int Q = scan.nextInt();
			node[A].addAndroid(node[B], P);
			node[A].addIphone(node[B], Q);
		}
		
		
		que.add(node[1]);
	}
	public static void dijkstra(){
		int sz = que.size();
		
		for(int i=0;i<sz;i++){
			Node n = que.poll();
			int nSz = n.edge.size();
			for(int j=0;j<nSz;j++){
				Node getN = n.edge.get(j);
				que.add(getN);
			}
		}
	}
	
}
class Node{
	int n;
	ArrayList<Node> edge;
	Hashtable<Integer, Integer> android; // Key, Value
	Hashtable<Integer, Integer> iphone; // Key, Value

	public Node(int n) {
		this.n = n;
		this.edge = new ArrayList<Node>();
		this.android = new Hashtable<Integer, Integer>();
	}
	public void addAndroid(Node neigh, int cost){
		if(!edge.contains(neigh)){
			edge.add(neigh);
			this.android.put(neigh.n, cost);
		}
	}
	public void addIphone(Node neigh, int cost){
		if(!edge.contains(neigh)){
			edge.add(neigh);
			this.iphone.put(neigh.n, cost);
		}
	}
}