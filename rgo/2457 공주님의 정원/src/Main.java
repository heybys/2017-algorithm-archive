import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int S,E;
	static int N;
	static int DAY[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static ArrayList<flower> LIST;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 S = day(3,1);
		 E = day(11,31);
		 
		 N = scan.nextInt();
		 LIST = new ArrayList<flower>();
		 
		 for(int i=0;i<N;i++){
			 int s = day(scan.nextInt(), scan.nextInt());
			 int e = day(scan.nextInt(), scan.nextInt());
			 if(s<S){
				 s = S;
			 }
			 if(e>E){
				 e = E;
			 }
			 flower f = new flower(s,e);
			 LIST.add(f);
		}
		Comparator<flower> comp = new Comparator<flower>() {
			public int compare(flower f1, flower f2) {
				if(f1.s>f2.s){
					return 1;
				}else if(f1.s<f2.s){
					return -1;
					
				}else{
					if(f1.e>f2.e){
						return 1;
					}else{
						return -1;
					}
				}
			}
		};
		Collections.sort(LIST, comp);
		for(int i=0;i<LIST.size();i++){
			System.out.println(LIST.get(i).s+", "+LIST.get(i).e);
		}
	}
	public static int day(int m, int d){
		int day = 0;
		
		for(int i=1;i<m;i++){
			day += DAY[i];
		}
		day += d;
		
		return day;
	}
}
class flower{
	int s;
	int e;
	public flower(int s, int e) {
		this.s = s;
		this.e = e;
	}
	
}