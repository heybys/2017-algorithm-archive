package 쌩기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N = 5;
	static int map[][];
	static int visit[][];
	static Queue<Point> que = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		map = new int[N][N];
		visit = new int[N][N];
		
		
//		dfs(new Point(1,1));
		que.add(new Point(1,1)); // 초기 세팅하고. 
		visit[1][1] = 1;
		
		int cnt = 0;
		printMap();
		while(BFS()){
			cnt++;
			printMap();
		}
		
//		BFS();// 이 작업을 끝내고.
//		
//		  //리턴이 되고 현재 이시점. 4개들어가잇음.
//		
//		BFS(); // 16개 중에서 중복제거하고 남은 갯수만큼 들어가있당.
//		
//		BFS();
//		BFS();
//		BFS();
//		BFS();
//		BFS();
//		BFS();// 이 안에서는 que.add 한번도 호출이안되. --> false;
		
		
		
		
	}
	public static boolean BFS(){
		int sz = que.size();
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		
		boolean flag = false;
		
		for(int i=0;i<sz;i++){
			Point np = que.poll();// 좌표 뽑아서.
			for(int j=0;j<4;j++){ // 네방향으로 던지기.
				if(isMap(np.x+dir[j][0], np.y+dir[j][1])){ // 해당방향이 갈수 있다!면...
					que.add(new Point(np.x+dir[j][0],np.y+dir[j][1])); // 새로운 좌표를 큐안에 넣는다는 의민데, 그말은 즉, 
					flag = true;// 새롭게 이동할 수 있는 좌표가 들어왔구나~~알려줌.
					visit[np.x+dir[j][0]][np.y+dir[j][1]] = 1; // 해당ㅈ 좌표 방문체크.
				}
			}
		}
		
		return flag;
		
	}
	public static void dfs(Point p){
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		
		visit[p.x][p.y] = 1;
		printMap();//비짓확인하고. 출력해보겟음.
		
		for(int i=0;i<4;i++){ // 4방향이라서 4.
			//i = 0 동. 동으로 진행인데 isMap에서 false가 떳으니.  
			if(isMap(p.x+dir[i][0], p.y+dir[i][1])){ // 내가 보내려는 좌표로 갈수 있으면, !! 보내겟다.
				dfs(new Point(p.x+dir[i][0], p.y+dir[i][1])); // 1+0, 4+1 = 1,5
			}
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	public static boolean isMap(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else{
			if(visit[x][y] ==1){
				return false;
			}else{
				return true;
			}
		}
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}