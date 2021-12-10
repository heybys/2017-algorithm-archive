import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int N;
	static int SL;
	static int SW;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Sausage> al = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		for(int i=0;i<N;i++){
			SL = scan.nextInt();
			SW = scan.nextInt();
			Sausage s = new Sausage(SL, SW);
			al.add(s);
		}
		Comparator comp = new Comparator<Sausage>() {
			@Override
			public int compare(Sausage o1, Sausage o2) {
				// TODO Auto-generated method stub
				if(o1.l>o2.l){
					return 1;
				}else if(o1.l<o2.l){
					return -1;
				}else{
					if(o1.w>o2.w){
						return 1;
					}else{
						return -1;
					}
				}
			}

		};
		Collections.sort(al, comp);
//		for(int i=0;i<N;i++){
//			Sausage s = al.get(i);
//			System.out.println(s.l+" "+s.w);
//		}
		int cnt = 0;
		int check[] = new int[N];
		for(int i=0;i<N;i++){
			Sausage pivot = al.get(i);
			if(check[i] != 1){
				cnt++;
				for(int j=i+1;j<N;j++){
					Sausage temp = al.get(j);
					if(check[j]!=1){
						if(temp.l>=pivot.l && temp.w>=pivot.w){
							check[j] = 1; 
							pivot = temp;				
						}
					}
				}
				
			}
		}
		System.out.println(cnt);
//		for(int i=0;i<N;i++){
//			System.out.print(check[i]+" ");
//		}
		
	}
}
class Sausage{
	int l;
	int w;
	public Sausage(int l, int w) {
		this.l = l;
		this.w = w;
	}
}
