package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dikushioneiru;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille,Dictionnaire dicoComplet){
		this.grille=grille;
		this.dikushioneiru=dicoComplet;
		//CHAQUE dictionnaire sera limité dans l'ordre des emplacements
		List<Dictionnaire> motsPot= new ArrayList<>();
		for(int i=0;i<this.grille.getPlaces().size();i++){
			Dictionnaire copium= dicoComplet.copy();
			copium.filtreLongueur(this.grille.getPlaces().get(i).size());
			motsPot.add(copium);
		}
	}
	
	public boolean isDead() {
		for(int i=0;i<motsPot.size();i++) {
			if(motsPot.get(i)==null) {
				return true;
			}
		}
		return false;
	}
}
