package pobj.motx.tme1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

public class EmplacementTest {

	@Test
	public void testEmpty() {
		Emplacement e = new Emplacement();
		assertEquals(0, e.size());
	}

	@Test
	public void testAdd() {
		Emplacement e = new Emplacement();
		e.addCase(new Case(0, 1, '*'));
		assertEquals(1, e.size());
		e.addCase(new Case(1, 2, '@'));
		assertEquals(2, e.size());
	}

	@Test
	public void testGet() {
		Emplacement e = new Emplacement();
		Case c1 = new Case(0, 1, '*');
		Case c2 = new Case(1, 2, '@');
		e.addCase(c1);
		e.addCase(c2);
		assertSame(c1, e.getCase(0));
		assertSame(c2, e.getCase(1));
	}
}
