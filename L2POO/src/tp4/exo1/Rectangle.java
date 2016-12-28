package tp4.exo1;

import java.awt.*;

public class Rectangle {
	Point p;
	int largeur;
	int hauteur;
	public Rectangle(Point p, int largeur,int hauteur){
		this.p=p;
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	public double aire(){
		return largeur*hauteur;
	}
}
