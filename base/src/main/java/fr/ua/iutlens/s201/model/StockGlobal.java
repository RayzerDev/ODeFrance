package fr.ua.iutlens.s201.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockGlobal {
	/*
	 * Classe */
	public static final int NB_STOCK = 20;
	private ObservableList<StockEau> stockage = FXCollections.observableArrayList();
	private int nbStockage;

	public StockGlobal() {
		nbStockage = 0;
	}

	public int getNbStockage() {
		return nbStockage;
	}
	
	public ObservableList<StockEau> getStockEau(){
		return stockage;
	}

	public void ajoutStockEau(StockEau stock) {
		for (int i = 0; i < nbStockage; i++) {
			if (stockage.get(i).equals(stock)) {
				stockage.get(i).setQuantite(stockage.get(i).getQuantite() + stock.getQuantite());
				triStockQuant();
				return;
			}
		}
		if (nbStockage == NB_STOCK)
			return;
		stockage.add(stock);
		nbStockage++;
		triStockQuant();
	}

	public void supprStockEau(int id, int quantite) throws StockException {
		for (int i = 0; i < nbStockage; i++) {
			if (stockage.get(i).getEau().getId() == id) {
				int newQuantite = stockage.get(i).getQuantite() - quantite;
				if (newQuantite > 0)
					stockage.get(i).setQuantite(newQuantite);
				else {
					nbStockage--;
					int nombreStock = stockage.get(i).getQuantite();
					stockage.set(i, stockage.get(nbStockage));
					stockage.set(nbStockage, null);
					throw new StockException(nombreStock+" bouteilles ont été retirés.");
				}
				triStockQuant();
				return;
			}
		}
	}

	public void triStockQuant() {
		for (int i = 0; i < nbStockage; i++) {
			int i_max = i;
			for (int j = i; j < nbStockage; j++) {
				if (stockage.get(i_max).getQuantite() < stockage.get(j).getQuantite())
					i_max = j;
			}
			if (i_max != i) {
				StockEau temp = stockage.get(i_max);
				stockage.set(i_max, stockage.get(i));
				stockage.set(i, temp);
			}
		}
	}

	public String toString() {
		StringBuffer rslt = new StringBuffer();
		rslt.append("StockGlobal: \n Quantité: " + getNbStockage() + "\n");
		for (int i = 0; i < nbStockage; i++) {
			rslt.append(stockage.get(i).toString());
		}
		return rslt.toString();
	}
}
