package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.Dictionnaire;

public class DicoVariable implements IVariable{
	private int index;
	private GrilleContrainte gp;
	
	public DicoVariable(int index,GrilleContrainte gp) {
		this.index=index;
		this.gp=gp;
	}

	@Override
	public List<String> getDomain() {
		Dictionnaire tmp = gp.getMotsPot().get(this.index);
		return tmp.getListe();
	}

	@Override
	public String toString() {
		return "DicoVariable [index=" + index + ", gp=" + gp + ", getDomain()=" + getDomain() + "]";
	}
	
	
	
	
	

}
