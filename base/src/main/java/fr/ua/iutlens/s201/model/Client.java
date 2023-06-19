package fr.ua.iutlens.s201.model;
import java.util.Objects;

public abstract class Client {
	
	private String codeC;
	private String dateIns;
	private Adresse adresse;
	private String numTel;
	private String adresseMail;
	private int pointFid;
	
	public Client(String codeC, String dateIns, int numero, String voie, String insee, String ville, String nom_dep, String numTel, String adresseMail) {
		this.codeC = codeC;
		this.dateIns = dateIns;
		this.adresse = new Adresse(numero, voie,insee,ville,nom_dep);
		this.numTel = numTel;
		this.adresseMail = adresseMail;
		pointFid = 0;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getCodeC() {
		return codeC;
	}

	public String getDateIns() {
		return dateIns;
	}

	public int getPointFid() {
		return pointFid;
	}

	public void setPointFid(int pointFid) {
		this.pointFid = pointFid;
	}

	@Override
	public String toString() {
		return "Client\n codeC:" + codeC + ", dateIns: " + dateIns + ", numTel: " + numTel
				+ ", adresseMail: " + adresseMail + ", pointFid: " + pointFid +"\n" + adresse;
	}
	
	public abstract void ajoutPointsFidelite(double achat);
	
	public abstract String getTypeClient();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(adresseMail, other.adresseMail)
				&& Objects.equals(codeC, other.codeC) && Objects.equals(dateIns, other.dateIns)
				&& Objects.equals(numTel, other.numTel) && pointFid == other.pointFid;
	}

	public abstract int getPointsFidelitePotentiel(double prixTotal);
		
}
