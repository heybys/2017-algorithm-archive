import java.util.Scanner;

// 1063 킹
public class Main {

	static int N;
	static Scanner scan = new Scanner(System.in);
	static int Map[][] = new int[8][8]; // 

	static Point kp;
	static Point sp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = scan.next();
		kp = new Point((Integer.parseInt(Character.toString(str.charAt(1)))-8)*-1, str.charAt(0)-65);
		
		String str1 = scan.next();
		sp = new Point((Integer.parseInt(Character.toString(str1.charAt(1)))-8)*-1, str1.charAt(0)-65);
		
//		System.out.println(kp.x+" "+kp.y);
//		System.out.println(sp.x+" "+sp.y);
		Map[kp.x][kp.y] = 1;
		Map[sp.x][sp.y] = 2;
		
		N = scan.nextInt();
		
		for(int i=0;i<N;i++){
			String s = scan.next();
			int a = strToInt(s);
//			System.out.println(a);
			moveKing(a);
//			printMap();
		}
		printPoint();
		printPoint2();
	}
	public static void printPoint(){
		int x = kp.y+65;
		System.out.print((char)x);
		
		int y = kp.x*(-1)+8;
		System.out.println(y);
	}
	public static void printPoint2(){
		int x = sp.y+65;
		System.out.print((char)x);
		
		int y = sp.x*(-1)+8;
		System.out.println(y);
	}
	public static boolean moveKing(int d){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1}, {-1,-1}, {1,1}, {1,-1}};
		boolean move = false;
		
		Point np = new Point(kp.x+dir[d][0], kp.y+dir[d][1]);
		
		if(isArea(np.x,np.y)){
			// 이동
			if(Map[np.x][np.y]==2){
				if(!moveStone(d)){
					return false;
				}
			}
			Map[kp.x][kp.y] = 0;
			Map[np.x][np.y] = 1;
			kp.x = np.x;
			kp.y = np.y;
			move = true;
		}
		return move;
	}
	public static boolean moveStone(int d){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1}, {-1,-1}, {1,1}, {1,-1}};
		boolean  move = false;
		
		Point np = new Point(sp.x+dir[d][0], sp.y+dir[d][1]); 
		
		if(isArea(np.x,np.y)){
			// 이동
			Map[sp.x][sp.y] = 0;
			Map[np.x][np.y] = 2;
			sp.x = np.x;
			sp.y = np.y;
			move = true;
		}
		return move;
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=8){
			return false;
		}else if(y<0 || y>=8){
			return false;
		}else{
			return true;
		}
	}
	public static int strToInt(String str){
		if(str.equals("R")){
			return 0;
		}else if(str.equals("L")){
			return 1;
		}else if(str.equals("B")){
			return 2;
		}else if(str.equals("T")){
			return 3;
		}else if(str.equals("RT")){
			return 4;
		}else if(str.equals("LT")){
			return 5;
		}else if(str.equals("RB")){
			return 6;
		}else{ // LB
			return 7;
		}
	}
	public static void printMap(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(Map[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
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