package fr.ua.iutlens.s201.model;

import java.util.Objects;

public class Eau {
	private static int nbEau = 0;
	private int id;
	private String marque;
	private TypeEau categorie;
	private double prix;
	
	public Eau(String marque, TypeEau categorie, double prix) {
		id = nbEau;
		nbEau++;
		this.marque = marque;
		this.categorie = categorie;
		this.prix = prix;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public TypeEau getCategorie() {
		return categorie;
	}

	public void setCategorie(TypeEau categorie) {
		this.categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbEau() {
		return nbEau;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "\nEau: \n id: " + id + "\nmarque: " + marque + " categorie: " + categorie + "\nprix: " + prix;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eau other = (Eau) obj;
		return categorie == other.categorie && id == other.id && Objects.equals(marque, other.marque)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}

	
}
