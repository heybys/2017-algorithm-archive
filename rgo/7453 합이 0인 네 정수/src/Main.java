import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7453 합이 0인 네 정수
public class Main {

	static Scanner scan = new Scanner(System.in);
	static int N;
	static Queue<Long> que = new LinkedList<>();
	static long Map[][];
	static int idx=1;
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = scan.nextInt();
		Map = new long[N][4];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<4;j++){
				Map[i][j] = scan.nextInt();
				if(j==0){
					que.add(Map[i][j]);
				}
			}
		}
		
		exe();
		
		
	}
	public static void exe(){
		
		while(idx<4){
			BFS();
			idx++;
		}
		
		
		System.out.println(cnt);
	}
	public static void BFS(){
		int sz = que.size();
		
		for(int i=0;i<sz;i++){
			long l = que.poll();
			for(int j=0;j<N;j++){
				long nl = l+Map[j][idx];
				if(idx==3 && nl==0){
					cnt++;
				}
				que.add(nl);
			}
		}
	}

}
