import java.util.Scanner;

// 1614 영식이의 손가락

public class Main {
	
	static long N;
	static long life;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		N = scan.nextInt();
		life = scan.nextInt();
		
		exe();
		
	}
	public static void exe(){
		if(N==1){
			long res = 0+life*8;
			System.out.println(res);
		}else if(N==2){
			long res;
			if(life%2==0){
				res = 1+life*4;
			}else{
				res = 1+(life-1)*4;
				res += 6;
			}
			System.out.println(res);
		}else if(N==3){
			long res = 2+life*4;
			System.out.println(res);
		}else if(N==4){
			long res;
			if(life%2==0){
				res = 3+life*4;
			}else{
				res = 3+(life-1)*4;
				res += 2;
			}
			System.out.println(res);
		}else{
			long res = 4+life*8;
			System.out.println(res);
		}
		
	}

}
