package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class Entrepot{
	
	private String code;
	private String nom;
	private Adresse adresse;
	
	// Ajout du constructeur pour initialiser les instances
	public Entrepot(String code, String nom, int numero, String voie, String insee, String ville, String nomDep) {
		this.code = code;
		this.nom = nom;
		this.adresse = new Adresse(numero, voie, insee, ville, nomDep);
	}
	public Entrepot(String code, String nom, Adresse adresse) {
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	
	//Ajout d'une methode getCode afin de pouvoir recupérer le code d'une instance
	public String getCode() {
		return code;
	}
	
	// methode getNom pour recupérer le nom d'une instance
	public String getNom() {
		return nom;
	}
	
	// redéfinition du toString
	public String toString() {
		 return "Entrepot: \n code :"+code+", nom :"+ nom + "\n" + adresse;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrepot other = (Entrepot) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(code, other.code)
				&& Objects.equals(nom, other.nom);
	}

}
