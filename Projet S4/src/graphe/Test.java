package graphe;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		
	// creation des listes-chainées	
	LinkedList<String> s1 = new LinkedList<String>();
    s1.add("s2");
    s1.add("s3");
    s1.add("s4");
    
    LinkedList<String> s2 = new LinkedList<String>();
    s2.add("s4");
    
    LinkedList<String> s3 = null;
    
    LinkedList<String> s4 = new LinkedList<String>();
    s4.add("s3");
    
    
    // creation liste d'adjacence
    @SuppressWarnings("rawtypes")
	LinkedList[] r;
    r = new LinkedList[4];
    r[0] = s1;
    r[1] = s2;
    r[2] = s3;
    r[3] = s4;
    
    
    // creation tableau string pour affichage
    String[] h = new String[4];
    
    
    // pseudo-parcours de graphe
    for(int i=0; i<r.length; i++) {
    	
    	if(r[i] == null) {
    		h[i] = "( "+i+" ) -> vide";
    	}
    	else {
    		LinkedList<?> q = r[i];
    		h[i] = pseudoParcours(q,i);  
    	}
    }
    
    for(int i=0; i<h.length; i++) {
    	System.out.println(h[i]);
    }
    
  }
	// methode qui renvoi sommets parcourus à partir d'un sommet initial
	public static String pseudoParcours(LinkedList<?> q, int k) {
		
		int j= q.size();
		String g = "( "+k+" ) -> ";
		for(int i=0; i<q.size(); i++) {
			if(j-i == 1) {
				g = g + q.get(i);
			}
			else {
				g = g +q.get(i)+" -> ";
			}
			
		}
		return g;
		
	}
    
}
	

	
	

