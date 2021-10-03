package pobj.motx.tme2;
import java.util.List;
import pobj.motx.tme1.*;
import java.util.ArrayList;

public class GrillePlaces {
private List<Emplacement> places;
private int hor =0;

public GrillePlaces (Grille grille) {
	//on commence par l'Horizontal
	for (int i = 0; i<grille.nbLig();i++) {
		this.cherchePlacesLignes(this.getLig(grille,i));
	}
	
	//Vertical
	for (int j=0; j<grille.nbCol();j++) {
		this.cherchePlacesColonnes(this.getCol(grille,j));
	}
}

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


public List<Emplacement> getPlaces() {
	return places;
}

public int getnbHorizontal() {
	return hor;
}





}
