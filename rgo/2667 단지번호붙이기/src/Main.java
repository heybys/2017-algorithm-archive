import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2667 ������ȣ���̱�

public class Main {

	static Scanner scan = new Scanner(System.in);
	static int N;
	static int Map[][];
	static int visit[][];
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static Queue<Point> que = new LinkedList<Point>();
	static int localSize = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = scan.nextInt();
		Map = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++){
			String str = scan.next();
			for(int j=0;j<N;j++){
				Map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

//		globalSearch();
		globalSearch2();
		
		Collections.sort(al);
		
		int sz = al.size();
		System.out.println(sz);
		
		for(int i=0;i<sz;i++){
			System.out.println(al.get(i));
		}
	}
	public static void globalSearch2(){ // BFS�� �۷ι� ��ġ
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j] == 0 && Map[i][j] == 1){
					localSearch(i, j);
				}
			}
		}
	}
	public static boolean BFS(){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		int sz = que.size(); // ���� ť������ Ȯ��
		boolean flag = false; // ���� BFS�Լ� ������ ���� ���Ե� ��ǥ�� ������ true.
		
		for(int i=0;i<sz;i++){ // ���� ť�����ŭ ��ǥ ������
			Point p = que.poll();
			for(int j=0;j<4;j++){ // ������ ��ǥ�� ���� 4���� Ž��
				Point np = new Point(p.x+dir[j][0], p.y+dir[j][1]); // j������ ���ο� ��ǥ����.
				if(isArea(np.x, np.y)){ // ���� j���� ��ǥ�� �̵������ϴٸ�!!!
					que.add(np);
					localSize++; // ���û����� ����
					visit[np.x][np.y] = 1; // �湮üũ
					flag = true; // ���� ���Ե� ������ ������ true!
				}
			}
		}
		return flag;
	}
	public static void localSearch(int x, int y){
		
		que.add(new Point(x,y));
		localSize++;
		visit[x][y] = 1;
		
		while(BFS()){ // ��� ����Ž���� ����������(���� ���Ե� ��ǥ�� ����������) �ݺ�ȣ��.
			
		}
		al.add(localSize); // ���û����� ����.
		localSize = 0; // ���� ������ �ʱ�ȭ.
		que.clear(); // que������ ���� �ʱ�ȭ -> ������ while���� ���� ���Ե� ��ǥ�� ������ �̹� ������������̹Ƿ� ��������
	}
	public static void globalSearch(){
		int res = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j]==0 && Map[i][j] ==1){
					res = DFS(i,j);
					al.add(res);
				}
			}
		}
	}
	public static int DFS(int x, int y){
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		int snow = 1;
		visit[x][y] = 1;
		
		for(int i=0;i<4;i++){
			Point np = new Point(x+dir[i][0], y+dir[i][1]);
			if(isArea(np.x, np.y)){ // ���࿡ �� �·ᰡ �湮���߰�, ���������
				snow += DFS(np.x, np.y); // �湮
			}
		}
		
		return snow;
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(Map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	public static void printVisit(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else if(visit[x][y] == 1){
			return false;
		}else if(Map[x][y] == 0){
			return false;
		}else{
			return true;
		}
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}