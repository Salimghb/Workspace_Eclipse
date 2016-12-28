package tp5.exo3;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Note implements Serializable
{
    private String nom;
    private String matiere;
    private int lanote;

    public Note(String nom, String matiere, int note) {
	if(note<0 ||note >20) 
		throw new IllegalArgumentException("La note doit être comprise entre 0 et 20");

    this.nom=nom;
    this.matiere=matiere;
    this.lanote=note;
	
    }

    public String getNom()
    {
	return this.nom;
    }

    public String getMatiere()
    {
	return this.matiere;
    }

    public int getNote()
    {
	return this.lanote;
    }
    public String toString(){
        return  matiere +" "+nom +" "+ lanote;
    }
    

}


