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
		//On parcours chaque emplacement de la grille et créer le dictionnaire correspondant
		for(int i=0;i<this.grille.getPlaces().size();i++){
			Dictionnaire copium= dicoComplet.copy();
			copium.filtreLongueur(this.grille.getPlaces().get(i).size());
			/*List<Emplacement> tmp=this.grille.getPlaces();
			//On doit parcourir chaque emplacement pour vérifier s'il contient déjà lettres (Question 2.4.2)
			for(int j=0;j<tmp.get(i).size();j++) {
				copium.filtreParLettre(tmp.get(i).getCase(j).getChar(),j);					
			}*/
			motsPot.add(copium);
		}
	}
	
	public boolean isDead() {
		if (motsPot==null) {return false;}
		for(int i=0;i<motsPot.size();i++) {
			if(motsPot.get(i)==null) {
				return true;
			}
		}
		return false;
	}
	
	public List<Dictionnaire> getMotsPot(){
		return this.motsPot;
	}
}
