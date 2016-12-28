package td2.exo;

public class Heure {
	private int minutes;
	//private int heures;
	public Heure (int minutes, int heures){
		this.minutes=minutes;
		//this.heures=heures;
	}
	public int getMinutes() {
		//return minutes;
		return minutes%60;
	}
	public int getHeures() {
		//return heures;
		return minutes/60;
	}
}
