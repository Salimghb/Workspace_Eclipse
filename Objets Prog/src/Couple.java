
public class Couple {
	public double v1;
	public int v2;

	public Couple() {

		v1=0;
		v2=0;
	}

	public Couple (double x, int y) {
		v1=x;
		v2=y;
	}

	public String toString() {

		return "(" + v1 + ";" + v2 + ")" ;
	}
}