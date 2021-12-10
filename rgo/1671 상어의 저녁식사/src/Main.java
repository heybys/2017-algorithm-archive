import java.util.ArrayList;
import java.util.Scanner;





public class Main {
	
	static int N;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Shark> sal = new ArrayList<>();
	static Node node[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = scan.nextInt();
		node = new Node[N];
		for(int i=0;i<N;i++){
			Shark shrk = new Shark(scan.nextInt(),scan.nextInt(),scan.nextInt());
			sal.add(shrk);
			
			node[i] = new Node();
		}
		for(int i=0;i<N;i++){
			Shark s = sal.get(i);
			for(int j=0;j<N;j++){
				if(i!=j){
					Shark fs = sal.get(j);
					if(s.canEat(fs)){
						node[i].addEdge(j);
					}
				}
			}
		}
		
	}
	
}
class Node{
	ArrayList<Integer> edge;
	int cnt;
	public Node() {
		this.edge = new ArrayList<Integer>();
		this.cnt = 0;
	}
	public void addEdge(int n){
		edge.add(n);
	}
	public void removeEdge(int n){
		edge.remove((Integer)n);
	}
}
class Shark{
	int size;
	int speed;
	int iq;
	public Shark(int size, int speed, int iq) {
		this.size = size;
		this.speed = speed;
		this.iq = iq;
	}
	public boolean canEat(Shark s){
		
		if(this.size>=s.size && this.speed>=s.speed && this.iq>=s.iq){
			return true;
		}else{
			return false;
		}
	}
}