package fr.ua.iutlens.s201.model;

public class StockEau {
	private Eau eau;
	private Entrepot entrepot;
	private int quantite;
	
	//Constructeur d'un stock d'eau avec un entrepôt, une eau et une quantité d'eau donnée.
	public StockEau(Eau eau, Entrepot entrepot, int quantite) {
		this.eau = eau;
		this.entrepot = entrepot;
		this.quantite = quantite;
	}


	public String toString() {
		return "StockEau: \n Quantite: " + quantite + "\n" + eau + "\n " + entrepot;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Eau getEau() {
		return eau;
	}

	public Entrepot getEntrepot() {
		return entrepot;
	}
	public boolean equals(Object obj) {
		if (obj instanceof StockEau) {
			return (((StockEau)obj).getEau().equals(this.eau) && ((StockEau)obj).getEntrepot().equals(entrepot));
		}
		return false;
	}
}
