import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static int T[][];
	static int N, H;
	static int D[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		H = scan.nextInt();
		T = new int[2][H+1];
		D = new int[2][H+1];
		for(int i=0;i<N;i++){
			int h = scan.nextInt();
			T[i%2][h]++;
		}
		D[0][1] = N/2;
		D[1][H] = N/2;
		for(int i=1;i<H;i++){
			D[0][i+1] = D[0][i]-T[0][i];
			D[1][H-i] = D[1][H-i+1]-T[1][i];
		}
		int min = N+1;
		int cnt = 0;
		for(int i=1;i<=H;i++){
			int a = D[0][i]+D[1][i];
//			System.out.print(a+" ");
			if(a<min){
				min = a;
				cnt = 1;
			}else if(a==min){
				cnt++;
			}else{ 	
				
			}
		}
//		System.out.println();
		System.out.println(min+" "+cnt);
		
	}

}
