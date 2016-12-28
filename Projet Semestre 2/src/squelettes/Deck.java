package squelettes;
public class Deck {
	private Liste cartes=new Liste();
	public Deck(){
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=13; j++)
			{
				cartes.AjoutDebut ( new Carte(i,j) );
			}
		}   
	}
	public Liste getListe(){
		return cartes;
	}
}