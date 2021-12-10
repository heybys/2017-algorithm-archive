import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int Map[][];
	static Scanner scan = new Scanner(System.in);
	static int Factory[];
	static int P;
	static int Ycnt=0;
	static ArrayList<Integer> al = 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		Map = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				Map[i][j] = scan.nextInt();
			}
		}
		String YN = scan.next();
		for(int i=0;i<N;i++){
			if(YN.charAt(i)=='Y'){
				Factory[i] = 1;
				Ycnt++;
			}else if(YN.charAt(i)=='N'){
				Factory[i] = 0;
			}else{
			}
		}
		P = scan.nextInt();
		
	}

}
