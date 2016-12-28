package tp3.exo2;

public class Manager extends Employe {
	private String dateFonction;
	private static int augmentationManager=15;
	public Manager(String nom, String dateEmbauche, String dateFonction) {
		super(nom,dateEmbauche,2000);
		this.dateFonction=dateFonction;
	}
	public String toString() {
		return  "\n Statut : Manager \n" + super.toString() +
				"\n Date d'entrée en fonction :"+ dateFonction;
	}
	public void augmenteSalaire(String dateCourante){
		augSalaire(dateCourante);
	}
	public static int getAugmentationManager() {
		return augmentationManager;
	}
	public static void setAugmentationManager(int augmentationManager) {
		Manager.augmentationManager = augmentationManager;
	}
}
