package td1.exo;

public class Ex2 {
	public static boolean div (int n){
		if (n==0)
			return true;
		if (n<11)
			return false;
		int diff=0;
		boolean rangImpair=true;
		while (n!=0){
			if (rangImpair==true){
				diff+=n%10;
				n=n/10;
				rangImpair=false;
			}
			else{
				diff-=n%10;
				n=n/10;
				rangImpair=false;
			}
		}
		return div (Math.abs(diff));
	}
}
