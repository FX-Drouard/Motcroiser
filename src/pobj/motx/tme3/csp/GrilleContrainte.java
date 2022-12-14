package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme2.GrillePotentiel;

import java.util.ArrayList;

/**
* Classe permettant de gérer les contraintes de la grille
*/ 
public class GrilleContrainte extends GrillePotentiel{
	/**attribut correspondant à la liste des contraintes**/
	private List<IContrainte> contraintes;

	/**
	 * Constructeur de la GrilleContrainte en fonction de la grille GrillePlaces
	 * @param grille la grille GrillePlaces
	 * @param dicoComplet Le dictionnaire français complet
	 */
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
	
	
	/**
	 * fixe la GrilleContrainte en ajoutant un mot à l'emplacement correspondant
	 * @param m l'indice des cases constituants l'emplacement
	 * @param soluce le mot solution qui sera placé
	 * @return la nouvelle grille contrainte après le fixage
	 */
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces tmpG = super.getGPlaces().fixer(m,soluce);
		GrilleContrainte res= new GrilleContrainte(tmpG, super.getDico());	
		return res;
	}
	
	/**
	 * accesseur sur la liste des contraintes
	 * @return la liste des contraintes
	 */
	public List<IContrainte> getContraintes(){
		return this.contraintes;
	}
	
	/**
	 * stabilise la liste de domaine potentiel de chaque emplacement à partir des contraintes
	 * @return true si tout est stabilisée, false si la grille est irréalisable
	 */
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
