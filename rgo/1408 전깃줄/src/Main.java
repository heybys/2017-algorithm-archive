import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 1408 ภüฑ๊มู
public class Main {

	static int t;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Line> al = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		t = scan.nextInt();
		for(int i=0;i<t;i++){
			Line ln = new Line(scan.nextInt(), scan.nextInt());
			al.add(ln);
		}
		Comparator comp = new Comparator<Line>() {

			@Override
			public int compare(Line ln1, Line ln2) {
				// TODO Auto-generated method stub
				if(ln1.a>ln2.a){
					return 1;
				}else{
					return -1;
				}
			}
		};
		Collections.sort(al, comp );
		exe();		
		
	}
	public static void exe(){
		boolean del  = true;
		while(del){
			setCnt(); 	
			printAl();
			del = deleteMax();
		}
		System.out.println(t - al.size());
	}
	public static boolean deleteMax(){
		int max = 0;
		int maxi = 0;
		int sz = al.size();
		for(int i=0;i<sz;i++){
			if( max < al.get(i).cnt){
				max = al.get(i).cnt;
				maxi = i;
			}
		}
		if(max == 0){
			return false;
		}else{
			al.remove(maxi);
			return true;
		}
	}
	public static void setCnt(){
		int sz = al.size();
		
		for(int i=0;i<sz;i++){
			al.get(i).cnt = 0;
		}
		for(int i=0;i<sz;i++){
			Line ln = al.get(i);
			for(int j=i;j<sz;j++){
				if(i!=j){
					Line tmp = al.get(j);
					if(ln.b > tmp.b){
						ln.cnt++;
						tmp.cnt++;
					}
				}
			}
		}
	}
	public static void printAl(){
		int sz = al.size();
		for(int i=0;i<sz;i++){
			System.out.println(al.get(i).a+" "+al.get(i).b+" "+al.get(i).cnt);
		}
	}
}
class Line{
	int a;
	int b;
	int cnt;
	public Line(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		this.cnt = 0;
	}
}
