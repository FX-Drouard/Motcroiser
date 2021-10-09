package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme2.GrillePotentiel;

import java.util.ArrayList;

public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;

	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille,dicoComplet);
		this.contraintes= new ArrayList<>();
		List<Emplacement> tmp = super.getGPlaces().getPlaces();
		
		for(int i=0;i<tmp.size();i++){
			Emplacement tmp2=tmp.get(i);
			for (int j=i+1;j<tmp.size();j++) {
				Emplacement tmp3=tmp.get(j);
				for(int i2=0;i2<tmp2.size();i2++) {
					for(int j2=0;j2<tmp3.size();j2++) {
						//Possibilité de passer par un equals
						if(tmp2.getCase(i2).getLig()==tmp3.getCase(j2).getLig() && tmp2.getCase(i2).getCol()==tmp3.getCase(j2).getCol()) {
							if(tmp2.getCase(i2).getChar()==' ') {	
								CroixContrainte aj= new CroixContrainte(i,i2,j,j2);
								this.contraintes.add(aj);
							}
						}
					}
				}
 			}
		}
		
		this.propage();
		
		//BOUCLE FOR POUR LE TEST2 QUI NECESSITE REDUCE POUR REUSSIR MAIS ON UTILISE QUAND MEME PROPAGE() ????
		/*for (int i=0;i<contraintes.size();i++) {
			contraintes.get(i).reduce(this);
		}*/


	}
	
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces tmpG = super.getGPlaces().fixer(m,soluce);
		GrilleContrainte res= new GrilleContrainte(tmpG, super.getDico());	
		return res;
	}
	
	public List<IContrainte> getContraintes(){
		return this.contraintes;
	}
	
	private boolean propage() {
		while(true){
			int cpt=0;
			
			for(int i =0; i<this.contraintes.size();i++) {
				cpt+=this.contraintes.get(i).reduce(this);
			}
			
			if(this.isDead()==true) {

				return false;
			}
			
			if(cpt==0) {
				return true;
			}
			
			
		}
	}

}
