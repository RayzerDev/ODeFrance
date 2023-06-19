package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class Adresse {

	private int numero;
	private String voie;
	private Commune commune;
	
	
	//Creéation de la classe imbriquée statique Commune qui sera utilisée pour définir la commune dans une adresse.
	class Commune{
		private String insee;
		private String nom;
		private String nomDep;

		//Constructeur de la commune
		public Commune(String insee, String nom, String nomDep) {
			this.insee = insee;
			this.nom = nom;
			this.nomDep = nomDep;
		}
		
		public String getInsee() {
			return insee;
		}

		public String getNom() {
			return nom;
		}

		public String getnomDep() {
			return nomDep;
		}

		public String toString() {
			return "\n Commune = code INSEE :" + insee + ", Ville :" + nom + ", Département :" + nomDep + "\n";
		}
	}

	//Constructeur de l'adresse
	public Adresse(int numero, String voie,String insee, String nom, String nomDep) {
		this.numero = numero;
		this.voie = voie;
		this.commune = new Commune(insee, nom, nomDep);
	}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public Commune getCommune() {
		return commune;
	}
	
	public String toString() {
		return "Adresse :\n numero : " + numero + ", voie :" + voie + commune.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(commune, other.commune) && numero == other.numero && Objects.equals(voie, other.voie);
	}
}
