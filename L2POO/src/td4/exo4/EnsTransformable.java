package td4.exo4;

public class EnsTransformable {


	private Object[] ens; 

	public EnsTransformable(Object[] ens){
		this.ens = ens;
	}

	public void transformer(Transformation f) {

		for (int i=0; i<ens.length; i++)
			ens[i]= f.transforme(ens[i]);
	}

	public String toString() {
		String s = "";
		for (int i=0; i<ens.length; i++){
			s =s + ens[i] +  "\n";

		}
		return s;
	}


}

