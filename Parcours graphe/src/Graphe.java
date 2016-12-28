import java.util.*;

public class Graphe {
	private HashMap<Configuration, Configuration> MAP;

	public Graphe(HashMap<Configuration,Configuration> map){
		HashMap<Configuration,Configuration>MAP = map;
	}

	public String todoRec(Configuration c, HashSet<Configuration> set){
		if (set.contains(c)){
			return "";
		}
		set.add(c);
		StringBuffer res = new StringBuffer();
		res.append("\tN"+c.ident()+"[label="+c+"]\n");
		for(Integer a : g.action(c)){
			Configuration cprim=g.succ(c,a);
			res.append(todoRec(cprim,set));
			res.append("\tN"+cprim.ident()+"=>N"+cprim.ident()+"\n");
		}
		return res.toString();
	}

	public HashMap<Configuration, Configuration> getMap() {
		return MAP;
	}

	public void setMap(HashMap<Configuration, Configuration> mAP) {
		MAP = mAP;
	}
}
interface Configuration {
	public int ident();
}
