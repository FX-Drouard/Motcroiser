package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

public class MotX implements ICSP{
	private List<DicoVariable> div;
	
	public MotX(GrilleContrainte gc) {
		this.div= new ArrayList<>();
		
	}
	

	@Override
	public List<IVariable> getVars() {
		return null;
	}

	@Override
	public boolean isConsistent() {
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {	
		return null;
	}
	

}
