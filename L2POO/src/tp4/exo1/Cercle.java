package tp4.exo1;

import java.awt.*;

public class Cercle {
	Point p;
	int rayon;
	public Cercle(Point p, int rayon){
		this.p=p;
		this.rayon=rayon;
	}
	public double aire(){
		return  rayon*rayon*Math.PI;
	}
}
