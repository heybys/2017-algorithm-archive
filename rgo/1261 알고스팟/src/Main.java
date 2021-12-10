import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 1261 알고스팟

public class Main {

	static int N;
	static int M;
	static int Map[][];
	static int visit[][];
	static Scanner scan = new Scanner(System.in);
//	static Queue<Point> que = new LinkedList<Point>();
	static PriorityQueue<Point> que = new PriorityQueue<>(new cmp());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M = scan.nextInt();
		N = scan.nextInt();
		Map = new int[N][M];
		visit = new int[N][M];
		
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<M;j++){
				Map[i][j] = str.charAt(j)-'0';
			}
		}
		
		exe();
	}
	public static void exe(){
		Point sp = new Point(0,0,1);
		visit[sp.x][sp.y] = 1;
		que.add(sp);
		
		while(BFS()){
			printVisit(); 
		}
		System.out.println(visit[N-1][M-1]-1);
	}
	public static void printVisit(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
		
	}
	public static boolean BFS(){
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		int sz = que.size();
		boolean flag = false;
		
		for(int i=0;i<sz;i++){ // 큐 내부의 좌표 모두 추출
			Point p = que.poll();
			
			for(int j=0;j<4;j++){ // 추출된 좌표와 벽부신갯수 정보로 추가 이동
				Point np = new Point(p.x+dir[j][0], p.y+dir[j][1], p.cr); // 방문할 지점 좌표계산
				if(isArea(np.x, np.y)){ // 맵내부면
					if(Map[np.x][np.y]==1){ // 해당 위치에 벽이 있는지 확인
						np.cr += 1; // 벽이 있으면 Crash값 +1
					}
					
					if(visit[np.x][np.y]==0){ // 해당 위치에 첫방문일 경우 무조건 방문
						visit[np.x][np.y] = np.cr; // 해당위치까지 오는데 부신 벽의 갯수로 방문체크
						que.add(np);
						flag = true;
					}else if(visit[np.x][np.y]>np.cr){ // 해당 위치에 벽을 더 적게 부시면서 온 경우
						visit[np.x][np.y] = np.cr; // 해당위치까지 오는데 부신 벽의 갯수로 방문체크
						que.add(np);
						flag = true;
					}
					
				}
			}
		}
		return flag;
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else{
			return true;
		}
	}
}
class Point{
	int x;
	int y;
	int cr;
	public Point(int x, int y, int cr) {
		this.x = x;
		this.y = y;
		this.cr = cr;
	}
}

class cmp implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		if(o1.cr>o2.cr){
			return 1;
		}else{
			return -1;
		}
	}
}