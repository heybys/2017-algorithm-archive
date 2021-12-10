import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1006 로봇
public class Main {
	static int N;
	static int M;
	static int Map[][];
	static int visit[][][];
	static Scanner scan = new Scanner(System.in);
	static Point sp;
	static Point dp;
	static Queue<Point> que = new LinkedList<Point>();
	
	public static void main(String[] args) {// 
		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		visit = new int[N][M][4];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				Map[i][j] = scan.nextInt();
			}
		}
		sp = new Point(scan.nextInt()-1, scan.nextInt()-1, scan.nextInt()-1);
		dp = new Point(scan.nextInt()-1, scan.nextInt()-1, scan.nextInt()-1);
		///////////////////init
		
		exe();
		
	}
	public static void exe(){ //
		que.add(sp); // 시작점 저장.
		visit[sp.x][sp.y][sp.d] = 1; // 방문체크.
		int order = 0; // BFS가 몇번호출되는지 세기위한.
		
		while(BFS()){ // 탈출~
			order++;
		}
		System.out.println(order+1);
	}
	public static boolean BFS(){ // 뭘처리하는애? 큐에있는 내용물들을 하나씩 꺼내서 그녀석으로부터 '5가지의 order를 적용한 새로운놈'만드는 작업
		int dir1[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};// 0동 1서 2남 3북
		int dir2[][] = {{0,2}, {0,-2}, {2,0}, {-2,0}};// 0동 1서 2남 3북
		int dir3[][] = {{0,3}, {0,-3}, {3,0}, {-3,0}};// 0동 1서 2남 3북
		
		boolean flag = false; // 큐에 새로 유입된게 있으면 true바뀌어서 BFS가 한번더 호출되야함을 외부에 알려준다.신호준다~
		int sz = que.size();
		
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			boolean block = false;
			
			for(int j=1;j<6;j++){
				Point np = null;
				if(j==1){
					np = new Point(p.x+dir1[p.d][0], p.y+dir1[p.d][1], p.d);
				}else if(j==2){
					if(block == false){
						np = new Point(p.x+dir2[p.d][0], p.y+dir2[p.d][1], p.d);
					}
				}else if(j==3){
					if(block==false){
						np = new Point(p.x+dir3[p.d][0], p.y+dir3[p.d][1], p.d);
					}
				}else if(j==4){ // 이때는 그냥 왼쪽
					np = new Point(p.x, p.y, turnLeft(p.d));
				}else{ // 이때는 그냥 오른쪽
					np = new Point(p.x, p.y, turnRight(p.d));					
				}
				///////////////////////////////새로운놈 만들어따...
				// 이제 요 새로운 놈이 큐에 새로 저장해도 되는놈인지??판단을 해보자~~~~~
				
				if(np != null){
					if(np.x==dp.x && np.y==dp.y && np.d==dp.d){
						return false;
					}
					if(isOK(np.x, np.y, np.d)){ // 여기서는 벽이여도 빠꾸, 재방문이여도 빠구 둘다 빠꾸.
						que.add(np); // 큐에 저장도 하고~
						visit[np.x][np.y][np.d] = 1; // 방문체크도하고~
						flag = true; // BFS한번더돌려야되~~~~외부로 알려주고~
					}else{ // 빠꾸먹으면 여기로 왔어.
						//재방문빠꾸일 때는 
						if(isBlock(np.x, np.y, np.d)){// 벽빠꾸.
							block = true;			
						}
					}
				}
				// 이대로 끝내면, 1칸이동이 불가능한데 2칸 3칸을 이동하는 벽넘기 기능이 생겨버려...
				// 그래서 만약 1칸이동이 실패(원인:벽)일떄, 2칸 3칸은 아예 np를 할당하지말자~(idea 1)
				// 앞서 하던 작업에서 문제가 발생해서 이후 작업에 신호를 줄꺼야.
				
			}
		}
		
		return flag;
	}
	public static boolean isOK(int x, int y, int d){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else if(Map[x][y] == 1){ // 벽이라서 안대
			return false;
		}else if(visit[x][y][d]==1){ // 이미 방문한곳이라 안되.
			return false;
		}else{
			return true;
		}
	}
	public static boolean isBlock(int x, int y, int d){
		if(x<0 || x>=N){
			return true;
		}else if(y<0 || y>=M){
			return true;
		}else if(Map[x][y] == 1){ // 벽이라서 안대
			return true;
		}else{
			return false;
		}
	}
	public static int turnLeft(int d){ // d라는 방향 인덱스를 주면~
		if(d==0){ // 동쪽이야
			return 3;
		}else if(d==1){ // 서쪽이면
			return 2;
		}else if(d==2){
			return 0;
		}else{ //3
			return 1;
		}
	}
	public static int turnRight(int d){ // d라는 방향 인덱스를 주면~
		if(d==0){ // 동쪽이야
			return 2;
		}else if(d==1){ // 서쪽이면
			return 3;
		}else if(d==2){ // 남쪽이면
			return 1;
		}else{ //3
			return 0;
		}
	}
}
class Point{
	int x;
	int y;
	int d;
	public Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

//생각먼저. 1. 시작점을 큐에 넣는다. 2. BFS에서 큐를 한번 처리한다.(이 과정에서 큐안에 새로운 정보가 갱신될것) 3. 그러면 이 BFS를 다른 함수에서 While로 돌린다.
//BFS내부에서 문제에서 주어진 종료조건(예를들면 도착점에 도착했다던가...)에 부합되면 false를 리턴시켜서 While을 탈출한다.

















//		boolean flag = false; // flag가 언제 true로 바뀌냐면...Que안에 새로운 좌표가 유입될떄.--> 이게 갖는 의미가 뭐냐면.
//		BFS가 실행될때, 젤먼저하는게 머임?
//				Que사이즈 체크하는거지.그말은 즉BFS라는 함수는 Que안에 내용물이 있을때 그 내용물을 처리하는 함수.
//				
//				근데 Que안에 새로운 좌표가 계속 유입이되.---> BFS라는 함수가 계속 호출되야한다는 의미.
//				근데 새로운 좌표가 하나도 유입이 안되면 flag가 계속 false로 남아있겟네.
//				그말은 즉, BFS함수가 더이상 호출될 필요가 없지.