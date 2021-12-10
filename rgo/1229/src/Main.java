import java.util.Scanner;

public class Main {
	static int w;
	static int h;
	static int t;
	static int sx;
	static int sy;
	static int D;
	static Scanner scan = new Scanner(System.in);
	static int map[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		w = scan.nextInt()+1;
		h = scan.nextInt()+1;
		sy = scan.nextInt();
		sx = scan.nextInt();
		D = 0;
		t = scan.nextInt();
		
		map = new int[h][w];
		map[sx][sy] = 1;
		
//		printMap();
		exe();
		System.out.println(sy+" "+sx);
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=h){
			return false;
		}else if(y<0 || y>=w){
			return false;
		}else{
			return true;
		}
	}
	public static int angleChange(int x, int y, int dir){ //   ↘0  ↙1   ↖2  ↗3
		int d = dir;
		if(isArea(x, y)){
			if(x==0){ // 천장에 부딪히면, 
				if(d==3){
					d = 0;
				}else if(d==2){
					d = 1;
				}
			}else if(x==h-1){
				if(d==1){
					d = 2;
				}else if(d==0){
					d = 3;
				}
			}
			if(y==0){
				if(d==1){
					d = 0;
				}else if(d==2){
					d = 3;
				}
			}else if(y==w-1){
				if(d==0){
					d = 1;
				}else if(d==3){
					d = 2;
				}
			}
		}
		return d;
	}
	public static void oneStep(){
		int dir[][] = { {1,1}, {1,-1}, {-1,-1}, {-1,1} };
		if(!isArea(sx+dir[D][0], sy+dir[D][1])){
			D = angleChange(sx, sy, D);
		}
		map[sx][sy] = 0;
		sx = sx+dir[D][0];
		sy = sy+dir[D][1];
		map[sx][sy] = 1;
//		System.out.println(sy+" "+sx);
	}
	public static void exe(){
		for(int i=0;i<t;i++){
//			System.out.println("-"+i+"-");
			oneStep();
//			printMap();
		}
	}
	public static void printMap(){
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
class Point{
	int x;
	int y;
	int dir;
}
