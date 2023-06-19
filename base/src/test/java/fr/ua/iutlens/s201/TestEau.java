package fr.ua.iutlens.s201;

import org.junit.jupiter.api.Assertions;
import fr.ua.iutlens.s201.model.*;
import org.junit.jupiter.api.Test;

public class TestEau {
	@Test
	public void testInstanceEau() {
		Eau b1 = new Eau("Perrier",TypeEau.GAZEUSE,1.02);
		Eau b2 = new Eau("Vittel",TypeEau.PLATE,0.66);
		Eau b3 = new Eau("Vittel",TypeEau.PLATE,0.66);
		Eau b4 = b1;
		
		Assertions.assertEquals(b2.equals(b1), false);
		Assertions.assertEquals(b2.getId()==b1.getId(), false);
		
		Assertions.assertEquals(b3.equals(b2), false);
		Assertions.assertEquals(b3.getId()==b2.getId(), false);
		
		Assertions.assertEquals(b4.equals(b1), true);
		Assertions.assertEquals(b4.getId()==b1.getId(), true);
	}
}
