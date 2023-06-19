package fr.ua.iutlens.s201.model;

public interface TraitementPaiement {
	public void executePaiement(Paiement p);
	public void remboursement(Paiement p);
}
