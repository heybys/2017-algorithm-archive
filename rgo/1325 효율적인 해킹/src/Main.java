import java.util.ArrayList;
import java.util.Scanner;

// 1325 효율적인 해킹

public class Main {
	
	static int N; // node 갯수
	static int M; // edge 갯수
	static Scanner scan = new Scanner(System.in);
	static Node node[]; // 각 노드를 저장.
	static int visit[]; // 각 노드를 시작점으로 탐색해가는 과정에서 노드 방문여부.
	
	static int res[]; // 각 노드를 시작점으로 했을 때, 총 해킹컴퓨터 갯수 저장.
	
	public static void main(String[] args) {
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		node = new Node[N+1]; 
		visit = new int[N+1];
		res = new int[N+1];
		
		for(int i=1;i<=N;i++){
			node[i] = new Node();
		}
		
		for(int i=0;i<M;i++){
			int A = scan.nextInt();
			int B = scan.nextInt();
			node[B].addNeigh(A);
		}
		
		
		
	}
	public static void dfs(int nd, int s){
		int sz = node[s].neigh.size(); // 현재 노드에서 이웃 몇명인지 확인.
		
		visit[nd] = 1; // 현재 노드를 방문했다는 표시.
		res[s] += 1; // 시작 노드
		
		for(int i=0;i<sz;i++){ // 이웃 명수만큼 탐색.
			int n = node[s].getNeigh(i); // 각 이웃을 GET.
			
			
		}
	}
	
}
class Node{
	
	ArrayList<Integer> neigh;

	public Node() {
		this.neigh = new ArrayList<Integer>();
	}
	public void addNeigh(int nei){
		neigh.add(nei);
	}
	public int getNeigh(int idx){
		return neigh.get(idx);
	}
	
}