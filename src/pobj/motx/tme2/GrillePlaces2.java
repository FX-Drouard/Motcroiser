package pobj.motx.tme2;

import java.util.List;
import pobj.motx.tme1.*;
import java.util.ArrayList;

public class GrillePlaces2 {
private List<Emplacement> places;
private int hor;

public GrillePlaces2 (Grille grille) {
	this.places = new ArrayList<>();
	int x = grille.nbLig();
	int y = grille.nbCol();
	this.hor=0;
	Emplacement temp = new Emplacement();
	for (int i =0; i<x;i++) {
		for (int j=0; j<y;j++) {
			if (grille.getCase(i, j).getChar()==' ') {
				places.add(temp);
				temp=new Emplacement();
			}else {
				temp.addCase(grille.getCase(i, j));
			}
		}
		places.add(temp);
		temp=new Emplacement();
	}
	hor=places.size();
	System.out.println("la= "+hor);
	for (int j =0; j<y;j++) {
		for (int i=0; i<x;i++) {
			if (grille.getCase(i, j).getChar()==' ') {
				places.add(temp);
				temp=new Emplacement();
			}else {
				temp.addCase(grille.getCase(i, j));
			}
		}
		places.add(temp);
		temp=new Emplacement();
	}
	
	
}

public List<Emplacement> getPlaces() {
	return places;
}


public int getNbHorizontal() {
	return this.hor-1;
}


}
