import java.util.ArrayList;
import java.util.Scanner;

// 10875 뱀

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	static int L;
	static int N;
	static ArrayList<Line> al = new ArrayList<>();
	
	static int D = 0;
	static Point hd = new Point(L,L);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L = scan.nextInt();
		N = scan.nextInt();
		
		int dir[][] = { {0,1}, {1,0}, {0,-1}, {-1,0} };
		
		
		for(int i=0;i<N;i++){
			int sec = scan.nextInt();
			char c = scan.next().charAt(0);
			
		}
		Line l = new Line(hd,new Point(hd.x+(2*L+1)*dir[D][0], hd.y+(2*L+1)*dir[D][1]));
		
		
		
	}
	public static Point getCrossPoint(Line nl, Line ol){
		int x,y;
		
		int nlType = typeCheck(nl);
		int olType = typeCheck(ol);
		if(nlType!=olType){
			if(nlType==1){
				x = nl.p1.x;
				y = ol.p1.y;
			}else{
				x = ol.p1.x;
				y = nl.p1.y;
			}
		}else{
			x = 
		}
		Point p = new Point(x,y);
		
		return p;
	}
	public static int typeCheck(Line l){
		if(l.p1.x == l.p2.x){
			return 1;//가로형
		}else if(l.p1.y==l.p2.y){
			return 2;//세로형
		}else{
			return 3; // 문제있으..
		}
	}
}
class Line{
	Point p1;
	Point p2;
	public Line(Point p1, Point p2) {
		this.p1 = new Point(p1.x,p1.y);
		this.p2 = new Point(p2.x,p2.y);
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