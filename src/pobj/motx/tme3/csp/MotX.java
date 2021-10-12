package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;


public class MotX implements ICSP{
	private List<IVariable> div;
	
	public MotX(GrilleContrainte gc) {
		this.div= new ArrayList<>();
		List<Emplacement>l=gc.getGPlaces().getPlaces();
		for (int i=0;i<l.size();i++) {
			if(l.get(i).hasCaseVide()) {
				div.add(new DicoVariable(i,gc));
			}
		}
	}
	

	@Override
	public List<IVariable> getVars() {
		return div;
	}

	@Override
	public boolean isConsistent() {
		for(IVariable iv:div) {
			if(!(iv instanceof DicoVariable)){
				return false;
			}
			DicoVariable divar=(DicoVariable)iv;
			if(divar.getDomain().size()==0){
				return false;
				
			}
		}
		return true;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {	
		if(!(vi instanceof DicoVariable)) {
			return null;
		}
		DicoVariable divar=(DicoVariable)vi;
		return new MotX((divar.getGp().fixer(divar.getInd(), val)));
	}
	

}
