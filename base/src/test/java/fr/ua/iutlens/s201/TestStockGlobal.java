package fr.ua.iutlens.s201;

import org.junit.jupiter.api.Assertions;
import fr.ua.iutlens.s201.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ua.iutlens.s201.model.StockException;

public class TestStockGlobal {
	private StockEau s1,s2,s3,s4;
	private StockGlobal sg1;
	
	@BeforeEach
	public void setup() {
		Eau b1 = new Eau("Perrier",TypeEau.GAZEUSE,1.02);
		Eau b2 = new Eau("Vittel",TypeEau.PLATE,0.66);
		Eau b3 = new Eau("Cristaline",TypeEau.PLATE,0.4);

		Adresse a1 = new Adresse(6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		
		Entrepot e1 = new Entrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		
		s1 = new StockEau(b1,e1,5);
		s2 = new StockEau(b1,e1,156);
		s3 = new StockEau(b2,e1,15);
		s4 = new StockEau(b3,e1,120);
		sg1 = new StockGlobal();
	}
	
    @Test
    public void testStockGlobal() throws StockException {	
		Assertions.assertEquals(sg1.getNbStockage(), 0);
		sg1.ajoutStockEau(s2);
		Assertions.assertEquals(sg1.getNbStockage(), 1);
		Assertions.assertEquals(sg1.getStockEau().get(0).getQuantite(), 156);
		sg1.ajoutStockEau(s1);
		Assertions.assertEquals(sg1.getNbStockage(), 1);
		Assertions.assertEquals(sg1.getStockEau().get(0).getQuantite(), 161);
		Assertions.assertEquals(sg1.getStockEau().get(0).equals(s1), true);
		sg1.ajoutStockEau(s4);
		Assertions.assertEquals(sg1.getNbStockage(), 2);
		sg1.ajoutStockEau(s3);
		Assertions.assertEquals(sg1.getNbStockage(), 3);
		Assertions.assertThrows(StockException.class, ()->sg1.supprStockEau(0, 300));
		Assertions.assertEquals(sg1.getNbStockage(), 2);
		for(int i=0;i<sg1.getNbStockage();i++) {
			if (i+1<sg1.getNbStockage()) {
				Assertions.assertTrue(sg1.getStockEau().get(i).getQuantite()<=sg1.getStockEau().get(i+1).getQuantite());
			}
		}
    }
    
}
