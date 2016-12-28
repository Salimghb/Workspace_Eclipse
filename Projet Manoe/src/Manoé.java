import java.util.Scanner;
public class Mano� {

	static Scanner in = new Scanner (System.in);

	static int compteurVictoiresJ1 = 0;

	static int compteurVictoiresJ2 = 0;

	/*cr�er un tableau vide*/
	public static char[][] TableauVide(char [][]t){
		for(int i=0; i<t.length; i++){
			for(int j=0; j<t[0].length; j++){
				t[i][j]= ' ';
			}
		}
		return t;
	}

	/*afficher le tableau*/
	public static void AfficheTableau( char[][]t){
		for(int i=0; i<t.length; i++){
			System.out.print(" "+"_"+i+"_");
		}
		System.out.println();
		for(int i=0; i<t.length; i++){
			System.out.print('|');
			for(int j=0; j<t[0].length; j++){
				System.out.print("_"+t[i][j]+"_"+"|");
			}
			System.out.println("");
		}
		System.out.println("");
	}


	/* pose un jeton dans le tableau */
	public static char[][] poserJeton(char[][]t,int colonne, char jeton){
		for(int j=t.length-1;j>=0;j--){
			if(t[j][colonne]==' '){
				t[j][colonne]=jeton;
				return t;
			}
		}
		return t;
	}


	/*effectue la rotation � droite*/
	public static char[][] rotationDroite(char[][]t){
		char[][]tabrotation = new char[7][7];
		TableauVide(tabrotation);
		for(int i=t.length-1;i>=0;i--){
			for(int j=t.length-1;j>=0;j--){
				if(t[i][j]!=' '){
					poserJeton(tabrotation,t.length-1-i,t[i][j]);
				}
			}
		}
		return tabrotation;
	}


	/*effectue la rotation � gauche*/
	public static char[][] rotationGauche(char[][]t){
		char[][]tabrotation = new char[7][7];
		TableauVide(tabrotation);
		for(int i=0;i<=t.length-1;i++){
			for(int j=0;j<=t.length-1;j++){
				if(t[i][j]!=' '){
					poserJeton(tabrotation,i,t[i][j]);
				}
			}
		}
		return tabrotation;
	}

	/* teste si la colonne o� le joueur veut jouer est correct*/
	public static int testColonne(int colonne, char[][]t){
		while(colonne<0 || colonne>6){
			System.out.println("La valeur entr�e est erron�e.");
			System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
			colonne= in.nextInt();
		}
		while(t[0][colonne]=='O' || t[0][colonne]=='X'){
			System.out.println("La colonne est pleine.");
			System.out.println("Entrez une nouvelle valeur.");
			System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
			colonne= in.nextInt();
		}
		return colonne;
	}


	/*teste la victoire (alignement de 4 jetons) */
	public static boolean Alignement(char [][] t,char c){
		boolean b = false;
		for(int i=0; i<4; i++){
			/*Test alignement Vertical*/
			for(int j=0 ; j<7; j++){
				if((t[i][j]==c && t[i+1][j]==c && t[i+2][j]==c && t[i+3][j]==c)){
					b = true;
				}
			}
			/*Test alignement horizontal*/
		}for(int i=0; i<7; i++){
			for(int j=3 ; j<7; j++){
				if((t[i][j]==c && t[i][j-1]==c && t[i][j-2]==c && t[i][j-3]==c)){
					b = true;
				}
			}
			/*Test alignement premi�re diagonale*/
		}for(int i=0; i<4; i++){
			for(int j=0 ; j<4; j++){
				if((t[i][j]==c && t[i+1][j+1]==c && t[i+2][j+2]==c && t[i+3][j+3]==c)){
					b = true;
				}
			}
			/*Test alignement seconde diagonale*/
		}for(int i=0; i<4; i++){
			for(int j=3 ; j<7; j++){
				if((t[i][j]==c && t[i+1][j-1]==c && t[i+2][j-2]==c && t[i+3][j-3]==c)){
					b = true;
				}
			}
		}
		return b;
	}


	
	/*commande pour jouer*/
	public static void Jouer(char[][]t, String j1, String j2,boolean s){
		int nombreRotationsJ1=4;
		int nombreRotationsJ2=4;
		char [][] tabRotationJ1 = new char [7][7];
		char [][] tabRotationJ2 = new char [7][7];
		char [][] tabAper�uJ1 = new char [7][7];
		char [][] tabAper�uJ2 = new char [7][7];
		int nombreAper�uJ1=2;
		int nombreAper�uJ2=2;
		for (int i=0;i<=42;i++){   
			/* d�but du tour du J1*/
			if(i%2==0){
				System.out.println("C'est le tour de " +j1);
				if(s){
					/*Rotation J1*/
					if(nombreRotationsJ1 != 0){
						System.out.println("Vous avez le droit d'effectuer "+nombreRotationsJ1+" rotation(s).");
						System.out.println("Voulez-vous effectuer une rotation ?");
						System.out.println("Entrez OUI ou NON.");
						String b1=in.next();
						if(b1.equalsIgnoreCase("OUI")){
							System.out.println("Vous avez le droit d'effectuer "+nombreAper�uJ1+" aper�u(s).");
							System.out.println("Voulez-vous afficher un aper�u de rotation ?");
							System.out.println("Entrez OUI ou NON.");
							String d1=in.next();
							boolean g1;
							g1=d1.equalsIgnoreCase("OUI");
							if(g1){
								System.out.println("Voulez-vous afficher un aper�u de rotation a DROITE ou a GAUCHE ?");
								System.out.println("Entrez DROITE ou GAUCHE.");
								String u1=in.next();
								if(u1.equalsIgnoreCase("DROITE")){
									tabAper�uJ1 = rotationDroite(t);
									AfficheTableau(tabAper�uJ1);
									nombreAper�uJ1--;
								}else{
									tabAper�uJ1 = rotationGauche(t);
									AfficheTableau(tabAper�uJ1);
									nombreAper�uJ1--;
								}
								System.out.println("T'es s�r de faire une rotation b�tard ?");
								System.out.println("Entrez OUI ou NON.");
								String y1=in.next();
								if(y1.equalsIgnoreCase("OUI")){
									boolean h1 = false;
									if(!h1){
										System.out.println("Entrez DROITE ou GAUCHE.");
										String q1=in.next();
										h1=q1.equalsIgnoreCase("DROITE");
										nombreRotationsJ1 = nombreRotationsJ1-1;
										if(h1){
											tabRotationJ1 = rotationDroite(t);
											AfficheTableau(tabRotationJ1);
											t = tabRotationJ1;
										}else{
											tabRotationJ1 = rotationGauche(t);
											AfficheTableau(tabRotationJ1);
											t = tabRotationJ1; 
										}
									}
									if(Alignement(t,'X')){
										AfficheTableau(t);
										System.out.println("VICTOIRE DE " + j1);
										compteurVictoiresJ1++;
										break;
									}
									if(Alignement(t,'O')){
										AfficheTableau(t);
										System.out.println("VICTOIRE DE " + j2);
										compteurVictoiresJ2++;
										break;
									}
								}else{
									System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
									int colonne= in.nextInt();
									colonne = testColonne(colonne,t);
									t = poserJeton(t,colonne,'X');
									AfficheTableau(t);
								}
								if(Alignement(t,'X')){
									AfficheTableau(t);
									System.out.println("VICTOIRE DE " + j1);
									compteurVictoiresJ1++;
									break;
								}
								if(Alignement(t,'O')){
									AfficheTableau(t);
									System.out.println("VICTOIRE DE " + j2);
									compteurVictoiresJ2++;
									break;
								}
							}else{
								boolean h1 = false;
								if(!h1){
									System.out.println("Entrez DROITE ou GAUCHE.");
									String q1=in.next();
									h1=q1.equalsIgnoreCase("DROITE");
									nombreRotationsJ1 = nombreRotationsJ1-1;
									if(h1){
										tabRotationJ1 = rotationDroite(t);
										AfficheTableau(tabRotationJ1);
										t = tabRotationJ1;
									}else{
										tabRotationJ1 = rotationGauche(t);
										AfficheTableau(tabRotationJ1);
										t = tabRotationJ1; 
									}
								}
							}
						}else{
							System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
							int colonne= in.nextInt();
							colonne = testColonne(colonne,t);
							t = poserJeton(t,colonne,'X');
							AfficheTableau(t);
						}
						if(Alignement(t,'X')){
							AfficheTableau(t);
							System.out.println("VICTOIRE DE " + j1);
							compteurVictoiresJ1++;
							break;
						}
					}
				}else{
					System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
					int colonne= in.nextInt();
					colonne = testColonne(colonne,t);
					t = poserJeton(t,colonne,'X');
					AfficheTableau(t);
					if(Alignement(t,'X')){
						System.out.println("VICTOIRE DE " + j1);
						compteurVictoiresJ1++;
						break;
					}
				}

				/*tour du joueur 2*/
			}else{
				System.out.println("C'est le tour de "+j2);
				if(s){ 
					/*Rotation J1*/
					if(nombreRotationsJ2 != 0){
						System.out.println("Vous avez le droit d'effectuer "+nombreRotationsJ2+" rotation(s).");
						System.out.println("Voulez-vous effectuer une rotation ?");
						System.out.println("Entrez OUI ou NON.");
						String b2=in.next();
						if(b2.equalsIgnoreCase("OUI")){
							System.out.println("Vous avez le droit d'effectuer "+nombreAper�uJ2+" aper�u(s).");
							System.out.println("Voulez-vous afficher un aper�u de rotation ?");
							System.out.println("Entrez OUI ou NON.");
							String d2=in.next();
							boolean g2;
							g2=d2.equalsIgnoreCase("OUI");
							if(g2){
								System.out.println("Voulez-vous afficher un aper�u de rotation a DROITE ou a GAUCHE ?");
								System.out.println("Entrez DROITE ou GAUCHE.");
								String u2=in.next();
								if(u2.equalsIgnoreCase("DROITE")){
									tabAper�uJ2 = rotationDroite(t);
									AfficheTableau(tabAper�uJ2);
									nombreAper�uJ2--;
								}else{
									tabAper�uJ2 = rotationGauche(t);
									AfficheTableau(tabAper�uJ2);
									nombreAper�uJ2--;
								}
								System.out.println("T'es s�r de faire une rotation b�tard ?");
								System.out.println("Entrez OUI ou NON.");
								String y2=in.next();
								if(y2.equalsIgnoreCase("OUI")){
									boolean h2 = false;
									if(!h2){
										System.out.println("Entrez DROITE ou GAUCHE.");
										String q2=in.next();
										h2=q2.equalsIgnoreCase("DROITE");
										nombreRotationsJ2 = nombreRotationsJ1-2;
										if(h2){
											tabRotationJ2 = rotationDroite(t);
											AfficheTableau(tabRotationJ2);
											t = tabRotationJ2;
										}else{
											tabRotationJ2 = rotationGauche(t);
											AfficheTableau(tabRotationJ2);
											t = tabRotationJ2; 
										}
									}
									if(Alignement(t,'X')){
										AfficheTableau(t);
										System.out.println("VICTOIRE DE " + j1);
										compteurVictoiresJ1++;
										break;
									}
									if(Alignement(t,'O')){
										AfficheTableau(t);
										System.out.println("VICTOIRE DE " + j2);
										compteurVictoiresJ2++;
										break;
									}
								}else{
									System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
									int colonne= in.nextInt();
									colonne = testColonne(colonne,t);
									t = poserJeton(t,colonne,'O');
									AfficheTableau(t);
								}
								if(Alignement(t,'X')){
									AfficheTableau(t);
									System.out.println("VICTOIRE DE " + j1);
									compteurVictoiresJ1++;
									break;
								}
								if(Alignement(t,'O')){
									AfficheTableau(t);
									System.out.println("VICTOIRE DE " + j2);
									compteurVictoiresJ2++;
									break;
								}
							}else{
								boolean h2 = false;
								if(!h2){
									System.out.println("Entrez DROITE ou GAUCHE.");
									String q2=in.next();
									h2=q2.equalsIgnoreCase("DROITE");
									nombreRotationsJ2 = nombreRotationsJ2-1;
									if(h2){
										tabRotationJ2 = rotationDroite(t);
										AfficheTableau(tabRotationJ2);
										t = tabRotationJ2;
									}else{
										tabRotationJ2 = rotationGauche(t);
										AfficheTableau(tabRotationJ2);
										t = tabRotationJ2; 
									}
								}
							}
						}else{
							System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
							int colonne= in.nextInt();
							colonne = testColonne(colonne,t);
							t = poserJeton(t,colonne,'O');
							AfficheTableau(t);
						}
						if(Alignement(t,'O')){
							AfficheTableau(t);
							System.out.println("VICTOIRE DE " + j2);
							compteurVictoiresJ2++;
							break;
						}
					}
					/*pose jeton du J2 sans rotations*/
				}else{
					System.out.println("Dans quelle colonne voulez-vous placer votre jeton?");
					int colonne= in.nextInt();
					colonne = testColonne(colonne,t);
					t = poserJeton(t,colonne,'O');
					AfficheTableau(t);
					if(Alignement(t,'O')){
						System.out.println("VICTOIRE DE " + j2);
						compteurVictoiresJ2++;
						break;
					}
				}
			}
		}
	}
	
	/*main*/
	public static void main (String[]args){
		int p = 0;
		while(true){
			p = p + 1;
			char[][]t = new char[7][7];
			System.out.println("Voulez-vous jouer contre une IA ou � deux?");
			System.out.println("Voulez-vous jouer avec les rotations?");
			System.out.println("Entrez OUI ou NON.");
			boolean s;
			String k=in.next();
			s=k.equalsIgnoreCase("OUI");
			System.out.println("Entrez le nom du joueur 1: ");
			String j1= in.next();
			System.out.println("Entrez le nom du joueur 2: ");
			String j2= in.next();
			TableauVide(t);
			AfficheTableau(t);
			Jouer(t,j1,j2,s);
			System.out.println("Voulez-vous rejouer ?");
			System.out.println("Entrez OUI ou NON.");
			String r1 = in.next();
			if(r1.equalsIgnoreCase("NON")){
				break;
			}
		}
		System.out.println();
		System.out.println("Vous avez jou� a "+ p + " partie(s)");
		System.out.println();
		System.out.println("Le joueur 1 a gagn� "+compteurVictoiresJ1+ " partie(s)");
		System.out.println();
		System.out.println("Le joueur 2 a gagn� " +compteurVictoiresJ2+ " partie(s)");
	}
}