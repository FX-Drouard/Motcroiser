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
		List<Character> l1=
	}
}
