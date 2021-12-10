import java.util.Scanner;

public class Main {
	static int N;
	static int Table[];
	static Scanner scan = new Scanner(System.in);
	static int D[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		Table = new int[N+2];
		D = new int[N+2][2];
		Table[0] = 0;
		Table[1] = 0;
		for(int i=2;i<N+2;i++){
			Table[i] = scan.nextInt();
		}
		D[0][0] = 0;
		D[0][1] = 0;
		
		D[1][0] = 0;
		D[1][1] = 0;
		
		for(int i=2;i<N+2;i++){
			D[i][0] = D[i-1][1] + Table[i];
			if(D[i-2][0] > D[i-2][1]){
				D[i][1] = D[i-2][0]+Table[i];
			}else{
				D[i][1] = D[i-2][1]+Table[i];				
			}
		}

		if(D[N+1][0] > D[N+1][1]){
			System.out.println(D[N+1][0]);
		}else{
			System.out.println(D[N+1][1]);			
		}
	}

}
