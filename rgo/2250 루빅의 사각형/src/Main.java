import java.util.ArrayList;
import java.util.Scanner;

// 2250 루빅의 사각형


public class Main {

	static Scanner scan = new Scanner(System.in);
	static int Map[][] = new int[4][4];
	static int AnsMap[][] = new int[4][4];
	static ArrayList<record> al = new ArrayList<record>();
	static int min = 10;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		printMap();
		
		rowMove(3,3);
		printMap();
		
		colMove(3,3);
		printMap();
	}
	
	
	public static void DFS(int[][] map, int type, int order){
		
	}
	public static int[][] copyMap(int[][] sorc){
		int newMap[][] = new int[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				newMap[i][j] = sorc[i][j];
			}
		}
		return newMap;
	}
	
	
	
	public static void printMap(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void colMove(int col, int n){ // 2
		col -= 1;
		if(n==1){
			int t = Map[3][col];
			for(int i=2;i>=0;i--){
				Map[i+1][col] = Map[i][col];
			}
			Map[0][col] = t;
		}else if(n==2){
			int t = Map[2][col];
			int t2 = Map[3][col];
			Map[2][col] = Map[0][col];
			Map[3][col] = Map[1][col];
			Map[0][col] = t;
			Map[1][col] = t2;
		}else{
			colMove(col+1,n-1);
			colMove(col+1,n-2);
		}
	}
	public static void rowMove(int row, int n){ // 1
		row -= 1;
		if(n==1){
			int t = Map[row][3];
			for(int i=2;i>=0;i--){
				Map[row][i+1] = Map[row][i];
			}
			Map[row][0] = t;
		}else if(n==2){
			int t = Map[row][2];
			int t2 = Map[row][3];
			Map[row][2] = Map[row][0];
			Map[row][3] = Map[row][1];
			Map[row][0] = t;
			Map[row][1] = t2;
		}else{
			rowMove(row+1,n-1);
			rowMove(row+1,n-2);
		}
	}
	public static void input(){
		int s = 1;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				Map[i][j] = scan.nextInt();
				AnsMap[i][j] = s++;
			}
		}
	}
}
class record{
	int type;
	int order;
	int num;
	public record(int type, int order, int num) {
		super();
		this.type = type;
		this.order = order;
		this.num = num;
	}
}