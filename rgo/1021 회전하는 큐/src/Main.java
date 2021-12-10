import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1021 회전하는 큐


public class Main {
	
	static int N;
	static int M;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> al = new ArrayList<>();
//	static myQue que;
	static Queue<Point> que = new LinkedList<>(); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i=0;i<M;i++){
			int a = scan.nextInt();
			Point p = new Point(a-1,N+1-a);
		}
		int sz = que.size();
		for(int i=0;i<sz;i++){
			
		}
	}
	public static void queUpdate(){
		
	}

}
class Point{
	int l;
	int r;
	public Point(int l, int r) {
		this.l = l;
		this.r = r;
	}
}
class myQue{
	Node head = null;
	Node tail = null;
	int sz = 0;
	
	public myQue(int n) {
		for(int i=1;i<=n;i++){
			addNode(i);
		}
	}
	public void addNode(int n){
		Node newNode;
		if(head==null){
			newNode = new Node(null,null, n); 
			head = newNode;
			tail = newNode;
		}else{
			newNode = new Node(tail, null, n);
			tail.next = newNode;
			tail = newNode;
		}
		sz += 1;
	}
	public int getNode(){
		int n = head.n;
		head = head.next;
		head.prev = null;
		sz -= 1;
		return n;
	}
	public void leftTurn(){
		Node pos = head;
		int temp = pos.n;
		
		while(pos.next!=null){
			pos.n = pos.next.n;
			pos = pos.next;
		}
		pos.n = temp;
	}
	public void rightTurn(){
		Node pos = tail;
		int temp = pos.n;
		
		while(pos.prev!=null){
			pos.n = pos.prev.n;
			pos = pos.prev;
		}
		pos.n = temp;
	}
	public void print(){
		Node pos = head;
		while(pos!=null){
			System.out.print(pos.n+" ");
			pos = pos.next;
		}
		System.out.println();
	}
}
class Node{
	Node prev;
	Node next;
	int n;
	public Node(Node prev, Node next,int n) {
		this.prev = prev;
		this.next = next;
		this.n = n;
	}
}
