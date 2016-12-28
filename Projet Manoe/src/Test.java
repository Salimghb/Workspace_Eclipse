import java.util.Scanner;

public class Test {

	static Scanner in = new Scanner (System.in);

	public static boolean ssT(int []t1, int []t2){
		boolean a=false;
		int n = 0;
		int k = 0;
		int i = 0;
		int t = 0;
		if(t2.length > t1.length){
			a = false;
			return a ;
		}else{
			while(i != t1.length-1){
				while(t1[i] != t2[0]){
					i = i+1;
				}
				System.out.println("i = " + (i+1));
				n=i;
				for(k = 0;k <= t2.length-1;k++){
					if(t2[k] == t1[n]){
						n = n+1;
						t = t+1;
					}else{
						t = 0;
					}
				}
				if(t == t2.length){
					a = true;
					return a;
				}else{
					a = false;
				}
				i = i+1;
			}
		}
		return a;
	}

	public static void main (String [] args){
		int [] t1 = {1,7,9,6,0,8,7,9,6};
		int []t2 = {7,9,6};
		boolean a;
		a = ssT(t1,t2);
		if(a){
			System.out.println("ok");
		}else{
			System.out.println("non ok");
		}
	}

}