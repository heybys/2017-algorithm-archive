import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int N;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C = scan.nextInt();
		R = scan.nextInt();
		
		N = scan.nextInt();
		
		
		exe();
		
	}
	public static void exe(){
		
		if(N>R*C){
			System.out.print(0);
			return ;
		}
		int lng = 2*R+2*C-4;
		int a, b;
		a = 1;
		b = a+lng-1;
		int cnt = 1;
		while(lng>0){
			if(a<=N && N<=b){
				break;
			}else{
				cnt++;
				lng -= 8;
				a = b+1;
				b = a+lng-1;
			}
		}
//		System.out.println(cnt);
		int sz = N-a;
		int minx = cnt;	
		int miny = cnt;
		int maxx = C-cnt+1;
		int maxy = R-cnt+1;
		int x = cnt;
		int y = cnt;
		boolean up = true;
//		System.out.println(sz);
		for(int i=0;i<sz;i++){
			if(up){
				if(y<maxy){
					y++;
				}else if(x<maxx){
					x++;
				}else{
					up = false;
					y--;
				}
			}else{
				if(y>miny){
					y--;
				}else{
					x--;
				}
			}
		}
		System.out.print(x+" "+y);
	}

}
