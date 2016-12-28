package tp6.exo1;

import java.io.*;
import java.util.*;

public class FormatageFichier {

	/*	public static void formater(File fichierJavaIn, File fichierJavaOut) throws FileNotFoundException, IOException, FormatException{
		int nbIndentation=0;
		String ligne = "";
		String mot = "";
		Scanner sc  = new Scanner (fichierJavaIn);
		FileWriter fw = new FileWriter(fichierJavaOut);
		PrintWriter pw = new PrintWriter(fw);
		try{
		while (sc.hasNextLine()){
			ligne = sc.nextLine();
			ligne=ligne.trim();//on enlève les espaces en début de ligne
			mot="";
			Scanner s = new Scanner(ligne);
			if (s.hasNext()){
				mot=s.next();
				if (mot.equals("}")){
					nbIndentation --;
				}
			}
			for (int i = 1 ; i<=nbIndentation; i++)
				pw.print("  ");

			pw.print(mot+ " ");	

			while (s.hasNext()){
				mot=s.next();

				if (mot.equals("{")){
					nbIndentation ++;
				}
				if (mot.equals("}")){
					nbIndentation --;
				}
				pw.print(mot+ " ");
			}
			pw.print("\n");	
			s.close();
		}
		}
		finally{
			sc.close();
			pw.flush();
			pw.close();
		}
		if (nbIndentation!=0)
			if (nbIndentation>0)
				throw new FormatException ("Il manque au moins une accolade fermante");
			else 
				throw new FormatException ("Il y a au moins une accolade fermante en trop");
	}*/
	public static void formater(File fichierJavaIn) throws FileNotFoundException, IOException, FormatException{
		int nbIndentation=0;
		String ligne = "";
		String mot = "";
		Scanner sc  = new Scanner (fichierJavaIn);
		FileWriter fw = new FileWriter(fichierJavaIn,true);
		PrintWriter pw = new PrintWriter(fw);
		try{
			pw.print("\n");
			while (sc.hasNextLine()){
				ligne = sc.nextLine();
				ligne=ligne.trim();//on enlève les espaces en début de ligne
				mot="";
				Scanner s = new Scanner(ligne);
				if (s.hasNext()){
					mot=s.next();
					if (mot.equals("}")){
						nbIndentation --;
					}
				}
				for (int i = 1 ; i<=nbIndentation; i++)
					pw.print("  ");

				pw.print(mot+ " ");	

				while (s.hasNext()){
					mot=s.next();

					if (mot.equals("{")){
						nbIndentation ++;
					}
					if (mot.equals("}")){
						nbIndentation --;
					}
					pw.print(mot+ " ");
				}
				s.close();
				pw.print("\n");	
			}
		}
		finally{
			sc.close();
			pw.flush();
			pw.close();
		}
		if (nbIndentation!=0)
			if (nbIndentation>0)
				throw new FormatException ("Il manque au moins une accolade fermante");
			else 
				throw new FormatException ("Il y a au moins une accolade fermante en trop");
	}



	public static void main(String[] args) {
		/*
		 File fi = new File ("fichierJavaIn.txt");
		 File fo = new File ("fichierJavaOut.txt");
		 try {
			formater(fi,fo);

		} catch ( FormatException e) {
			System.out.println(e.getMessage());
		}
		 catch (  FileNotFoundException  e) {
				e.printStackTrace();
	 }
		 catch (  IOException  e) {
				e.printStackTrace();
	 }
		 */
		File fib = new File ("fichierJavaInBis.txt");

		try {
			formater(fib);
		} 
		catch ( FormatException e) {
			System.out.println(e.getMessage());
		}
		catch (  FileNotFoundException  e) {
			e.printStackTrace();
		}
		catch (  IOException  e) {
			e.printStackTrace();
		}

	}
}
