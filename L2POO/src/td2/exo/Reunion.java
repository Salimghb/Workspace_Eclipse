package td2.exo;


public class Reunion {
	private Heure debut;
	private String sujet;
	private Heure fin;

	public Reunion(String sujet, Heure début,Heure fin){
		this.setSujet(sujet);
		this.debut=début;
		this.fin=fin;
	}
	public int durée(){
		return (fin.getHeures()*60+fin.getMinutes())-debut.getHeures()+60+fin.getMinutes();
	}
	public String getSujet(){
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
}
