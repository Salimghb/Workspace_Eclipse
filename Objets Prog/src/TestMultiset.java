public class TestMultiset {
	@SuppressWarnings("unused")
	private static boolean b;
	public static void main (String [] args){
		Multiset multi = new Multiset();
		multi.ajout(2.5,1);
		b = multi.ajout(1,3);
		b = multi.ajout(3.2,2);
		b = multi.ajout(1,1);
		System.out.println ("m = "+multi.toString());
		b = multi.ajout(1,5);
		System.out.println ("m = "+multi.toString());
		multi.supprimer(2.5,5);
		System.out.println ("m = "+multi.toString());
		System.out.println ("Nombre de couples = " + multi.NbCouple());
		System.out.println ("Nombre de valeurs = " + multi.NbValeurs());
	}
}