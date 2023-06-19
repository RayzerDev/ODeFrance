package fr.ua.iutlens.s201.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class EntrepriseVenteEau {
	private String nom;
	private StockGlobal stock;
	private ObservableList<Commande> commandes = FXCollections.observableArrayList();
	private ObservableList<Entrepot> entrepots = FXCollections.observableArrayList();
	private ObservableList<Client> clients = FXCollections.observableArrayList();
	private ObservableList<Eau> eaux = FXCollections.observableArrayList();
	private Adresse adresse;
	
	public String getNom() {
		return nom;
	}

	public StockGlobal getStock() {
		return stock;
	}

	public ObservableList<Commande> getCommandes() {
		return commandes;
	}

	public ObservableList<Entrepot> getEntrepots() {
		return entrepots;
	}

	public ObservableList<Client> getClients() {
		return clients;
	}
	public ObservableList<Eau> getEaux() {
		return eaux;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public EntrepriseVenteEau(String nom, int numero, String voie,String insee, String ville, String nom_dep) {
		this.nom = nom;
		this.adresse = new Adresse(numero, voie, insee, ville, nom_dep);
		this.stock = new StockGlobal();
	}
	
	public void ajoutEntrepot(String code, String nom, int numero, String voie, String insee, String ville, String nom_dep) {
		for (Entrepot e:entrepots) {
			if (e.getCode() == code) {
				System.out.println("Entrepot avec le même code déjà présent.");
				return;
			}
		}
		entrepots.add(new Entrepot(code,nom,numero,voie,insee,ville,nom_dep));
	}
	
	public void retireEntrepot(String code) {
		for (Entrepot e:entrepots) {
			if (e.getCode() == code)
				entrepots.remove(e);
				return;
		}
		System.out.println("Entrepot avec ce code non présent.");
	}
	public void ajoutStockEntrepot(Eau eau, Entrepot entrepot, int quantite) {
		stock.ajoutStockEau(new StockEau(eau,entrepot,quantite));
	}
	public void supprStockEntrepot(int id, int quantite) throws StockException {
		stock.supprStockEau(id,quantite);
	}
	public void ajouteClient(String codeC, String dateIns, int numero, String voie, String insee, String ville,
			String nom_dep, String numTel, String adresseMail, String nom, String siret) {
		for (Client c:clients) {
			if (c.getCodeC() == codeC) {
				System.out.println("Client avec le même code déjà présent.");
				return;
			}
		}
		clients.add(new ClientEntreprise(codeC,dateIns,numero,voie,insee,ville,
			nom_dep,numTel,adresseMail,nom,siret));
	}
	public void ajouteClient(String codeC, String dateIns, int numero, String voie, String insee,
			String ville, String nom_dep, String numTel, String adresseMail, String nom, TypeEtabPublic type){
		for (Client c:clients) {
			if (c.getCodeC() == codeC) {
				System.out.println("Client avec le même code déjà présent.");
				return;
			}
		}
		clients.add(new ClientEtablissementPublic( codeC,dateIns,numero,voie,insee,
				ville,nom_dep,numTel,adresseMail,nom,type));
	}
	public void ajouteClientParticulier(String codeC, String dateIns, int numero, String voie, String insee, 
			String nomAdresse, String nom_dep, String numTel, String adresseMail, String nom, String prenom) {
		for (Client c:clients) {
			if (c.getCodeC() == codeC) {
				System.out.println("Client avec le même code déjà présent.");
				return;
			}
		}
		clients.add(new ClientParticulier(codeC,dateIns,numero,voie,insee,nomAdresse,
			nom_dep,numTel,adresseMail,nom,prenom));
	}
	public void ajoutCommande(Client client, String date) {
		commandes.add(new Commande(client,date));
	}
	public void ajoutLCommande(int ref, Eau eau, int quantite) {
		for(Commande c: commandes) {
			if (c.getRef() == ref) {
				c.ajoutLigneCommande(eau, quantite);
			}
		};
	}
	
	public String toString() {
		return "Entreprise: " + nom + adresse + stock + "Nombre d'entrepots: " + entrepots.size() + " Nombre de clients: " + clients.size();
	}

	public void ajoutEau(String nom, TypeEau type, double prix) {
		// TODO Auto-generated method stub
		eaux.add(new Eau(nom,type,prix));
	}

	public Eau getEau(int code) {
		for(Eau eau:eaux) {
			if(eau.getId()==code) {
				return eau;
			}
		}
		return null;
	}

	public Entrepot getEntrepot(String code) {
		for(Entrepot entrepot:entrepots) {
			if(entrepot.getCode()==code) {
				return entrepot;
			}
		}
		return null;
	}
}
