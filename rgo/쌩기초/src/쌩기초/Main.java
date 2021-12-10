package �߱���;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int N = 5;
	static int map[][];
	static int visit[][];
	static Queue<Point> que = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		map = new int[N][N];
		visit = new int[N][N];
		
		
//		dfs(new Point(1,1));
		que.add(new Point(1,1)); // �ʱ� �����ϰ�. 
		visit[1][1] = 1;
		
		int cnt = 0;
		printMap();
		while(BFS()){
			cnt++;
			printMap();
		}
		
//		BFS();// �� �۾��� ������.
//		
//		  //������ �ǰ� ���� �̽���. 4��������.
//		
//		BFS(); // 16�� �߿��� �ߺ������ϰ� ���� ������ŭ ���ִ�.
//		
//		BFS();
//		BFS();
//		BFS();
//		BFS();
//		BFS();
//		BFS();// �� �ȿ����� que.add �ѹ��� ȣ���̾ȵ�. --> false;
		
		
		
		
	}
	public static boolean BFS(){
		int sz = que.size();
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		
		boolean flag = false;
		
		for(int i=0;i<sz;i++){
			Point np = que.poll();// ��ǥ �̾Ƽ�.
			for(int j=0;j<4;j++){ // �׹������� ������.
				if(isMap(np.x+dir[j][0], np.y+dir[j][1])){ // �ش������ ���� �ִ�!��...
					que.add(new Point(np.x+dir[j][0],np.y+dir[j][1])); // ���ο� ��ǥ�� ť�ȿ� �ִ´ٴ� �ǹε�, �׸��� ��, 
					flag = true;// ���Ӱ� �̵��� �� �ִ� ��ǥ�� ���Ա���~~�˷���.
					visit[np.x+dir[j][0]][np.y+dir[j][1]] = 1; // �ش礸 ��ǥ �湮üũ.
				}
			}
		}
		
		return flag;
		
	}
	public static void dfs(Point p){
		int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
		
		visit[p.x][p.y] = 1;
		printMap();//����Ȯ���ϰ�. ����غ�����.
		
		for(int i=0;i<4;i++){ // 4�����̶� 4.
			//i = 0 ��. ������ �����ε� isMap���� false�� ������.  
			if(isMap(p.x+dir[i][0], p.y+dir[i][1])){ // ���� �������� ��ǥ�� ���� ������, !! �����ٴ�.
				dfs(new Point(p.x+dir[i][0], p.y+dir[i][1])); // 1+0, 4+1 = 1,5
			}
		}
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	public static boolean isMap(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else{
			if(visit[x][y] ==1){
				return false;
			}else{
				return true;
			}
		}
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}