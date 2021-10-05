package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;

public class CroixContrainte implements IContrainte {
	private int m1,c1,m2,c2;
	
	public CroixContrainte(int a,int b,int c,int d) {
		this.m1=a;
		this.m2=c;
		this.c1=b;
		this.c2=d;
	}
	
	
	public int reduce(GrillePotentiel grille) {
		List<Dictionnaire>dic=grille.getMotsPot();
		Dictionnaire d1=dic.get(m1);
		Dictionnaire d2=dic.get(m2);
		EnsembleLettre l1=d1.ensl(c1);
		EnsembleLettre l2=d2.ensl(c2);
		List<Character> s= EnsembleLettre.copy(l1.getLS());
		EnsembleLettre.inter(s, l2.getLS());
		int cpt=0;
		if (s.size()>l1.getLS().size()) {
			cpt+=d1.filtreInd(c1, l1);
		}else {
			EnsembleLettre g= new EnsembleLettre(s);
			cpt+=d1.filtreInd(c1, g);
		}if (s.size()>l2.getLS().size()) {
			cpt+=d2.filtreInd(c1, l2);
		}else {
			EnsembleLettre g= new EnsembleLettre(s);
			cpt+=d2.filtreInd(c1, g);
		}
		return cpt;
		
	}
}
