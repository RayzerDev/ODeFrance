package fr.ua.iutlens.s201.model;

public class LigneDeCommande {
	private final Eau EAU;
	private final int QUANTITE;
	
    public LigneDeCommande(Eau eau, int quantite) {
        EAU = eau;
        QUANTITE = quantite;
    }

	public String toString() {
		return "LigneDeCommande \n eau :" + EAU + "quantité" + QUANTITE + "\n";
	}

	public Eau getEAU() {
		return EAU;
	}

	public int getQUANTITE() {
		return QUANTITE;
	}
	
}