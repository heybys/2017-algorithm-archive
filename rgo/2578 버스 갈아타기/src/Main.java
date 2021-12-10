import java.util.Scanner;

// 2578 버스갈아타기
public class Main {
	
	static int M, N;
	static Scanner scan = new Scanner(System.in);
	static int K;
	static int Map[][][];
	static int Visit[][];
	static Point sp, ep;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M = scan.nextInt()+1;
		N = scan.nextInt()+1;
		K = scan.nextInt()+1;
		
		Map = new int[M][N][K];
		Visit = new int[M][N];
		
		for(int i=1;i<=K;i++){
			int k = scan.nextInt();
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			Point p1, p2;
			if(x1+y1 <= x2+y2){
				p1 = new Point(x1, y1);
				p2 = new Point(x2, y2);				
			}else{
				p1 = new Point(x2, y2);
				p2 = new Point(x1, y1);								
			}
			setLine(p1, p2, k);
		}
		sp = new Point(scan.nextInt(), scan.nextInt());
		ep = new Point(scan.nextInt(), scan.nextInt());
	}
	public static void setLine(Point p1, Point p2, int k){
		for(int i=p1.x; i<=p2.x;i++){
			for(int j=p1.y;j<=p2.y;j++){
				Map[i][j][k] = 1;
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