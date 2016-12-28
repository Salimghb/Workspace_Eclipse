package tp5.exo3;

import java.io.Serializable;




@SuppressWarnings("serial")
public class EnsembleNotes implements Serializable{
    private  Note lesnotes[];
    private int nbNotes;
    private int increment;

    public EnsembleNotes() 
    {
	lesnotes = new Note[20];
	nbNotes = 0;
	increment = 10;
    }
    
 
    public int getNbNotes(){
    	return nbNotes;
    	
    }
    public void ajouterNote(Note note)
    {
	if (lesnotes.length==nbNotes) {
	    Note lesnotes2[];
	    lesnotes2=new Note[lesnotes.length+increment];
	    for(int i=0;i<lesnotes.length;i++)
		lesnotes2[i]=lesnotes[i];
	    lesnotes=lesnotes2;
	}

	lesnotes[nbNotes++]=note;
    }
     public String toString(){
         String s="";
         for (int i=0; i<nbNotes; i++)
             s = s+"\n"+ lesnotes[i].toString();
        return s;
    }

}


