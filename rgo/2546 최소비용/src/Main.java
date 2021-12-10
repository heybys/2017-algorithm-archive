// 2546 최소비용
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static int n;
	static int m;
	static Vector<Integer> v[];
	static Queue<Integer> que = new LinkedList<Integer>();
	static int c[][];
	static int visit[];
	static int S, T;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		n = scan.nextInt();
		S = 1;
		T = scan.nextInt()+1;
		m = scan.nextInt();
		
		v = new Vector[n+10];
		c = new int[n+10][n+10];
		visit = new int[n+10];
		
		for(int i=1;i<=n+9;i++){
			v[i] = new Vector<Integer>();
			visit[i] = 987654321;
		}
		
		for(int i=0;i<m;i++){
			int from = scan.nextInt()+1;
			int to = scan.nextInt()+1;
			int cost = scan.nextInt();
			
			if(!v[from].contains(to)){
				v[from].add(to);				
			}
//			v[to].add(from);
			if(c[from][to]!=0 && c[from][to] > cost){
				c[from][to] = cost;
			}else{
				c[from][to] = cost;				
			}
//			c[to][from] += cost;
		}
		
//		S = scan.nextInt();
		visit[S] = 0;
		
		exploreNode();
	}
	public static void exploreNode(){
		que.add(S);
		
		while(nextEdge()){
			
		}
		System.out.println(visit[T]);
	}
	
	public static boolean nextEdge(){
		int sz = que.size();
		boolean chng = false;
		
		for(int i=0;i<sz;i++){
			int cur = que.poll(); // 현재 지점 추출
			for(int j=0;j<v[cur].size();j++){ // 현재지점과 연결된 노드
				int nxt = v[cur].get(j); // 연결노드 추출
				if(visit[nxt] > visit[cur]+c[cur][nxt]){ // 연결노드에 방문을 안했으면 방문
					visit[nxt] = visit[cur]+c[cur][nxt];
					que.add(nxt);
					chng = true;
				}
			}
		}
		return chng;
	}

}