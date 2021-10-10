package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;


public class MotX implements ICSP{
	private List<DicoVariable> div;
	
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
		List<IVariable> res= new ArrayList<>();
		for (int i=0;i<div.size();i++) {
			res.add(div.get(i));
		}
		return res;
	}

	@Override
	public boolean isConsistent() {
		for (int i=0;i<div.size();i++) {
			if (div.get(i).getGp().isDead()) {return true;}
		}
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {	
		return null;
	}
	

}
