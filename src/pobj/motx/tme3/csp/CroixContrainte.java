package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;

/**
 * Gere les croisement entre different emplacement.
 *
 */
public class CroixContrainte implements IContrainte {
	/** attribut permettant de stocker l'index de l'emplacement! **/
	private int m1,m2;
	/** attribut permettant de stocker les cases! **/
	private int c1,c2;
	
	/**
	* Construit une CroixContrainte avec ses contrainte en emplacement:
	* @param a index d'emplacement 1
	* @param b case 1
	* @param c index d'emplacement 2
	* @param d case 2
	*/
	public CroixContrainte(int a,int b,int c,int d) {
		this.m1=a;
		this.m2=c;
		this.c1=b;
		this.c2=d;
	}
	
	/**
	* Permet de mettre a jour les domaines potentiels avec l'intercection des contraintes
	* @param grille La grille
	* @return nombre de mots filtrer
	*/
	public int reduce(GrillePotentiel grille) {
		List<Dictionnaire>dic=grille.getMotsPot();
		Dictionnaire d1=dic.get(m1);
		Dictionnaire d2=dic.get(m2);
		EnsembleLettre l1=d1.ensl(c1);
		EnsembleLettre l2=d2.ensl(c2);
		List<Character> s= EnsembleLettre.copy(l1.getLS());
		EnsembleLettre.inter(s, l2.getLS());
		int cpt=0;
		EnsembleLettre g= new EnsembleLettre(s);
		if (s.size()<l1.getLS().size()) {
			cpt+=d1.filtreInd(c1, g);
		}else {			
			cpt+=d1.filtreInd(c1, l1);
		}if (s.size()<l2.getLS().size()) {
			cpt+=d2.filtreInd(c2, g);
		}else {
			cpt+=d2.filtreInd(c2, l2);
		}
		return cpt;
		
	}

	/**
	* Permet d'obtenir m1
	* @return m1
	*/
	public int getM1() {
		return m1;
	}

	/**
	* Permet d'obtenir c1
	* @return c1
	*/
	public int getC1() {
		return c1;
	}

	/**
	* Permet d'obtenir m2
	* @return m2
	*/
	public int getM2() {
		return m2;
	}

	/**
	* Permet d'obtenir c2
	* @return c2
	*/
	public int getC2() {
		return c2;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o){
			return true;
		}
		if(!(o instanceof CroixContrainte)) {
			return false;
		}
		
		CroixContrainte tmp= (CroixContrainte)o;
		return (tmp.m1==this.m1 && tmp.m2==this.m2 && tmp.c1==this.c1 && tmp.c2==this.c2 );
	}
	
}
