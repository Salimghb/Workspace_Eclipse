	public class Maillon {
		 public int info;
		 public Maillon  suivant;

		 public Maillon(int c) {
		  info = c;
		  suivant = null;
		 }
		 public Maillon(int c, Maillon  n){
		  info = c;
		  suivant = n;
		 }
		 public int getItem() {
		  return info;
		 }
		 public void setItem(int _info){
		  info = _info;
		 }
		 public Maillon  getSuivant() {
		  return suivant;
		 }
		 public void setSuivant(Maillon  tete) {
		  suivant = tete;
		 }
		}

