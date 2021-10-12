package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.Dictionnaire;


/**
* Classe permettant de gerer des dictionnaires variable pour un emplacement
*/ 
public class DicoVariable implements IVariable{
	/**attribut correspondant à l'indice de l'emplacement du mot**/
	private int index;
	/**attribut correspondant à la Grille utilisée**/
	private GrilleContrainte gp;
	
	
	/**
	* Constructeur du dictionnaire variable correspondant à la grille contrainte en paramètre
	* @param index l'indice de l'emplacement du mot
	* @param dicoComplet la grille contrainte du dictionnaire
	*/ 
	public DicoVariable(int index,GrilleContrainte gp) {
		this.index=index;
		this.gp=gp;
	}

	/**
	* Accesseur sur les domaines potentiels de la grille
	* @return les domaines potentiels de la grille
	*/ 
	@Override
	public List<String> getDomain() {
		Dictionnaire tmp = gp.getMotsPot().get(this.index);
		return tmp.getListe();
	}

	/**
	 * Accesseur sur les information du dictionnaire variable
	 * @return les informations sur le dictionnaire variable
	 */
	@Override
	public String toString() {
		return "DicoVariable [index=" + index + ", gp=" + gp.getGPlaces() + ", getDomain()=" + getDomain() + "]";
	}

	/**
	 * accesseur sur la grille contrainte
	 * @return la grille contrainte
	 */
	public GrilleContrainte getGp() {
		return gp;
	}
	
	public int getInd() {
		return index;
	}
	
	
	
	
	

}
