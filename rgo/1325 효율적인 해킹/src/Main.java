import java.util.ArrayList;
import java.util.Scanner;

// 1325 ȿ������ ��ŷ

public class Main {
	
	static int N; // node ����
	static int M; // edge ����
	static Scanner scan = new Scanner(System.in);
	static Node node[]; // �� ��带 ����.
	static int visit[]; // �� ��带 ���������� Ž���ذ��� �������� ��� �湮����.
	
	static int res[]; // �� ��带 ���������� ���� ��, �� ��ŷ��ǻ�� ���� ����.
	
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
		int sz = node[s].neigh.size(); // ���� ��忡�� �̿� ������� Ȯ��.
		
		visit[nd] = 1; // ���� ��带 �湮�ߴٴ� ǥ��.
		res[s] += 1; // ���� ���
		
		for(int i=0;i<sz;i++){ // �̿� �����ŭ Ž��.
			int n = node[s].getNeigh(i); // �� �̿��� GET.
			
			
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