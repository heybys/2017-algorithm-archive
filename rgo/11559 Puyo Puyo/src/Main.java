import java.util.ArrayList;
import java.util.Scanner;

//11559 Puyo Puyo

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static int N = 12;
	static int M = 6;
	static int Map[][] = new int[N][M];
	static int visit[][];

	static ArrayList<Point> buf = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		init();
		
		exe();
	}
	public static void exe(){
		int cnt = 0;
		while(globalSearch()){
			drop();
//			printMap();
			cnt++;
		}
		System.out.println(cnt);
	}
	public static void drop(){
		for(int i=0;i<M;i++){
			int pos = N-1;
			for(int j=N-1;j>=0;j--){
				if(Map[j][i]>0){
					Map[pos][i] = Map[j][i];
					if(pos!=j){
						Map[j][i] = 0;
					}
					pos--;
				}
			}
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		
	}
	public static boolean globalSearch(){
		visit = new int[N][M]; // 글로벌탐색을 하기 전 visit 초기화.
		boolean flag = false;
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(Map[i][j]>0 && visit[i][j]==0){ // 뿌요가 있고, 방문을 안했으면 시작점으로 선출.
					localSearch(i, j); // 해당 시작점으로 로컬탐색
					if(treatBuf()){ // 로컬탐색을 마친 후 buf의 좌표들이 4개 이상이면 터트리고, 방문표시.
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	public static void localSearch(int x, int y){
		int dir[][] = { {0,1}, {1,0}, {0,-1}, {-1,0} };
		int d = Map[x][y];
		
		visit[x][y] = 1;
		
		Point p = new Point(x,y);
		buf.add(p);
		
		for(int i=0;i<4;i++){
			if(isOK(x+dir[i][0], y+dir[i][1], d)){
				localSearch(x+dir[i][0], y+dir[i][1]);
			}
		}
	}
	public static boolean treatBuf(){
		int sz = buf.size();
		boolean flag = false;
		
		if(sz >= 4){
			for(int i=0;i<sz;i++){
				Point p = buf.get(i);
				Map[p.x][p.y] = 0;
			}
			flag = true;
		}
		buf.clear();
		return flag;
	}
	public static boolean isOK(int x, int y, int d){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else if(visit[x][y]==1){
			return false;
		}else if(Map[x][y]!=d){
			return false;
		}else{
			return true;
		}
	}
	public static void init(){
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<M;j++){
				char c = str.charAt(j);
				if(c=='.'){
					Map[i][j] = 0;
				}else if(c=='R'){
					Map[i][j] = 1;
				}else if(c=='G'){
					Map[i][j] = 2;
				}else if(c=='B'){
					Map[i][j] = 3;
				}else if(c=='P'){
					Map[i][j] = 4;
				}else{
					Map[i][j] = 5;					
				}
			}
		}
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