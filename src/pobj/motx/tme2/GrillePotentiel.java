package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;

/**
* Classe permettant de gérer les mots potentiels de la grille
*/ 
public class GrillePotentiel {
	/** attribut correspondant à la grille actuelle**/
	private GrillePlaces grille;
	/** attribut correspondant au dictionnaire français complet **/
	private Dictionnaire dikushioneiru;
	/** attribut correspondant à la liste des mots potentiel pour chaque emplacement **/
	private List<Dictionnaire> motsPot;
	
	/**
	* Constructeur de la grille potentiel des mots de la grille GrillePlaces
	* @param grille grille dont on veut la grille potentielle
	* @param dicoComplet le dictionnaire entier français
	*/ 
	public GrillePotentiel(GrillePlaces grille,Dictionnaire dicoComplet){
		this.grille=grille;
		this.dikushioneiru=dicoComplet;
		//CHAQUE dictionnaire sera limité dans l'ordre des emplacements
		this.motsPot= new ArrayList<>();
		//On parcours chaque emplacement de la grille et créer le dictionnaire correspondant
		for(int i=0;i<this.grille.getPlaces().size();i++){
			Dictionnaire copium= this.dikushioneiru.copy();
			copium.filtreLongueur(this.grille.getPlaces().get(i).size());
			List<Emplacement> tmp=this.grille.getPlaces();
			//On doit parcourir chaque emplacement pour vérifier s'il contient déjà lettres (Question 2.4.2)
			for(int j=0;j<tmp.get(i).size();j++) {
				if(tmp.get(i).getCase(j).getChar()!=' ') {
					copium.filtreParLettre(tmp.get(i).getCase(j).getChar(),j);					
				}
			}
			motsPot.add(copium);
			System.out.println("tour "+motsPot );
		}
	}
	
	/**
	 * vérifie si un emplacement a un domaine potentiel vide
	 * @return true si domaine potentiel vide , false sinon
	 */
	public boolean isDead() {
		for(int i=0;i<motsPot.size();i++) {
			if(motsPot.get(i)==null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * PLACEHOLDER
	 * @return PLACEHOLDER
	 */
	public List<Dictionnaire> getMotsPot(){
		return this.motsPot;
	}
	
	/**
	 * ajoute la nouvelle grille potentielle associée à la nouvelle grille copiée dans GrillePlaces
	 * @param m l'emplacement à modifier
	 * @param soluce le nouveau mot à mettre à l'emplacement
	 * @return res la nouvelle grille potentielle
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces tmpG = this.grille.fixer(m,soluce);
		GrillePotentiel res=new GrillePotentiel(tmpG,this.dikushioneiru);
		res.motsPot= new ArrayList<>();
		for(int i=0;i<tmpG.getPlaces().size();i++){
			Dictionnaire copium= this.dikushioneiru.copy();
			copium.filtreLongueur(tmpG.getPlaces().get(i).size());
			/*List<Emplacement> tmp=tmpG.getPlaces();
			//On doit parcourir chaque emplacement pour vérifier s'il contient déjà lettres (Question 2.4.2)
			for(int j=0;j<tmp.get(i).size();j++) {
				copium.filtreParLettre(tmp.get(i).getCase(j).getChar(),j);					
			}*/
			motsPot.add(copium);
		}
		
		return res;
	}
}
