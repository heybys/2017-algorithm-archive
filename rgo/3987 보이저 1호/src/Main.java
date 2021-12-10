import java.util.Scanner;

// 3987 보이저 1호
public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N;
	static int M;
	static int Map[][];
	static int sx, sy;
	static int visit[][][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		init();
//		printMap();
		exe();
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
	public static int calDir(int x, int y, int d){
		if(Map[x][y] == 2){
			if(d==0){
				return 1;
			}else if(d==1){
				return 0;
			}else if(d==2){
				return 3;
			}else{
				return 2;
			}
		}else if(Map[x][y] == 3){
			if(d==0){
				return 3;
			}else if(d==1){
				return 2;
			}else if(d==2){
				return 1;
			}else{
				return 0;
			}			
		}else{
			return d;
		}
	}
	public static void exe(){
		int max = 0;
		int maxD = 0;
		for(int i=0;i<4;i++){
			int res = DFS(sx,sy,i);
			System.out.println(res);
			if(res>max){
				max = res;
				maxD = i;
			}else if(res<0){
				maxD = i;
				if(maxD==0){
					System.out.println("U");
				}else if(maxD==1){
					System.out.println("R");
				}else if(maxD==2){
					System.out.println("D");			
				}else{
					System.out.println("L");
				}
				System.out.println("Voyager");
				return;
			}
		}
		
		if(maxD==0){
			System.out.println("U");
		}else if(maxD==1){
			System.out.println("R");
		}else if(maxD==2){
			System.out.println("D");			
		}else{
			System.out.println("L");
		}
		System.out.println(max);
	}
	public static int DFS(int x, int y, int d){
		int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // U R D L
		
		int snow = 1;
		
		d = calDir(x, y, d);
		
		if(visit[x][y][d]==1){ // 무한 전파 // voyager출력.
			return N*M*5*(-1);
		}else{ // 방문체크.
			visit[x][y][d] = 1;
		}
		if(isArea(x+dir[d][0], y+dir[d][1])){
			snow += DFS(x+dir[d][0], y+dir[d][1],d);
		}
		return snow;
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else if(Map[x][y]==1){
			return false;
		}else{
			return true;
		}
	}
	public static void init(){
		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		visit = new int[N][M][4];
		
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<M;j++){
				char c = str.charAt(j);
				if(c=='.'){
					Map[i][j] = 0;
				}else if(c=='/'){
					Map[i][j] = 2;
				}else if(c=='\\'){
					Map[i][j] = 3;
				}else if(c=='C'){
					Map[i][j] = 1;
				}else{
					Map[i][j] = -1;
				}
			}
		}
		sx = scan.nextInt()-1;
		sy = scan.nextInt()-1;
		
	}

}
