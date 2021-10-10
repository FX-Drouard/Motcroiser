package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;
/**
* Classe permettant de stocker un ensemble de character
*/ 
public class EnsembleLettre {
	/**attribut correspondant à la List des character**/
	private List<Character> s;
	/**
	* Constructeur de l'ensemble
	*/ 
	public EnsembleLettre() {
		this.s=new ArrayList<>();
	}
	/**
	* Constructeur de l'ensemble avec la List deja initialiser et remplie
	* @param s la List deja remplie
	*/ 
	public EnsembleLettre(List<Character> s) {
		this.s=s;
	}
	/**
	* Ajoute a la List un Character si inexistant dans la List
	* @param l Character a ajouter
	*/ 
	public void add(Character l) {
		if(!this.s.contains(l)){
			this.s.add(l);
		}
	}
	/**
	* Renvoie la taille de l'ensemble
	* @return la taille de l'ensemble
	*/ 
	public int size() {return this.s.size();}
	
	/**
	* stock dans l1 l'intersection de l1 et l2
	* @param l1 list source 1 et destination!
	* @param l2 list source 2
	*/ 
	public static void inter(List<Character> l1,List<Character> l2){
		l1.retainAll(l2);
	}
	/**
	* Copie la list dans une nouvelle instance
	* @param l list source
	* @return une nouvele List toute neuve
	*/ 
	public static List<Character> copy(List<Character> l){
		List<Character> res = new ArrayList<>();
		for (int i = 0;i< l.size();i++) {
			res.add(l.get(i));
		}
		return res;
	}
	/**
	* Dis si la List contient un character c
	* @param c Character a évaluer
	* @return true si contient
	*/ 
	public boolean contains(Character c) {return this.s.contains(c);}
	/**
	* Donne la List
	* @return la List 
	*/ 
	public List<Character> getLS(){
		return this.s;
	}
	
	
}
