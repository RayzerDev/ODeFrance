package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class ClientEtablissementPublic extends Client {
	private String nom;
	private TypeEtabPublic type;
	
	public ClientEtablissementPublic(String codeC, String dateIns, int numero, String voie, String insee,
			String ville, String nom_dep, String numTel, String adresseMail, String nom, TypeEtabPublic type) {
		super(codeC, dateIns, numero, voie, insee, ville, nom_dep, numTel, adresseMail);
		this.nom = nom;
		this.type = type;
	}

	public void ajoutPointsFidelite(double achat) {
		int nb=(int)Math.round(achat/500);
		if(nb>1)
			setPointFid((getPointFid()+(10*nb)));
	}
	
	public int getPointsFidelitePotentiel(double prix) {
		int nb=(int)Math.round(prix/500);
		if(nb>1)
			return 10*nb;
		return 0;
	}
	
	public TypeEtabPublic getType() {
		return type;
	}

	public void setType(TypeEtabPublic type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return "Client Etablissement Public \n nom :" + nom + ", type :" + type+ "\n" + super.toString();
	}


	public String getTypeClient() {
		return type.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientEtablissementPublic other = (ClientEtablissementPublic) obj;
		return Objects.equals(nom, other.nom) && type == other.type;
	}
}
