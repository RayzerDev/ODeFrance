package fr.ua.iutlens.s201.model;

public class App {

	public static void main(String[] args) throws EntrepotException {
		Eau b1 = new Eau("Perrier",TypeEau.GAZEUSE,1.02);
		System.out.println(b1);
		Eau b2 = new Eau("Vittel",TypeEau.PLATE,0.66);
		System.out.println(b2);
		Eau b3 = new Eau("Cristaline",TypeEau.PLATE,0.4);
		System.out.println(b3);
		
		Adresse a1 = new Adresse(6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		System.out.println(a1);
		
		Entrepot e1 = new Entrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		System.out.println(e1);
		
		StockEau s1 = new StockEau(b1,e1,5);
		StockEau s2 = new StockEau(b1,e1,156);
		StockEau s3 = new StockEau(b2,e1,15);
		StockEau s4 = new StockEau(b3,e1,120);
		
		System.out.println(s2);
		
		StockGlobal sg1 = new StockGlobal();
		System.out.println(sg1);
		sg1.ajoutStockEau(s2);
		System.out.println(sg1);
		sg1.ajoutStockEau(s1);
		System.out.println(sg1);
		sg1.ajoutStockEau(s4);
		System.out.println(sg1);
		sg1.ajoutStockEau(s3);
		System.out.println(sg1);
		
		ClientEntreprise ce1 = new ClientEntreprise("1486", "14-10-2020",6,
								"Rue du J","59423","Lens",
								"Pas-De-Calais","0618964562","machin@dsqkjl.com",
								"JeanBon","11556844151654");
		System.out.println(ce1);
		ClientEtablissementPublic cep1 = new ClientEtablissementPublic("1400", "10-08-2020",19,
				"Rue du S","59423","Lens",
				"Pas-De-Calais","0618946562","chose@dssdfjl.com",
				"IUT",TypeEtabPublic.EPA);
		System.out.println(cep1);
		ClientParticulier cp1 = new ClientParticulier("1400", "10-08-2020",19,
				"Rue du C","59423","Lens",
				"Pas-De-Calais","0618637562","ahhhh@gmail.com",
				"Jean","Fil");
		System.out.println(cp1);
		
		Commande co1 = new Commande(ce1,"15-04-2023");
		co1.ajoutLigneCommande(b3, 150);
		System.out.println(co1);
		ce1.setPointFid(1800);
		System.out.println(co1);
		Commande co2 = new Commande(cp1,"15-04-2023");
		co2.ajoutLigneCommande(b3, 150);
		co2.ajoutLigneCommande(b1, 15);
		System.out.println(co2);
		cp1.setPointFid(1800);
		System.out.println(co2);
		Commande co3 = new Commande(cep1,"15-04-2023");
		co3.ajoutLigneCommande(b3, 150);
		System.out.println(co3);
		co3.modifierLigneCommande(0, 10);
		System.out.println(co3);
		EntrepriseVenteEau entr = new EntrepriseVenteEau("Drinkin'Riviera",8,"Avenue du 8 mai 1945","59117","Landrecies","59");
		entr.ajoutEntrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		System.out.println(entr);
		entr.ajoutEntrepot("1410","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		System.out.println(entr);
		entr.ajoutEntrepot("1510","Maison d'Anthony", 6,"Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
		System.out.println(entr);
		entr.retireEntrepot("1410");
		System.out.println(entr);
	}
}
