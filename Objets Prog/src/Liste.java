public class Liste{

	public Maillon tete = null;

	public static void ajoutTete(Liste l, int x){
		l.tete = new Maillon(x,l.tete);
	}

	public static Liste concatene(Liste l1, Liste l2){
		Liste res = l1.copie();
		if (l2.estListeVide()) return res;
		Liste l2_1 = l2.copie();
		concatene (res.tete,l2_1);
		return res;
	}

	public static void concatene (Maillon m, Liste l){
		if(m.suivant == null) m.suivant = l.tete;
		else concatene(m.suivant, l);
	}

	public Liste copie(){
		Liste res = new Liste();
		Maillon p;
		Maillon q;
		if(this.estListeVide()){ 
			return res;
		}
		res.tete = new Maillon (tete.info, null);
		p = tete.suivant;
		q = res.tete;
		while(p != null){
			q.suivant = new Maillon(p.info,null);
			p = p.suivant;
			q = q.suivant;
		}
		return res;
	}

	public boolean estListeVide(){
		if (this.tete != null) return true;
		return false;
	}

	public String toString(){
		String s = Messages.getString("Liste.0"); //$NON-NLS-1$
		Maillon m = this.tete;
		while(m != null ){
			s = s + m.info +Messages.getString("Liste.1"); //$NON-NLS-1$
			m = m.suivant;
		}
		return s + Messages.getString("Liste.2"); //$NON-NLS-1$
	}


	public static void main (String [] args){
		Liste a = new Liste ();
		for (int i=5; i>=0;i--){
			ajoutTete(a,i);
		}
		Liste b = new Liste ();
		for (int i=15; i>=10;i--){
			ajoutTete(b,i);
		}
		System.out.println(a.toString());
		System.out.println(b.toString());
		Liste c = concatene(a,b);
		System.out.println(c.toString());
	}
}
