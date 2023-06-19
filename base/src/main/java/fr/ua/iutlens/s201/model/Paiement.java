package fr.ua.iutlens.s201.model;

public class Paiement {
	private double montant;
	private MethodePaiement methode;
	
	public Paiement(double montant, MethodePaiement methode) {
		this.montant = montant;
		this.methode = methode;
	}

	public double getMontant() {
		return montant;
	}

	public MethodePaiement getMethode() {
		return methode;
	}

	@Override
	public String toString() {
		return "Paiement \n montant:" + montant + ", methode:" + methode;
	}
	
	
}
