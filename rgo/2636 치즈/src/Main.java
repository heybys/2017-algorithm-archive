import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2636 치즈

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N; // 세로
	static int M; // 가로
	static int Map[][]; // 맵
	static int visit[][]; // 방문체크
	static Queue<Point> que = new LinkedList<Point>();
	static ArrayList<Point> rmList = new ArrayList<>();
	static int old;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				Map[i][j] = scan.nextInt();
			}
		}

		exe();
	}
	public static boolean removeCheese(){
		int sz = rmList.size();
		boolean chng = false;
		for(int i=0;i<sz;i++){
			Point p = rmList.get(i);
			Map[p.x][p.y] = 0;
			chng = true;
		}
		return chng;
	}
	public static void exe(){
		int cnt = 0;
//		printMap();
		while(AirSearch()){
//			printMap();
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(old);
	}
	public static boolean AirSearch(){
		
		boolean chng = false;
		visit = new int[N][M]; // Air탐색을 할 때, 방문체크 초기화.
		
		que.add(new Point(0,0));
		visit[0][0] = 1;
		
		while(BFS()){
			
		}
		
		if(removeCheese()){ // 치즈 제거
			old = rmList.size();
			rmList.clear();// Air와 맞닿는 치즈 저장소 초기화.
			chng = true;
		}
		return chng;
	}
	public static boolean BFS(){
		int sz = que.size();
		int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		boolean chng = false;
		
		for(int i=0;i<sz;i++){ 
			Point p = que.poll(); // 좌표 추출
			for(int j=0;j<4;j++){
				Point np = new Point(p.x+dir[j][0], p.y+dir[j][1]); // 새로 이동할 좌표
				if(isAir(np.x, np.y)){ // 이동 가능한지 확인
					que.add(np); // 좌표 저장
					visit[np.x][np.y] = 1; // 방문 체크
					chng = true; // 변화 확인
				}
			}
		}
		return chng;
	}
	public static boolean isAir(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){ 
			return false;
		}else if(visit[x][y] == 1){ // 이미 방문한 곳
			return false;
		}else if(Map[x][y] == 1){ // 치즈
			if(visit[x][y] == 0){
				visit[x][y] = 1;
				rmList.add(new Point(x,y));
			}
			return false;
		}else{
			return true;
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}
	
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
