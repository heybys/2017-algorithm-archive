import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1006 �κ�
public class Main {
	static int N;
	static int M;
	static int Map[][];
	static int visit[][][];
	static Scanner scan = new Scanner(System.in);
	static Point sp;
	static Point dp;
	static Queue<Point> que = new LinkedList<Point>();
	
	public static void main(String[] args) {// 
		N = scan.nextInt();
		M = scan.nextInt();
		Map = new int[N][M];
		visit = new int[N][M][4];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				Map[i][j] = scan.nextInt();
			}
		}
		sp = new Point(scan.nextInt()-1, scan.nextInt()-1, scan.nextInt()-1);
		dp = new Point(scan.nextInt()-1, scan.nextInt()-1, scan.nextInt()-1);
		///////////////////init
		
		exe();
		
	}
	public static void exe(){ //
		que.add(sp); // ������ ����.
		visit[sp.x][sp.y][sp.d] = 1; // �湮üũ.
		int order = 0; // BFS�� ���ȣ��Ǵ��� ��������.
		
		while(BFS()){ // Ż��~
			order++;
		}
		System.out.println(order+1);
	}
	public static boolean BFS(){ // ��ó���ϴ¾�? ť���ִ� ���빰���� �ϳ��� ������ �׳༮���κ��� '5������ order�� ������ ���ο��'����� �۾�
		int dir1[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};// 0�� 1�� 2�� 3��
		int dir2[][] = {{0,2}, {0,-2}, {2,0}, {-2,0}};// 0�� 1�� 2�� 3��
		int dir3[][] = {{0,3}, {0,-3}, {3,0}, {-3,0}};// 0�� 1�� 2�� 3��
		
		boolean flag = false; // ť�� ���� ���ԵȰ� ������ true�ٲ� BFS�� �ѹ��� ȣ��Ǿ����� �ܺο� �˷��ش�.��ȣ�ش�~
		int sz = que.size();
		
		for(int i=0;i<sz;i++){
			Point p = que.poll();
			boolean block = false;
			
			for(int j=1;j<6;j++){
				Point np = null;
				if(j==1){
					np = new Point(p.x+dir1[p.d][0], p.y+dir1[p.d][1], p.d);
				}else if(j==2){
					if(block == false){
						np = new Point(p.x+dir2[p.d][0], p.y+dir2[p.d][1], p.d);
					}
				}else if(j==3){
					if(block==false){
						np = new Point(p.x+dir3[p.d][0], p.y+dir3[p.d][1], p.d);
					}
				}else if(j==4){ // �̶��� �׳� ����
					np = new Point(p.x, p.y, turnLeft(p.d));
				}else{ // �̶��� �׳� ������
					np = new Point(p.x, p.y, turnRight(p.d));					
				}
				///////////////////////////////���ο�� ������...
				// ���� �� ���ο� ���� ť�� ���� �����ص� �Ǵ³�����??�Ǵ��� �غ���~~~~~
				
				if(np != null){
					if(np.x==dp.x && np.y==dp.y && np.d==dp.d){
						return false;
					}
					if(isOK(np.x, np.y, np.d)){ // ���⼭�� ���̿��� ����, ��湮�̿��� ���� �Ѵ� ����.
						que.add(np); // ť�� ���嵵 �ϰ�~
						visit[np.x][np.y][np.d] = 1; // �湮üũ���ϰ�~
						flag = true; // BFS�ѹ��������ߵ�~~~~�ܺη� �˷��ְ�~
					}else{ // ���ٸ����� ����� �Ծ�.
						//��湮������ ���� 
						if(isBlock(np.x, np.y, np.d)){// ������.
							block = true;			
						}
					}
				}
				// �̴�� ������, 1ĭ�̵��� �Ұ����ѵ� 2ĭ 3ĭ�� �̵��ϴ� ���ѱ� ����� ���ܹ���...
				// �׷��� ���� 1ĭ�̵��� ����(����:��)�ϋ�, 2ĭ 3ĭ�� �ƿ� np�� �Ҵ���������~(idea 1)
				// �ռ� �ϴ� �۾����� ������ �߻��ؼ� ���� �۾��� ��ȣ�� �ٲ���.
				
			}
		}
		
		return flag;
	}
	public static boolean isOK(int x, int y, int d){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=M){
			return false;
		}else if(Map[x][y] == 1){ // ���̶� �ȴ�
			return false;
		}else if(visit[x][y][d]==1){ // �̹� �湮�Ѱ��̶� �ȵ�.
			return false;
		}else{
			return true;
		}
	}
	public static boolean isBlock(int x, int y, int d){
		if(x<0 || x>=N){
			return true;
		}else if(y<0 || y>=M){
			return true;
		}else if(Map[x][y] == 1){ // ���̶� �ȴ�
			return true;
		}else{
			return false;
		}
	}
	public static int turnLeft(int d){ // d��� ���� �ε����� �ָ�~
		if(d==0){ // �����̾�
			return 3;
		}else if(d==1){ // �����̸�
			return 2;
		}else if(d==2){
			return 0;
		}else{ //3
			return 1;
		}
	}
	public static int turnRight(int d){ // d��� ���� �ε����� �ָ�~
		if(d==0){ // �����̾�
			return 2;
		}else if(d==1){ // �����̸�
			return 3;
		}else if(d==2){ // �����̸�
			return 1;
		}else{ //3
			return 0;
		}
	}
}
class Point{
	int x;
	int y;
	int d;
	public Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

//��������. 1. �������� ť�� �ִ´�. 2. BFS���� ť�� �ѹ� ó���Ѵ�.(�� �������� ť�ȿ� ���ο� ������ ���ŵɰ�) 3. �׷��� �� BFS�� �ٸ� �Լ����� While�� ������.
//BFS���ο��� �������� �־��� ��������(������� �������� �����ߴٴ���...)�� ���յǸ� false�� ���Ͻ��Ѽ� While�� Ż���Ѵ�.

















//		boolean flag = false; // flag�� ���� true�� �ٲ�ĸ�...Que�ȿ� ���ο� ��ǥ�� ���Եɋ�.--> �̰� ���� �ǹ̰� ���ĸ�.
//		BFS�� ����ɶ�, �������ϴ°� ����?
//				Que������ üũ�ϴ°���.�׸��� ��BFS��� �Լ��� Que�ȿ� ���빰�� ������ �� ���빰�� ó���ϴ� �Լ�.
//				
//				�ٵ� Que�ȿ� ���ο� ��ǥ�� ��� �����̵�.---> BFS��� �Լ��� ��� ȣ��Ǿ��Ѵٴ� �ǹ�.
//				�ٵ� ���ο� ��ǥ�� �ϳ��� ������ �ȵǸ� flag�� ��� false�� �����ְٳ�.
//				�׸��� ��, BFS�Լ��� ���̻� ȣ��� �ʿ䰡 ����.