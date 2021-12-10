import java.util.ArrayList;
import java.util.Scanner;

// 1824 스도쿠
public class Main {

	static int Map[][] = new int[9][9];
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Point> Points = new ArrayList<>();
	static int Nums[] = new int[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				Map[i][j] = scan.nextInt();
				if(Map[i][j] == 0){
					Point p = new Point(i,j);
					Points.add(p);
				}
			}
		}
		
		////////////////////////////////////////
		
		printMap();
		Point np = new Point(3,3);
		checker(np);
		
		printNums();
		printMap();
		
	}
	public static void exe(){
		int start = 1;
		
	}
	public static void explore(){
		
	}
	public static boolean checker(Point p){
		
		boolean flag = false;
		
		initNums();
		sectorCheck(p);
		rowCheck(p);
		colCheck(p);
		
		for(int i=1;i<Nums.length;i++){
			if(Nums[i]==0){
				Map[p.x][p.y] = i; // 1213121
				flag = true;
			}
		}
		return flag;
		
	}
	public static void initNums(){
		for(int i=0;i<10;i++){ // Nums 초기화
			Nums[i] = 0;
		}		
	}
	public static void colCheck(Point p){
		for(int i=0;i<9;i++){
			Nums[Map[i][p.x]] = 1;
		}
	}
	public static void rowCheck(Point p){
		for(int i=0;i<9;i++){
			Nums[Map[p.x][i]] = 1;
		}
	}
	public static void sectorCheck(Point p){
		int a = p.x - (p.x%3);
		int b = p.y - (p.y%3);
		
		for(int i=a;i<a+3;i++){
			for(int j=b;j<b+3;j++){
				Nums[Map[i][j]] = 1;
			}
		}
	}
	
	public static void printNums(){
		for(int i=0;i<10;i++){
			System.out.print(Nums[i]+" ");
		}
		System.out.println();
	}
	public static void printMap(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
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