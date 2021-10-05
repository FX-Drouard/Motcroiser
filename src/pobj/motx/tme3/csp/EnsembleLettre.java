package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	private List<Character> s;
	
	public EnsembleLettre() {
		this.s=new ArrayList<>();
	}
	public void add(Character l) {
		if(!this.s.contains(l)){
			this.s.add(l);
		}
	}
	
	public int size() {return this.s.size();}
	
	public static void inter(List<Character> l1,List<Character> l2){
		l1.retainAll(l2);
	}
	
	public static List<Character> copy(List<Character> l){
		List<Character> res = new ArrayList<>();
		for (int i = 0;i< l.size();i++) {
			res.add(l.get(i));
		}
		return res;
	}
	
	public boolean contains(Character c) {return this.s.contains(c);}
	
	public List<Character> getLS(){
		return this.s;
	}
	
	
}
