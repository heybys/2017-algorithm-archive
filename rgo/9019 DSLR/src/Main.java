// 9019 DSLR BFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int S,E,T;
	static Queue<Register> que;
	static Scanner scan = new Scanner(System.in);
	static int visit[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		T = scan.nextInt();
		for(int i=0;i<T;i++){
			S = scan.nextInt();
			E = scan.nextInt();
			visit = new int[10000];
			que = new LinkedList<Register>();
			exe();
		}
	}
	public static void exe(){
		if(S==E){
			
		}else{
			Register r = new Register(S);
			que.add(r);
			visit[S] = 1;
			while(oneStep()){
			}
		}
//		System.out.println("===========");
	}
	public static boolean oneStep(){
		int sz = que.size();
		boolean flag = false;
		for(int i=0;i<sz;i++){
			Register reg = que.poll();
			int rn = reg.getN();
			for(int j=0;j<4;j++){
				Register nReg = new Register(rn, reg.total_order);
				nReg.order(j);	
				int nRn = nReg.getN();
				if(visit[nRn] == 0){
					if(nReg.getN()==E){
						nReg.printTotal_order();
						return false;
					}else{
						que.add(nReg);
//						nReg.printTotal_order();
//						System.out.println(nReg.getN());
						visit[nRn] = 1;
						flag = true;
					}
				}else{
					
				}
			}
		}
		return flag;
	}
}
class Register{
	int UNIT_OF_DIGIT = 4;
	int d[] = new int[UNIT_OF_DIGIT];
	ArrayList<Character> total_order = new ArrayList<Character>();
	public Register(int n) {
		setD(n);
	}
	public Register(int n, ArrayList<Character> to) {
		setD(n);
		setTotal_order(to);
	}
	public void setTotal_order(ArrayList<Character> to){
		int sz = to.size();
		for(int i=0;i<sz;i++){
			this.total_order.add(to.get(i));
		}
	}
	public int getN(){
		int n=0;
		n += d[0];
		for(int i=1;i<UNIT_OF_DIGIT;i++){
			n *= 10;
			n += d[i];
		}
		return n;
	}
	public void setD(int n){
		int preD = 0;
		for(int i=0;i<UNIT_OF_DIGIT; i++){
			n -= preD*(int)Math.pow(10, UNIT_OF_DIGIT-i);
			d[i] = n/(int)Math.pow(10, UNIT_OF_DIGIT-i-1);
			preD = d[i];
		}
	}
	public void printTotal_order(){
		int sz = total_order.size();
		for(int i=0;i<sz;i++){
			System.out.print(total_order.get(i));
		}
		System.out.println();
	}
	public void order(int sign){
		int n;
		int t;
		switch(sign){
			case 0 : // D
				n = getN();
				n *= 2;
				if(n>9999){
					n = n%10000;
				}
				setD(n);
				total_order.add('D');
				break;
			case 1 : // S
				n = getN();
				n -= 1;
				if(n<0){
					n = 9999;
				}
				setD(n);
				total_order.add('S');
				break;
			case 2 : // L
				t = d[0];
				for(int i=1;i<UNIT_OF_DIGIT;i++){
					d[i-1] = d[i];
				}
				d[UNIT_OF_DIGIT-1] = t;
				total_order.add('L');
				break;
			case 3 : // R
				t = d[UNIT_OF_DIGIT-1];
				for(int i=UNIT_OF_DIGIT-1;i>0;i--){
					d[i] = d[i-1];
				}
				d[0] = t;
				total_order.add('R');
				break;
		}
	}
	
}
