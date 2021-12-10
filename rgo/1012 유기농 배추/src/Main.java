import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int T;
	static int N;
	static int M;
	static int K;
	static int Map[][];
	static Scanner scan = new Scanner(System.in);
	static Queue<Point> que = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = scan.nextInt();
		
		for(int t=0;t<T;t++){
			M = scan.nextInt();
			N = scan.nextInt();
			Map = new int[N][M];
			K = scan.nextInt();
			
			for(int i=0;i<K;i++){
				int m = scan.nextInt();
				int n = scan.nextInt();
				Map[n][m] = 1;
			}
			//////////////////////////////////////set.
			globalSearch();
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	public static void globalSearch(){
		int label = 2;
//		System.out.println("hi");
//		printMap();
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(Map[i][j] == 1){
					localSearch(i, j, label);
//					printMap();
					label++;
				}
			}
		}
		System.out.println(label-2);
	}
	public static void localSearch(int x, int y, int label){
		que.clear();
		Point sp = new Point(x,y);
		que.add(sp);
		Map[sp.x][sp.y] = label;
		while(oneStep(label)){
//			printMap();
		}
	}
	public static boolean oneStep(int label){
		boolean stepGo = false;
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		int sz = que.size();
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			for(int j=0;j<4;j++){
				Point np = new Point(p.x+dir[j][0],p.y+dir[j][1]);
				if(isArea(np.x, np.y)){
					que.add(np);
					Map[np.x][np.y] = label;
					stepGo = true;
				}
			}
		}
		return stepGo;
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else{
			if(Map[x][y] == 1){
				return true;
			}else{
				return false;
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
