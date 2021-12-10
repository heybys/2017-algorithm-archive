import java.util.Scanner;

// 4963 ¼¶ÀÇ °³¼ö

public class Main {

	static int w;
	static int h;
	static Scanner scan = new Scanner(System.in);
	static int Map[][];
	static int visit[][];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while((w=scan.nextInt())>0 && (h = scan.nextInt())>0){
			Map = new int[h][w];
			visit = new int[h][w];
			
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					Map[i][j] = scan.nextInt();
				}
			}
			
			
			globalSearch();
		}

	}
	public static void globalSearch(){
		int cnt = 0;
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				if(Map[i][j]==1 && visit[i][j]==0){
					DFS(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static void DFS(int x, int y){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
		
		for(int i=0;i<8;i++){
			Point np = new Point(x+dir[i][0], y+dir[i][1]);
			if(isArea(np.x, np.y)){
				visit[np.x][np.y] = 1;
				DFS(np.x, np.y);
			}
		}
	}

	public static boolean isArea(int x, int y){
		if(x<0 || x>=h){
			return false;
		}else if(y<0 || y>=w){
			return false;
		}else if(Map[x][y]==0){
			return false;
		}else if(visit[x][y] == 1){
			return false;
		}else{
			return true;
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