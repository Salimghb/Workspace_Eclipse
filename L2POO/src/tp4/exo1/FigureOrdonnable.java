package tp4.exo1;
import java.awt.*;

@SuppressWarnings("unused")
public abstract class FigureOrdonnable implements Ordonnable{
	
	public abstract double aire();

	public String toString() {
		return "Aire de la figure:"+aire();
	}
}
