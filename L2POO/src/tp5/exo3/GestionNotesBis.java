/**
 * 
 */
package tp5.exo3;


import java.io.*;
import java.util.Scanner;


/**
 * @author kahlem
 *
 */
public class GestionNotesBis {
	@SuppressWarnings("resource")
	private static EnsembleNotes saisirNote()
	{	EnsembleNotes lesNotes = new EnsembleNotes();
		Scanner in = new Scanner(System.in);
		String nom = "";
		String matiere = "";
		int note = 0;
		
		System.out.println("Veuillez saisir la matière : ");
		matiere = in.next();
		while (true){
			System.out.println("Veuillez saisir le nom de l'étudiant : (q pour quitter)");
			nom = in.next();
			if (nom.equals("q"))
				break;
			int nbNotes =0;
			while (nbNotes<3){
				System.out.println("Veuillez saisir la note : ");
				if (in.hasNextInt()) {
					note = in.nextInt();
					if (note>=0 && note <=20){
						Note laNote = new Note (nom, matiere, note);
						lesNotes.ajouterNote(laNote);
						nbNotes++;
					}
					else System.out.println("la note doit être comprise entre 0 et 20");		
					
				}
				else {
                    System.out.println("Ce n'est pas un entier.");
                    in.next();
					}  
				}
			}
		return lesNotes;
		}
		
		
	@SuppressWarnings("resource")
	private static Note lireLigne(String ligne) throws LigneIncorrecteException{
		Note MaNote ;
		String nom = "";
		String matiere = "";
		int note = 0;
		Scanner in = new Scanner(ligne);		
		if(in.hasNext()){
			matiere=in.next();
			if(in.hasNext()){ 
				nom=in.next();
				if(in.hasNextInt()) 
					note=in.nextInt();
				else throw new LigneIncorrecteException("note incorrecte");
			}
			else throw new LigneIncorrecteException("ligne incomplète");
		}
		else throw new LigneIncorrecteException("ligne vide");
		if (note>=0 && note <=20)
				MaNote = new Note(nom, matiere, note);
		else
			throw new LigneIncorrecteException("note incorrecte");	
		
		return MaNote;
	}

	@SuppressWarnings("resource")
	private static EnsembleNotes  lireFichierNotes (String fichier) throws FileNotFoundException 
	{	EnsembleNotes lesNotes= new EnsembleNotes();
		Note maNote=null ;
		int nbMauvaiseLignes=0;
		String ligne="";
		File f = new File (fichier);

        Scanner s = new Scanner(f);
        while (s.hasNextLine()){
            ligne = s.nextLine();
           
                try {
					maNote = lireLigne(ligne);
					lesNotes.ajouterNote(maNote);
				} catch (LigneIncorrecteException e) {
					nbMauvaiseLignes++;
				}
                
         
        }
        System.out.println("Fichier " + fichier + " chargé. Le nombre de lignes incorrectes est " + nbMauvaiseLignes + ".");
        return lesNotes;
}

	
	private static void ecrireFichierNotes (String fichier, EnsembleNotes lesNotes) throws IOException 
	{	FileWriter fw = new FileWriter(fichier);
		PrintWriter out = new PrintWriter(fw);
		out.println(lesNotes.toString()); 
		out.close();
			
	}
	public static void ecrireFichierObjetNotes( String fichier, EnsembleNotes lesNotes) throws IOException{
		ObjectOutputStream sortie = new ObjectOutputStream (new FileOutputStream(fichier));
		sortie.writeObject(lesNotes);
		sortie.flush();
		sortie.close();
	}
	public static EnsembleNotes lireFichierObjetNotes(String fichier) throws FileNotFoundException, IOException{
		ObjectInputStream entree = new ObjectInputStream(new FileInputStream(fichier));
		EnsembleNotes ens=null;
		try {
			ens = (EnsembleNotes)entree.readObject();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		entree.close();
		return ens;
		
	}
	

	
	@SuppressWarnings("resource")
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		EnsembleNotes mesNotes = new EnsembleNotes();
		int n;
		String fichier="";
        
        	while(true){
            
          	System.out.println("Bienvenue dans ce serveur de gestion de notes.");
            	System.out.println("Tapez 1 pour charger un fichier de notes.");
            	System.out.println("Tapez 2 pour saisir des notes.");
            	System.out.println("Tapez 3 pour sauvegarder les notes dans un fichier.");
            	System.out.println("Tapez 4 pour sauvegarder les notes dans un fichier sous forme d'objet.");
            	System.out.println("Tapez 5 pour charger un fichier de notes stockées sous forme d'objets.");
            	System.out.println("Tapez 6 pour quitter.");
            	n = in.nextInt();
            
            	switch(n){
            	case 1:
            		System.out.println("Veuillez entrez le nom du fichier à lire : ");
            		fichier = in.next();
            		try{
                            mesNotes =lireFichierNotes(fichier);
                            System.out.println(mesNotes);
                        }
            		catch (FileNotFoundException e){System.out.println("Fichier inexistant");}
                	break;
            	case 2:
            		mesNotes=saisirNote();
                	break;
            	case 3: 
            		System.out.println("Veuillez entrez le nom du fichier de sauvegarde : ");
            		fichier = in.next();
                        try{
                        	ecrireFichierNotes(fichier,mesNotes);
                        }
                        catch (IOException e){System.out.println("Problème de fichier");}
                	break;
            	case 4: 
            		System.out.println("Veuillez entrez le nom du fichier de sauvegarde : ");
            		fichier = in.next();
                        try{
                        	ecrireFichierObjetNotes(fichier,mesNotes);
                        }
                        catch (IOException e){System.out.println("Problème de fichier");}
                	break;
            	case 5:
            		System.out.println("Veuillez entrez le nom du fichier à lire : ");
            		fichier = in.next();
            		try{
                            mesNotes =lireFichierObjetNotes(fichier);
                            System.out.println(mesNotes);
                        }
            		catch (FileNotFoundException e1){System.out.println("Fichier inexistant");}
            		catch (IOException e2){System.out.println("Problème de fichier");}
                	break;
            	case 6: 
                	System.exit(0);
            	default: 
                	System.out.println("il faut saisir un nombre entre 1 et 4.");
                 	break;
                
            	}
 		}
	}


}
