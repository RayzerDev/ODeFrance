package fr.ua.iutlens.s201.model;

public abstract class MethodePaiement {
	public abstract void payer(double montant);
	public abstract void rembourser(double montant);
}
