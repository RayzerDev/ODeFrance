package fr.ua.iutlens.s201;

import org.junit.jupiter.api.Assertions;
import fr.ua.iutlens.s201.model.*;
import org.junit.jupiter.api.Test;

public class TestClient {
	@Test
	public void testClientPtFidelite() {
		Eau b1 = new Eau("Perrier",TypeEau.GAZEUSE,1.02);
		Eau b2 = new Eau("Vittel",TypeEau.PLATE,0.66);
		Eau b3 = new Eau("Cristaline",TypeEau.PLATE,0.4);
		Entrepot e1 = new Entrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		StockEau s1 = new StockEau(b1,e1,5);
		StockEau s2 = new StockEau(b1,e1,156);
		StockEau s3 = new StockEau(b2,e1,15);
		StockEau s4 = new StockEau(b3,e1,120);

		StockGlobal sg1 = new StockGlobal();
		sg1.ajoutStockEau(s2);
		sg1.ajoutStockEau(s1);
		sg1.ajoutStockEau(s4);
		sg1.ajoutStockEau(s3);
		ClientEntreprise ce1 = new ClientEntreprise("1486", "14-10-2020",6,
				"Rue du J","59423","Lens",
				"Pas-De-Calais","0618964562","machin@dsqkjl.com",
				"JeanBon","11556844151654");
		ClientEtablissementPublic cep1 = new ClientEtablissementPublic("1486", "14-10-2020",6,
				"Rue du J","59423","Lens",
				"Pas-De-Calais","0618964562","machin@dsqkjl.com",
				"JeanBon",TypeEtabPublic.EPA);
		ClientParticulier cp1 = new ClientParticulier("1400", "10-08-2020",19,
				"Rue du C","59423","Lens",
				"Pas-De-Calais","0618637562","ahhhh@gmail.com",
				"Jean","Fil");
		
		Commande co1 = new Commande(ce1,"15-04-2023");
		co1.ajoutLigneCommande(b3, 150);
		Commande co2 = new Commande(cp1,"15-04-2023");
		co2.ajoutLigneCommande(b3, 150);
		co2.ajoutLigneCommande(b1, 600);	
		Commande co3 = new Commande(cep1,"15-06-2023");
		co3.ajoutLigneCommande(b3, 320);
		co3.ajoutLigneCommande(b1, 10);	
		double prixB1 = co1.prixTotal();
		double prixB2 = co2.prixTotal();
		double prixB3 = co3.prixTotal();
		ce1.setPointFid(1800);
		cp1.setPointFid(1800);
		cep1.setPointFid(1800);
		Assertions.assertNotEquals(co1.prixTotal(), prixB1);
		Assertions.assertNotEquals(co2.prixTotal(), prixB2);
		Assertions.assertNotEquals(co3.prixTotal(), prixB3);
		Assertions.assertEquals(cp1.getPointsFidelitePotentiel(prixB2), 70);
		
	}
}