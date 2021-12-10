import java.util.Scanner;

public class Main {
	static int N;
	static int Table[];
	static Scanner scan = new Scanner(System.in);
	static int D[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		Table = new int[N+1];
		D = new int[N+1][3];
		Table[0] = 0;
		for(int i=1;i<N+1;i++){
			Table[i] = scan.nextInt();
		}
		D[0][0] = 0;
		D[0][1] = 0;
		D[0][2] = 0;
		
		for(int i=1;i<N+1;i++){
			D[i][0] = D[i-1][2];
			D[i][1] = D[i-1][0]+Table[i];
			D[i][2] = D[i-1][1]+Table[i];
		}
		int max = D[N][0];
		if(D[N][1]>max){
			max = D[N][1];
		}
		if(D[N][2]>max){
			max = D[N][2];
		}
		System.out.println(D[N][0]);
		System.out.println(D[N][1]);
		System.out.println(D[N][2]);
		System.out.println(max);
	}

}
