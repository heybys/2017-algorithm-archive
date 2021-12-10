import java.util.Scanner;

// 12100 2048(easy)
public class Main {

	static int N;
	static Scanner scan = new Scanner(System.in);
	static int Map[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = scan.nextInt();
		Map = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				Map[i][j] = scan.nextInt();
			}
		}
		
		
		
	}
	public static void goMap(int d){ // 0 1 2 3 
		
	}
	public static void goRight(int row){
		int pos = N-1;
		for(int i=N-1;i>=0;i--){
			
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
		
	}

}
