
public class Multiset {
	public Couple [] multi;

	public Multiset() {
		multi = new Couple [10];
		for(int i=0 ; i < multi.length ; i++){
			multi [i]=new Couple();
		}
	}

	public boolean ajout(double x, int n){
		for (int i=0 ; i < multi.length ; i++){
			if (multi[i].v1==x) {
				multi[i].v2 = multi[i].v2+ n;
			}
			else {if (multi[i].v2==0){
				multi[i].v1=x;
				multi[i].v2=n;
				return true;
			}
			}
		}
		return false;
	}

	public boolean ajout (Couple c)	{
		return this.ajout(c.v1, c.v2);
	}	



	public boolean supprimer (double x, int i){
		int j,k;
		j=0;
		while (j<multi.length){
			if(multi[j].v1==x){
				if(multi[j].v1>=i){
					multi[j].v2=multi[j].v2-i;
					if(multi[j].v2==0){
						k=j;
						while(k<multi.length-1){
							multi[k]=multi[k+1];
							if(multi[k].v2==0){
								break;
							}
						}
						multi[k+1].v1=0;
						multi[k+1].v2=0;
					}
					return true;
				}
				else
					return false;
			}
			else
				if(multi[j].v2==0){
					return false;
				}
			j++;
		}
		return false;
	}

	public boolean supprimer (double x){
		return supprimer(x,1);
	}

	public boolean estVide(){
		return multi[0].v2==0;
	}

	public int NbCouple(){
		int j;
		j=0;
		for(int i=0 ; i < multi.length ; i++){
			if (multi[i].v2>0){
				j++;
			}
			else
				break;
		}
		return j;
	}

	public int NbValeurs(){
		int j;
		j=0;
		for(int i=0 ; i < multi.length ; i++){
			if (multi[i].v2>0){
				j=j+multi[i].v2;
			}
			else
				break;
		}
		return j;
	}

	public String toString() {
		int nb;
		String s;
		if(estVide()){
			return "{}";
		}
		nb=NbCouple();
		s="{";
		for (int i=0 ; i<nb-1 ; i++){
			s=s+multi[i].toString()+",";
		}
		s=s+multi[nb-1].toString()+"}";
		return s;
	}

}




























