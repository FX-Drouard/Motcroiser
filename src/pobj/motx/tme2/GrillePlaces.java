package pobj.motx.tme2;
import java.util.List;
import pobj.motx.tme1.*;
import java.util.ArrayList;

/**
* Classe permettant de gérer une Grille de Case et ses emplacements
*/ 
public class GrillePlaces {
/** attribut permettant de stocker les Emplacement de case **/
private List<Emplacement> places;
/** attribut permettant de stocker l'indice du dernier emplacement horizontal! **/
private int hor =0;
/** attribut permettant de stocker la grille**/
private Grille grill;

/**
* Construit une GrillePlaces une grille, et ses emplacements:
* @param grille La grille de depart
*/ 
public GrillePlaces (Grille grille) {
	this.grill=grille;
	//on commence par l'Horizontal
	this.places=new ArrayList<>();
	for (int i = 0; i<grille.nbLig();i++) {
		this.cherchePlacesLignes(this.getLig(grille,i));
	}
	
	//Vertical
	for (int j=0; j<grille.nbCol();j++) {
		this.cherchePlacesColonnes(this.getCol(grille,j));
	}
}

/**
* initialise la list des emplacement en ligne:
* @param x La liste de Case a chercher
*/ 
private void cherchePlacesLignes(List <Case> cases) {
	Emplacement e = new Emplacement();
	int i;
	for (i =0; i<cases.size();i++) {
		if (cases.get(i).getChar() != '*') {
			e.addCase(cases.get(i));
		}else {
			if (e.size() >1) {
				places.add(e);
				this.hor++;
			}
			e = new Emplacement();
		}
	}
	if (e.size() >=2) {
		places.add(e);
		e= new Emplacement();
		hor++;
	}
}

/**
* initialise la list des emplacement en Colonne:
* @param x La liste de Case a chercher
*/ 
private void cherchePlacesColonnes(List <Case> cases) {
	Emplacement e = new Emplacement();
	int j;
	for (j =0; j<cases.size();j++) {
		if (cases.get(j).getChar() != '*') {
			e.addCase(cases.get(j));
		}else {
			if (e.size() >=2) {
				places.add(e);
			}
			e = new Emplacement();
		}
	}
	if (e.size() >=2) {
		places.add(e);
		e= new Emplacement();
	}
}

/**
* Permet d'obtenir la list des emplacements
* @return la liste des emplacements
*/
public List<Emplacement> getPlaces() {
	return places;
}
/**
* Permet d'afficher le nombre d'emplacement horizontaux
* @return le nombre d'emplacement horizontaux
*/
public int getNbHorizontal() {
	return hor;
}

/**
* Permet d'obtenir la list des case d'une ligne
* @param g La grille
* @param i L'indice de la ligne
* @return la list des case d'une ligne
*/
private List<Case> getLig(Grille g, int i){
	List<Case> temp = new ArrayList<>();
	for (int r=0;r<g.nbCol();r++) {
		temp.add(g.getCase(i, r));
	}
	return temp;
}

/**
* Permet d'obtenir la list des case d'une colonne
* @param g La grille
* @param j L'indice de la colonne
* @return la list des case d'une colonne
*/
private List<Case> getCol(Grille g, int j){
	List<Case> temp = new ArrayList<>();
	for (int r=0;r<g.nbLig();r++) {
		temp.add(g.getCase(r, j));
	}
	return temp;
}

/**
* Permet de modifier une grille avec un mot a rentrer
* @param m L'indice de l'emplacement
* @param soluce le mot
* @return une nouvelle GrillePlaces modifier
*/
public GrillePlaces fixer(int m, String soluce) {
	Grille tmp2=this.grill.copy();
	GrillePlaces res= new GrillePlaces(tmp2);
	Emplacement e= new Emplacement();
	for (int i =0; i<soluce.length();i++) {
		char tmp = soluce.charAt(i);
		Case tmp3=res.getPlaces().get(m).getCase(i);
		tmp3.setChar(tmp);
		e.addCase(tmp3);
	}
	res.getPlaces().set(m, e);
	return res;
}

/**
* Permet d'obtenir la grille
* @return le nombre de ligne
*/
public Grille getGrille() {
	return grill.copy();
}



}
