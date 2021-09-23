package pobj.motx.tme1;

public class Grille {
private Case la[][];

	public Grille(int hauteur, int largeur) {
		this.la= new Case[hauteur][largeur];
		for (int i=0; i<hauteur;i++) {
			for (int j=0; j<largeur;j++) {
				//this.la[i][j]=new Case(hauteur,largeur,' '); <- ceci est l'erreur
				this.la[i][j]=new Case(i,j,' ');
			}
		}
	}

	public Case getCase(int x, int y) {
		return la[x][y];
	}
	
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	public int nbLig() {
		return this.la.length;
	}
	
	public int nbCol() {
		return this.la[0].length;
	}
	
	public Grille copy() {
		Grille temp=new Grille(this.nbLig(),this.nbCol());
		for (int i=0;i<this.nbLig();i++) {
			for (int j=0;j<this.nbCol();j++) {
				temp.la[i][j]=new Case(this.la[i][j].getLig(),this.la[i][j].getCol(),this.la[i][j].getChar());
			}
		}
		
		return temp;
	}
}
