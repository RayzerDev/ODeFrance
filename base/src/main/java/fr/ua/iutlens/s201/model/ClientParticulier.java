package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class ClientParticulier extends Client{
	private String nom, prenom;
	
	
	public ClientParticulier(String codeC, String dateIns, int numero, String voie, String insee, String nomAdresse, String nom_dep, String numTel, String adresseMail, String nom, String prenom) {
		super(codeC, dateIns,numero, voie, insee, nomAdresse, nom_dep, numTel, adresseMail);
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void ajoutPointsFidelite(double achat) {
		int nb=(int)Math.round(achat/100);
		if(nb>1)
			setPointFid((getPointFid()+(10*nb)));
	}
	public int getPointsFidelitePotentiel(double prix) {
		int nb=(int)Math.round(prix/100);
		if(nb>1)
			return 10*nb;
		return 0;
	}
	public String getTypeClient() {
		return "Particulier";
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@Override
	public String toString() {
		return "ClientParticulier\n Nom :" + nom + ", prenom :" + prenom + "\n" + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientParticulier other = (ClientParticulier) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	
	
}
