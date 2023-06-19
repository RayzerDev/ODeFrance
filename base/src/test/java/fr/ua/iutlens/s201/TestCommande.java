package fr.ua.iutlens.s201;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.ua.iutlens.s201.model.*;

public class TestCommande {
	private Eau b1,b2,b3;
	private StockEau s1,s2,s3,s4;
	private StockGlobal sg1;
	private Client ce1, cp1;
	
	@BeforeEach
	public void setup() {
		b1 = new Eau("Perrier",TypeEau.GAZEUSE,1.02);
		b2 = new Eau("Vittel",TypeEau.PLATE,0.66);
		b3 = new Eau("Cristaline",TypeEau.PLATE,0.4);
		Entrepot e1 = new Entrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		s1 = new StockEau(b1,e1,5);
		s2 = new StockEau(b1,e1,156);
		s3 = new StockEau(b2,e1,15);
		s4 = new StockEau(b3,e1,120);

		sg1 = new StockGlobal();
		sg1.ajoutStockEau(s2);
		sg1.ajoutStockEau(s1);
		sg1.ajoutStockEau(s4);
		sg1.ajoutStockEau(s3);
		ce1 = new ClientEntreprise("1486", "14-10-2020",6,
				"Rue du J","59423","Lens",
				"Pas-De-Calais","0618964562","machin@dsqkjl.com",
				"JeanBon","11556844151654");
		cp1 = new ClientParticulier("1400", "10-08-2020",19,
				"Rue du C","59423","Lens",
				"Pas-De-Calais","0618637562","ahhhh@gmail.com",
				"Jean","Fil");
	}
	@Test
	public void testUnitCommandeInstance() {
		Commande co1 = new Commande(ce1,"15-04-2023");
		Assertions.assertEquals(0, co1.getContenu().size());
		co1.ajoutLigneCommande(b3, 150);
		Assertions.assertEquals(1, co1.getContenu().size());
		Assertions.assertEquals(co1.getContenu().get(0) instanceof LigneDeCommande, true);
	}
	@Test
	public void testUnitCommandeNewInstance() {
		Commande co1 = new Commande(ce1,"15-06-2023");
		co1.ajoutLigneCommande(b3, 150);
		LigneDeCommande ligneIniti = co1.getContenu().get(0);
		int nbLigne = ligneIniti.getQUANTITE();
		co1.modifierLigneCommande(0, 15);
		Assertions.assertNotEquals(co1.getContenu().get(0).getQUANTITE(), nbLigne);
		Assertions.assertEquals(co1.getContenu().get(0).equals(ligneIniti), false);
	}
}
