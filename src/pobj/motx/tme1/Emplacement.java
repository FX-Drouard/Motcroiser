package pobj.motx.tme1;
import java.util.ArrayList;

/**
* Classe permettant de gérer les mots dont les lettres sont contenues dans des Cases!
*/ 
public class Emplacement {
	/** attribut permettant de stocker un mot à partir des Cases! **/
	private ArrayList<Case> cases;
	
	/**
	* Construit un Emplacement contenant les Cases qui contiennent les lettres d'un mot 
	*/ 
	public Emplacement() {
		this.cases = new ArrayList<Case>();	
	}
	
	/**
	* Ajoute à l'Emplacement une Case
	* @param e La Case en question
	*/
	public void addCase(Case e) {
		this.cases.add(e);
	}
	
	/**
	* Permet d'afficher la taille de l'Emplacement
	* @return la taille
	*/
	public int size() {
		return this.cases.size();
	}
	
	/**
	* Donne accès à la Case n° i de l'Emplacement
	* @param i Le numéro de la Case en question
	* @return la Case
	*/
	 public Case getCase(int i) {
		 return this.cases.get(i);
	 }
	 
	 /**
		* Ecrit le contenue de l'Emplacement
		* @return Le mot généré
		*/
	 public String toString() {
		 String res="";
		 for (int i = 0; i<this.cases.size(); i++) {
			 res+=this.cases.get(i).getChar();
		 }
		 return "Le mot est: "+res;
	 }
	 
	 public boolean hasCaseVide() {
		 for (int i=0;i<this.cases.size();i++) {
			 if (this.cases.get(i).isVide()) {return true;}
		 }
		 return false;
	 }
}
