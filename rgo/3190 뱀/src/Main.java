import java.util.ArrayList;
import java.util.Scanner;

// 3190 뱀


public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static int N;
	static int K;
	static int L;
	static int Map[][];
	
	static Snake snake = new Snake(0,0);
	static ArrayList<Turn> al = new ArrayList<Turn>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = scan.nextInt();
		Map = new int[N][N];
		
		K = scan.nextInt();
		for(int i=0;i<K;i++){
			Map[scan.nextInt()-1][scan.nextInt()-1] = 1;
		}
		
		L = scan.nextInt();
		for(int i=0;i<L;i++){
			int s = scan.nextInt();
			char c = scan.next().charAt(0);
			al.add(new Turn(s,c));
		}
		exe();
	}
	public static void printMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(snake.searchBody(i, j) != null){
					System.out.print(2+" ");
				}else{
					System.out.print(Map[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public static void exe(){
		int cnt = 0;
		int pos = 0;
		int dir = 0;
		
		while(oneSec(dir)){
//			snake.print();
//			printMap();
			cnt ++;
			if(pos<al.size()){
				if(al.get(pos).sec==cnt){
					if(al.get(pos).dir=='L'){
						dir = (dir+3)%4;
					}else{
						dir = (dir+1)%4;
					}
					pos++;
				}
			}
//			System.out.println(cnt);
		}
		System.out.println(cnt+1);
	}
	public static boolean oneSec(int d){
		int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		boolean alive = false;
		
		Point np = new Point(snake.head.x+dir[d][0], snake.head.y+dir[d][1]);
		if(isArea(np.x, np.y)){
			if(Map[np.x][np.y]==1){
				Map[np.x][np.y] = 0;
				alive = snake.move(np.x, np.y, 1);
			}else{
				alive = snake.move(np.x, np.y, 0);
			}
		}
		return alive;
		
	}
	public static boolean isArea(int x, int y){
		if(x<0 || x>=N){
			return false;
		}else if(y<0 || y>=N){
			return false;
		}else{
			return true;
		}
	}

}
class Turn{
	int sec;
	char dir;
	public Turn(int sec, char dir) {
		this.sec = sec;
		this.dir = dir;
	}
}
class Snake{
	
	Body head;
	Body tail;
	
	public Snake(int x, int y) {
		this.head = new Body(x, y);
		this.tail = head;
	}
	public Body addTail(int x, int y){
		Body newBody = tail.addNext(x, y);
		tail = newBody;
		return newBody;
	}
	public void cutTail(){
		tail = tail.prev;
		tail.next = null;
	}
	public boolean move(int x, int y, int flag){
		Body pos = head;
		boolean cut = false;
		if(flag ==0){
			flag = 1;
			cut = true;
		}
		
		int nx = x, ny = y;
		int ox = pos.x, oy = pos.y;
		
		Body b = searchBody(x, y); // 이동할 위치가 뱀의 몸인지 탐색
		if(b!=null && !b.equals(tail)){ // 만약 탐색이 되고 그게 몸통일경우
			return false; // 이동 실패
		}
		
		while(pos != null){
			ox = pos.x; // 현재 pos의 위치를 저장
			oy = pos.y;
			
			pos.x = nx; // 현재 pos를 이동
			pos.y = ny;
			
			nx = ox; // 이후 pos를 위해 이동할 위치설정
			ny = oy;
			
			pos = pos.next; // 이후 pos로 이동
		}
		
		if(flag ==1){// 꼬리를 추가하는 경우
			if(searchBody(ox, oy)==null){ // 꼬리추가 위치에 아무것도 없으면
				Body bd = addTail(ox, oy);	// 꼬리추가
			}else{ // 뭐가 있으면
				return false; // 실패
			}
		}
		if(cut){
			cutTail();
		}
		
		return true;
	}
	
	public Body searchBody(int x, int y){
		Body pos = head;
		while(pos != null){
			if(pos.x==x && pos.y==y){
				return pos;
			}
			pos = pos.next;
		}
		return null;
	}
	public void print(){
		Body pos = head;
		while(pos != null){
			System.out.print("("+(pos.x)+", "+(pos.y)+") ");
			pos = pos.next;
		}
		System.out.println();
	}
}
class Body{
	int x;
	int y;
	Body prev;
	Body next;
	
	public Body(int x, int y) {
		this.x = x;
		this.y = y;
		this.prev = null;
		this.next = null;
	}
	public Body(int x, int y, Body prev, Body next) {
		this.x = x;
		this.y = y;
		this.prev = prev;
		this.next = next;
	}
	public Body addNext(int x, int y){
		Body newBody = new Body(x, y,this,null);
		this.next = newBody;
		return newBody;
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