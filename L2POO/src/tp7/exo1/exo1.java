package tp7.exo1;
import java.util.*;

public class exo1 {
	public static boolean verifParenthesage(String exp){
		String[]tab=exp.split(" ");
		Deque <String> p=new ArrayDeque<String>();
		for (int i=0;i<tab.length;i++){
			if (tab[i].equals("(") || tab[i].equals("{") || tab[i].equals("[")){
				p.addFirst(tab[i]);
			}
			else{
				if (tab[i].equals(")") || tab[i].equals("}") || tab[i].equals("]")){
					if(p.isEmpty()){
						return false;
					}
					if(tab[i].equals(p.getFirst())){
						p.removeFirst();
					}else{
						return false;
					}
				}
			}
		}
		if(p.isEmpty()){
			return true;
		}
		return false;	 
	}
}
