import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

// 1298 노트북의 주인을 찾아서

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N; // N*2 +2 = 노드갯수
	static int M; // 엣지갯수
	static Vector<Integer> v[];
	static int c[][];
	static int f[][];
	static int S;
	static int T;
	static Queue<Integer> que = new LinkedList<Integer>();
	static int prev[];
	static int INF = 987654321;
	static int TOTAL = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		S = 0;
		T = N*2+1;
		
		v = new Vector[N*2+2];
		prev = new int[N*2+2];
		
		c = new int [N*2+2][N*2+2];
		f = new int [N*2+2][N*2+2];
		
		for(int i=0;i<T+1;i++){ // N=5, 0 1~5 6~10 11
			v[i] = new Vector();
		}
		for(int i=0;i<T+1;i++){ // N=5, 0 1~5 6~10 11
			if(i>S && i<N+1){ // 1~5
				v[S].add(i);
				v[i].add(S);
				c[S][i] = 1;
			}
			if(i>N && i<T){ // 6~10
				v[i].add(T);
				v[T].add(i);
				c[i][T] = 1; // 
			}
		}
		
		for(int i=0;i<M;i++){
			int a = scan.nextInt();
			int b = scan.nextInt()+N;
			v[a].add(b);
			v[b].add(a);
			c[a][b] = 1;
		}
		flowing();
	}
	public static void flowing(){
		while(checkRoute()){
		}
		System.out.println(TOTAL);
	}
	public static boolean checkRoute(){
		for(int i=0;i<N*2+2;i++){
			prev[i] = -1;
		}
		que.clear();
		que.add(S);
		
		while(nextEdge()){
			
		}
		if(prev[T]==-1){ // 경로 탐색실패
			return false;
		}
		
		int flow = INF;
		for(int i = T; i != S; i = prev[i]){
			flow = Math.min(flow, c[prev[i]][i]-f[prev[i]][i]);
		}
		for(int i = T; i != S; i = prev[i]){
			f[prev[i]][i] += flow;
			f[i][prev[i]] -= flow;
		}
		
		TOTAL += flow;
		
		return true;
	}
	public static boolean nextEdge(){
		
		int sz = que.size();
		boolean chng = false;
		
		for(int i=0;i<sz;i++){
			int cur = que.poll();
			for(int j=0;j<v[cur].size();j++){
				int nxt = v[cur].get(j);
				if(prev[nxt] == -1){ // 만약 nxt에 이동경로 체크가 안되어있으면
					if(c[cur][nxt] - f[cur][nxt] > 0){ // 엣지로 flow할 수 있는 여유가 있으면
						prev[nxt] = cur;
						que.add(nxt);
						chng = true;
						if(nxt==T){
							return false;
						}
					}					
				}
			}
		}
		
		return chng;
	}

}
