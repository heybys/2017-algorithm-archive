import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M;
	static int N;
	static int Map[][];
	static int Visit[][];
	static int rNum;
	static int rule[][];
	static Scanner scan = new Scanner(System.in);
	static Queue<Point> que = new LinkedList<Point>();
	
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
		Visit = new int[N][M];
		rNum = scan.nextInt();
		rule = new int[rNum][2];
		for(int i=0;i<rNum;i++){
			rule[i][0] = scan.nextInt();
			rule[i][1] = scan.nextInt();
		}
		for(int i=0;i<M;i++){
			if(Map[0][i]==1){
				Point np = new Point(0,i);
				Visit[0][i] = 1;
				que.add(np);
			}
		}
		////////////////////////////////////
		exe();
	}
	public static void exe(){
		int cnt = 0;	
		if(N==1 && !que.isEmpty()){
			System.out.print(1);
			return;
		}
		while(oneStep()){
			cnt++;
		}
		boolean succ=false;
		for(int i=0;i<M;i++){
			if(Visit[N-1][i]==1){
				succ = true;
			}
		}
		if(succ==true){
			System.out.print(cnt+1);			
		}else{
			System.out.print(-1);
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean oneStep(){
		int sz = que.size();
		boolean stepGo = false;
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			for(int j=0;j<rNum;j++){
				Point np = new Point(p.x+rule[j][0],p.y+rule[j][1]);
				if(check(np.x,np.y)){
					Visit[np.x][np.y] = 1;
					que.add(np);
					stepGo = true;
					if(np.x==N-1){
						return false;
					}
				}
			}
		}
		return stepGo;
	}
	public static boolean check(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else if(Map[x][y]==1){
			if(Visit[x][y]==1){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
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