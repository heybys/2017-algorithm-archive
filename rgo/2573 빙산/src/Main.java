import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int Map[][];
	static int LabelMap[][];
	static Scanner scan = new Scanner(System.in);
	static Queue<Point> que = new LinkedList<Point>();
	static Queue<Point> labelque = new LinkedList<Point>();
	
	public static void main(String[] args) {
		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		LabelMap = new int[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				Map[i][j] = scan.nextInt();
				LabelMap[i][j] = Map[i][j];
				if(Map[i][j]>0){
					Point p = new Point(i,j);
					que.add(p);
//					al.add(p);
					LabelMap[i][j] = 1;
				}
			}
		}
		///////////////////////////////////////
		exe();
	}
	public static void exe(){
		int cnt = 0;
		boolean find = false;
		while(oneMelt()){
			cnt++;
			if(!globalSearch()){
				System.out.println(cnt);
				find = true;
				break;
			}
		}
		if(!find){
			System.out.println(0);
		}
	}
	public static boolean oneMelt(){
		int sz = que.size();
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		int res[] = new int[sz];
		
		boolean remain = false;
		
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			int a = Map[p.x][p.y];
			for(int j=0;j<4;j++){
				if(isSeaWater(p.x+dir[j][0], p.y+dir[j][1])){
					a--;
				}
			}
			if(a<=0){
				res[i] = 0;
			}else{
				res[i] = a;				
			}
			que.add(p);
		}
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			Map[p.x][p.y] = res[i];
			if(res[i]>0){
				que.add(p);
				LabelMap[p.x][p.y] = 1;
				remain = true;
			}else{
				LabelMap[p.x][p.y] = 0;
			}
		}
		return remain;
	}
	public static boolean globalSearch(){
		int cnt = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(LabelMap[i][j] ==1){
					Point p = new Point(i,j);
					labelque.add(p);
					LabelMap[p.x][p.y] = 0;
					localSearch();
//					printMap2();
					cnt++;
					if(cnt>1){
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void localSearch(){
		while(labeling()){
		}
	}
	public static boolean labeling(){
		int sz = labelque.size();
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		boolean goLabel = false;
		
		for(int i=0;i<sz;i++){
			Point p = labelque.poll();
			for(int j=0;j<4;j++){
				Point np = new Point(p.x+dir[j][0], p.y+dir[j][1]);
				if(isArea(np.x, np.y)){
					LabelMap[np.x][np.y] = 0;
					labelque.add(np);
					goLabel = true;
				}
			}
		}
		return goLabel;
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else{
			if(LabelMap[x][y]==0){
				return false;
			}else{
				return true;
			}
		}		
	}
	public static boolean isSeaWater(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else{
			if(Map[x][y]==0){
				return true;
			}else{
				return false;
			}
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----");
	}
	public static void printMap2(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(LabelMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----");
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