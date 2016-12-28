package projet;

public abstract class Spectacle {
	private String interpretes;
	private String titre;

	public Spectacle(String interpretes, String titre) {
		this.interpretes = interpretes;
		this.titre = titre;
	}

	public String getInterpretes() {
		return interpretes;
	}

	public void setInterpretes(String interpretes) {
		this.interpretes = interpretes;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String toString() {
		return " Titre :" + titre+"\n Interpretes :" + interpretes;
	}
	
}