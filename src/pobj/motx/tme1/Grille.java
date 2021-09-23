package pobj.motx.tme1;

/**
* Classe permettant de gérer une Grille de Case
*/ 
public class Grille {
	
	/** attribut permettant de stocker les Cases dans un double tableau! **/
	private Case la[][];
	
	/**
	* Construit une Grille contenant les Cases a partire de deux parametre:
	* @param hauteur La hauteur de la Grille
	* @param largeur La Largeur de la Grille
	*/ 
	public Grille(int hauteur, int largeur) {
		this.la= new Case[hauteur][largeur];
		for (int i=0; i<hauteur;i++) {
			for (int j=0; j<largeur;j++) {
				this.la[i][j]=new Case(i,j,' ');
			}
		}
	}
	
	/**
	* Donne le contenue de la case (x,y) de la grille:
	* @param x L'absice de la case
	* @param y L'ordonnée de la case
	* @return La Case
	*/ 
	public Case getCase(int x, int y) {
		return la[x][y];
	}
	
	/**
	* Ecrit le contenue de la Grille
	* @return La Grille
	*/
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	/**
	* Permet d'afficher le nombre de ligne de la Grille
	* @return le nombre de ligne
	*/
	public int nbLig() {
		return this.la.length;
	}
	
	/**
	* Permet d'afficher le nombre de colonne de la Grille
	* @return le nombre de colonne
	*/
	public int nbCol() {
		return this.la[0].length;
	}
	
	/**
	* Permet de copier proprement une Grille en copiant le contenue de celle ci
	* @return la nouvelle Grille
	*/
	public Grille copy() {
		Grille res=new Grille(this.nbLig(),this.nbCol());
		for (int i=0;i<this.nbLig();i++) {
			for (int j=0;j<this.nbCol();j++) {
				res.la[i][j]=new Case(this.la[i][j].getLig(),this.la[i][j].getCol(),this.la[i][j].getChar());
			}
		}
		
		return res;
	}
}
