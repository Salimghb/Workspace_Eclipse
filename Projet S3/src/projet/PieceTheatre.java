package projet;

public class PieceTheatre extends Spectacle {
	private String metteurEnScene;
	private int nbEntractes;

	public PieceTheatre(String metteurEnScene, int nbEntractes,String interpretes, String titre) {
		super(interpretes, titre);
		this.metteurEnScene=metteurEnScene;
		this.nbEntractes=nbEntractes;
	}

	public int getNbEntractes() {
		return nbEntractes;
	}

	public void setNbEntractes(int nbEntractes) {
		this.nbEntractes = nbEntractes;
	}

	public String getMetteurEnScene() {
		return metteurEnScene;
	}

	public void setMetteurEnScene(String metteurEnScene) {
		this.metteurEnScene = metteurEnScene;
	}
	public String toString() {
		return super.toString()+"\nMetteur en scene :" + metteurEnScene + "\n Nombre d'entractes :" + nbEntractes;
	}

}
