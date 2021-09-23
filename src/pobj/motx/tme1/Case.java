package pobj.motx.tme1;
/**
 * 
 * @author Alexandre XIA and Francois Xavier Drouard
 * Classe de representation d'une case d'une grille de mot croise
 */
public class Case {
	/** les coordonnées abscisse et ordonnée d'une case */
	private int lig,col;
	/** l'état de la case si celle-ci contient une lettre ou non (vide ou pleine) */
	private char c;
	
	/**
	 * Construit une case avec ses coordonnées et son état
	 * @param lig l'abscisse de la case
	 * @param col l'ordonnée de la case
	 * @param c l'état de la case
	 */
	public Case(int lig, int col, char c) {
		this.lig=lig;
		this.col=col;
		this.c=c;
	}

	/**
	 * accès à la l'abscisse de la case
	 * @return la coordonnée abscisse ligne (lig) de la case
	 */
	public int getLig() {
		return lig;
	}

	/**
	 * accès à l'ordonnée de la case
	 * @return la coordonnée ordonné colonne (col) de la case
	 */
	public int getCol() {
		return col;
	}

	/**
	 * accès à l'état de la case
	 * @return l'état de la case si elle est vide, pleine ou contient une lettre
	 */
	public char getChar() {
		return c;
	}

	/**
	 * change le caractère courant de l'objet
	 * @param c le caractère qui remplacera l'ancien
	 */
	public void setChar(char c) {
		this.c = c;
	}

	/**
	 * vérifie si un caractère est vide
	 * @return true si le caractère est vide false sinon
	 */
	public boolean isVide() {
		return this.c==' ';
	}
	
	/**
	 * vérifie si un caractère est plein
	 * @return true si le caractère est plein false sinon
	 */
	public boolean isPleine() {
		return this.c=='*';
	}
	
	
	
}
