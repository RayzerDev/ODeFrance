package fr.ua.iutlens.s201;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.ua.iutlens.s201.model.*;

public class TestAdresseEntrepot {
	@Test
	public void testInstanceAdresse() {
		Adresse a1 = new Adresse(6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		Entrepot e1 = new Entrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		Entrepot e2 = new Entrepot("1410","Maison d'Anthony",a1);
		Assertions.assertEquals(a1.equals(e1.getAdresse()), false);
		Assertions.assertEquals(a1.equals(e2.getAdresse()), true);
	}
}
