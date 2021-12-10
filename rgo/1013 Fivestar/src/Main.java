import java.util.Scanner;

// 1013 Fivestar

public class Main {

	static Scanner scan = new Scanner(System.in);
	static int N;
	static int M;
	static int Map[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		
		init();

		exe();
		
		
		
	}
	public static void exe(){
		int total = 0;
		for(int i=0;i<N;i++){
			int lc = lineCounting(i);
			if(lc==-1){
				System.out.println(-1);
				return ;
			}else{
				total += lineCounting(i);				
			}
		}
		System.out.println(total);
	}
	public static int calStar(int cnt){
		int res = 0;
		res += cnt/5;
		if(cnt%5>0){
			res++;
		}
		return res;
	}
	public static int lineCounting(int n){
		boolean counting = false;
		int cnt = 0;
		int sum = 0;
		
		for(int i=0;i<M;i++){
			if(counting){
				if(Map[n][i] == 0){
					counting = false;
					if(cnt <= 4){
						return -1;
					}
					sum += calStar(cnt);
					cnt = 0;
				}else{
					cnt++;
				}
			}else{ // is not Counting
				if(Map[n][i] == 0){
				}else{
					cnt++;
					counting = true;
				}
			}
		}
		if(counting && cnt <=4){
			return -1;
		}
		sum += calStar(cnt);
//		System.out.println(sum);
		return sum;
	}
	public static void init(){
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<M;j++){
				char c = str.charAt(j);
				if(c == '.'){
					Map[i][j] = 0;
				}else if(c == '*'){
					Map[i][j] = 1;
				}else{
					System.out.println("Runtime Error!");
					return ;
				}
			}
		}		
	}

}
