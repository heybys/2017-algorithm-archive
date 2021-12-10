import java.util.Scanner;

// 1347 미로 만들기

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N;
	static String str;
	static int Map[][] = new int[101][101];
	static Point sp = new Point(50,50);
	static int d = 1; // 0 1 2 3 동 남 서 북
	
	static Point lu = new Point(50,50);
	static Point rd = new Point(50,50);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = scan.nextInt();
		
		str = scan.next();
		
		Map[sp.x][sp.y] = 1;
		for(int i=0;i<N;i++){
			char c = str.charAt(i);
			exe(c);
		}
		
		printMap();
		
		
		
	}
	public static void printMap(){
		for(int i=lu.x;i<rd.x+1;i++){
			for(int j=lu.y;j<rd.y+1;j++){
				if(Map[i][j]==1){
					System.out.print(".");
				}else if(Map[i][j]==0){
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
	public static void exe(char c){
		int dir[][] = {{0,1}, {1,0},{0,-1}, {-1,0}};
		
		if(c=='L'){
			turnLeft();
		}else if(c=='R'){
			turnRight();
		}else{ // 'F'
			sp.x = sp.x+dir[d][0];
			sp.y = sp.y+dir[d][1];
			if(d==2 || d==3){
				if(sp.x<lu.x){
					lu.x = sp.x;
				}
				if(sp.y<lu.y){
					lu.y = sp.y;
				}
			}else if(d==1 || d==0){
				if(sp.x>rd.x){
					rd.x = sp.x;
				}
				if(sp.y>rd.y){
					rd.y = sp.y;
				}
			}
			Map[sp.x][sp.y] = 1;
		}
		
	}
	public static void turnLeft(){
		d = (d+3)%4;
	}
	public static void turnRight(){
		d = (d+1)%4;
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