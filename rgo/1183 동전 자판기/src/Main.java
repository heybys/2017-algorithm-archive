import java.util.Scanner;

public class Main {
	static int W;
	static int Money[] = new int[6];
	static int use[] = new int[6];
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W = scan.nextInt();
		for(int i=0;i<6;i++){
			Money[i] = scan.nextInt();
		}
		int unit[] = {500,100,50,10,5,1};
		
		for(int i=0;i<6;i++){
			use[i] = W/unit[i];
			W -= use[i]*unit[i];
		}

		
		for(int i=0;i<5;i++){
			System.out.print(use[i]+" ");
			for(int j=i;j<5;j++){
				int chi = unit[j]/unit[j+1];
				use[j+1] = Money[j+1]/chi;
			}
		}
	}
}
