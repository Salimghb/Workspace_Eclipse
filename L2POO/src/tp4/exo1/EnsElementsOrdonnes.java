package tp4.exo1;

public class EnsElementsOrdonnes
{
	private int capacite;
	private int increment;
	private Ordonnable[] table;
	private int taille=0; //pour le nombre de Ordonnable contenus dans table


	public EnsElementsOrdonnes()
	{
		capacite=15;
		increment=10;
		table=new Ordonnable[capacite];
	}
	public EnsElementsOrdonnes(int capacite, int increment)
	{
		this.capacite=capacite;
		this.increment=increment;
		table=new Ordonnable[capacite];
	}

	private void redimensionner(){
		capacite+=increment;
		Ordonnable[] grandTableau=new Ordonnable[capacite];
		for (int i=0;i<taille;i++)
			grandTableau[i]=table[i];
		table=grandTableau; 
	}

	public void inserer(Ordonnable element)
	{
		int i;
		if (taille==capacite){ //on agrandit le tableau
			System.out.println("redimension");   
			redimensionner();
		}
		i=taille-1;
		while ((i>=0) && (table[i].estPlusGrand( element)))
		{
			table[i+1]= table[i];
			i--;
		}
		table[i+1]=element;
		taille++;
	}

	public void supprimer(Ordonnable element)
	{boolean trouve = false;
	boolean tropPetit = false;//dès que l'élément est plus petit que l'élément visité du tableau, on arrête car on ne trouvera pas l'élément
	int i=0;

	while((i<taille) && (!trouve) && (!tropPetit)){
		if (table[i].equals(element)) trouve = true;
		else if (!(element.estPlusGrand(table[i]))) 
			tropPetit=true;
		else i++;
	}
	if (trouve)
	{
		while (i<taille-1)
		{
			table[i]=table[i+1];
			i++;
		}
		taille--;
		System.out.println("suppression effectuée");
	}
	else System.out.println("aucun élément supprimé");

	}

	public String toString()
	{ 
		String chaine=" ";
		for (int i=0;i<taille;i++) 
			chaine+=table[i].toString()+"\n ";
		chaine+="\n";
		return chaine;
	}
}
