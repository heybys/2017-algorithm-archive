import java.util.Scanner;

public class Main {

	static int T;
	static int N;
	static int M;
	static int Map[][];
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		T = scan.nextInt();
		
		for(int t=0;t<T;t++){///////////////////////////////
			
			
			N = scan.nextInt();
			M = scan.nextInt();
			Map = new int[N][M];
			for(int i=0;i<N;i++){
				String str = scan.next();
				for(int j=0;j<M;j++){
					char c = str.charAt(j);
					if(c=='.'){
						Map[i][j] = 0;
					}else if(c=='x'){
						Map[i][j] = 1;
					}else{
						System.out.println("error!");
					}
				}
			}
			printMap();
			
			
			
		}///////////////////////////////////////////////////
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-=-=-=-=-=-=-=-=-=-=-");
	}

}
