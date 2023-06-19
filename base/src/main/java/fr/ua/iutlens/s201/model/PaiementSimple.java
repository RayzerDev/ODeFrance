package fr.ua.iutlens.s201.model;

public class PaiementSimple implements TraitementPaiement{
	public void executePaiement(Paiement p) {
		p.getMethode().payer(p.getMontant());
	}
	public void remboursement(Paiement p) {
		p.getMethode().rembourser(p.getMontant());
	}
}
