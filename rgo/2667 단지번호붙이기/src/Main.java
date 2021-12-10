import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2667 단지번호붙이기

public class Main {

	static Scanner scan = new Scanner(System.in);
	static int N;
	static int Map[][];
	static int visit[][];
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static Queue<Point> que = new LinkedList<Point>();
	static int localSize = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = scan.nextInt();
		Map = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<N;j++){
				Map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

//		globalSearch();
		globalSearch2();
		
		Collections.sort(al);
		
		int sz = al.size();
		System.out.println(sz);
		
		for(int i=0;i<sz;i++){
			System.out.println(al.get(i));
		}
	}
	public static void globalSearch2(){ // BFS용 글로벌 서치
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j] == 0 && Map[i][j] == 1){
					localSearch(i, j);
				}
			}
		}
	}
	public static boolean BFS(){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		int sz = que.size(); // 현재 큐사이즈 확인
		boolean flag = false; // 현재 BFS함수 내에서 새로 유입된 좌표가 있으면 true.
		
		for(int i=0;i<sz;i++){ // 현재 큐사이즈만큼 좌표 꺼내기
			Point p = que.poll();
			for(int j=0;j<4;j++){ // 꺼내온 좌표로 부터 4방향 탐색
				Point np = new Point(p.x+dir[j][0], p.y+dir[j][1]); // j방향의 새로운 좌표생성.
				if(isArea(np.x, np.y)){ // 만약 j방향 좌표로 이동가능하다면!!!
					que.add(np);
					localSize++; // 로컬사이즈 증가
					visit[np.x][np.y] = 1; // 방문체크
					flag = true; // 새로 유입된 변수가 있으니 true!
				}
			}
		}
		return flag;
	}
	public static void localSearch(int x, int y){
		
		que.add(new Point(x,y));
		localSize++;
		visit[x][y] = 1;
		
		while(BFS()){ // 모든 로컬탐색이 끝날때까지(새로 유입된 좌표가 없을때까지) 반복호출.
			
		}
		al.add(localSize); // 로컬사이즈 저장.
		localSize = 0; // 로컬 사이즈 초기화.
		que.clear(); // que재사용을 위해 초기화 -> 하지만 while에서 새로 유입된 좌표가 없으니 이미 비어져있을것이므로 생략가능
	}
	public static void globalSearch(){
		int res = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j]==0 && Map[i][j] ==1){
					res = DFS(i,j);
					al.add(res);
				}
			}
		}
	}
	public static int DFS(int x, int y){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		int snow = 1;
		visit[x][y] = 1;
		
		for(int i=0;i<4;i++){
			Point np = new Point(x+dir[i][0], y+dir[i][1]);
			if(isArea(np.x, np.y)){ // 만약에 새 좌료가 방문안했고, 단지내라면
				snow += DFS(np.x, np.y); // 방문
			}
		}
		
		return snow;
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	public static void printVisit(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else if(visit[x][y] == 1){
			return false;
		}else if(Map[x][y] == 0){
			return false;
		}else{
			return true;
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