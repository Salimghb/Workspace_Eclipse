package projet;

public class Heure {
	private int minutes;
	private int heures;
	public Heure (int minutes, int heures){
			this.heures = heures;
			this.minutes = minutes;
	}
	public int getMinutes() {
		return minutes;
	}
	public int getHeures() {
		return heures;
	}

	//Redéfinition de compareTo() pour les heures (q9)
	public int compareTo(Heure horaire) {
		if(this.heures < horaire.heures){
			return -1;
		}
		else{
			if(this.heures > horaire.heures){
				return 1;
			}
			else{
				if(this.minutes < horaire.minutes){
					return -1;
				}
				else{
					if(this.minutes > horaire.minutes){
						return 1;
					}
				}
			}
		}
		return 0;
	}
	//Redéfinition de toString() pour les heures
	public String toString(){
		return heures+"h"+minutes;
	}
}
