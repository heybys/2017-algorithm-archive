import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int map[][];
	static Scanner scan = new Scanner(System.in);
	static Queue<Point> que;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		que = new LinkedList<Point>();
		map = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = scan.nextInt();
				if(map[i][j]==1){
					Point p = new Point(i,j);
					que.add(p);
				}
			}
		}
		
		printMap();
		globalNumbering();
		printMap();
		
	}
	public static void globalNumbering(){
		int plus = 1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]==1){
					Point p = new Point(i,j);
					localNumbering(p,plus);
					plus++;
				}
			}
		}
	}
	public static void localNumbering(Point sp, int plus){
		int dir[][] = { {1,0}, {0,1}, {-1,0}, {0,-1} };
		Queue<Point> qu = new LinkedList<>();
		qu.add(sp);
		map[sp.x][sp.y] += plus;
		int sz = qu.size();
		while(sz!=0){
			for(int i=0;i<sz;i++){
				Point p = qu.poll();
				for(int j=0;j<4;j++){
					if(isLocal(p.x+dir[j][0], p.y+dir[j][1])){
						Point np = new Point(p.x+dir[j][0],p.y+dir[j][1]);
						map[np.x][np.y] += plus;
						qu.add(np);
					}
				}
			}
		}
		
		
		
	}
	public static boolean isLocal(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else if(map[x][y]==0){
			return false;
		}else{
			if(map[x][y]==1){
				return true;
			}else{
				return false;
			}
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
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