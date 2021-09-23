package pobj.motx.tme1;
/**
 * 
 * @author Alexandre XIA and Francois Xavier Drouard
 * Classe de representation d'une case d'une grille de mot croise
 */
public class Case {
	/** les coordonnees abscisse et ordonnee d'une case */
	private int lig,col;
	private char c;
	
	public Case(int lig, int col, char c) {
		this.lig=lig;
		this.col=col;
		this.c=c;
	}

	public int getLig() {
		return lig;
	}


	public int getCol() {
		return col;
	}


	public char getChar() {
		return c;
	}

	public void setChar(char c) {
		this.c = c;
	}

	public boolean isVide() {
		return this.c==' ';
	}
	
	public boolean isPleine() {
		return this.c=='*';
	}
	
	
	
}
