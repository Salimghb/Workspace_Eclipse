package td1.exo;

public class Ex1 {
	public static void premier (int n){
		boolean []crible=new boolean [n+1];
		crible[0]=false;
		crible[1]=false;
		for (int i=2;i<n+1;i++){
			crible[i]=true;
		}
		for (int i=2;i<n+1;i++){
			if(crible[i]==true){
				for(int j=i+1;j<n+1;j++){
					if(j%i==0){
						crible[j]=false;
					}
				}
			}
		}
		for (int i=2;i<crible.length;i++){
			if(crible[i]){
				System.out.println(i);
			}
		}
	}
	public static void main (String []args){
		premier(326);
	}
}
