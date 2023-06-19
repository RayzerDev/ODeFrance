package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class ClientEntreprise extends Client{
	
	private String nom;
	private String siret;
	public ClientEntreprise(String codeC, String dateIns, int numero, String voie, String insee, String ville,
			String nom_dep, String numTel, String adresseMail, String nom, String siret) {
		
		super(codeC, dateIns, numero, voie, insee, ville, nom_dep, numTel, adresseMail);
		this.nom = nom;
		this.siret = siret;
	}
	
	public void ajoutPointsFidelite(double achat) {
		int nb = (int)Math.round(achat/1000);
		if (nb > 1)
			setPointFid(getPointFid()+(10*nb));
	}
	public int getPointsFidelitePotentiel(double prix) {
		int nb=(int)Math.round(prix/1000);
		if(nb>1)
			return 10*nb;
		return 0;
	}
	public String getTypeClient() {
		return "Entreprise";
	}

	public String getNom() {
		return nom;
	}

	public String getSiret() {
		return siret;
	}

	@Override
	public String toString() {
		return "ClientEntreprise: \n nom=" + nom + ", siret=" + siret + "\n" + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientEntreprise other = (ClientEntreprise) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(siret, other.siret);
	}
	
	
	

}
