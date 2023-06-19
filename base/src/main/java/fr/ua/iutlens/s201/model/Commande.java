package fr.ua.iutlens.s201.model;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Commande implements RemisesPossibles {
	private static int nbCommandes=0;
	private int ref;
	private Client client;
	private String date;
	private ObservableList<LigneDeCommande> contenu = FXCollections.observableArrayList();
	
	public Commande(Client client, String date) {
		this.ref = nbCommandes;
		this.client = client;
		this.date = date;
		nbCommandes++;
	}
	
	public String getDate() {
		return date;
	}

	public ObservableList<LigneDeCommande> getContenu() {
		return contenu;
	}

	public int getRef() {
		return ref;
	}

	public Client getClient() {
		return client;
	}

	public double montantDeLaRemise() {
		double r1=(client.getPointFid()/100)*0.01;
		double r2=(client.getPointFid()/1000)*0.01;
		if(client.getTypeClient()=="Particulier")
			if(r1<0.1)
				return r1;
			else {
				return 0.1;
			}
		if(r2<0.05)
			return r2;
		return 0.05;
	}
	
	public int nombreBouteilleGratuite() {
		int nbBouteilles=0;
		for(LigneDeCommande l:contenu) 
			nbBouteilles +=l.getQUANTITE();
		if(client.getTypeClient()=="Particulier")
			return nbBouteilles/12;
		if(client.getTypeClient()=="Entreprise")
			return nbBouteilles/60;
		return nbBouteilles/120;
	}
	
	public void ajoutLigneCommande(Eau eau, int quantite){
		LigneDeCommande lc = new LigneDeCommande(eau, quantite);
		for(LigneDeCommande l:contenu) {
			if(l.equals(lc))
				return;
		}
		contenu.add(lc);
	}
	
	public void modifierLigneCommande(int indice, int quantite) {
		LigneDeCommande l=new LigneDeCommande(contenu.get(indice).getEAU(), quantite);
		contenu.set(indice, l);
	}
	
	public double prixTotal() {
		double somme=0;
		for(LigneDeCommande l:contenu) {
			somme+=l.getQUANTITE()*l.getEAU().getPrix();
		}
		return somme-somme*montantDeLaRemise();
	}
	public String toString() {
		StringBuffer rslt = new StringBuffer();
		rslt.append("Commande \n ref:" + ref + " date: " + date + " Nombres de produits: " + contenu.size()+ " Prix Total: " + prixTotal()+ "\n" + "Points fidélité potentiel: " + client.getPointsFidelitePotentiel(prixTotal()));
		for(LigneDeCommande l:contenu) {
			l.toString();
		}
		rslt.append(client.toString());
		return rslt.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(client, other.client) && Objects.equals(contenu, other.contenu)
				&& Objects.equals(date, other.date) && ref == other.ref;
	}
}
