package tp1.exo;

public class Etudiant {
	
	private String nom;
	
	public Etudiant (String name){
		this.nom=name;
	}
	
	public void travailler (){
		System.out.println ( nom + " se met au travail!" );
	}
	
	public void seReposer (){
		System.out.println ( nom + " se repose..." );
	}
}


