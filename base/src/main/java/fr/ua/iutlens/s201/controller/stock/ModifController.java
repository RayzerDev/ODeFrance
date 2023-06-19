package fr.ua.iutlens.s201.controller.stock;

import java.io.IOException;

import fr.ua.iutlens.s201.controller.IController;
import fr.ua.iutlens.s201.model.EntrepriseVenteEau;
import fr.ua.iutlens.s201.model.StockEau;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifController implements IController{	
    @FXML
    private TextField modifPrix;

    @FXML
    private TextField modifQuantite;
    
    @FXML
    private Label detailStock;
    
	private Stage currentStage;

	private EntrepriseVenteEau entreprise;
	
	private int indiceStock;
	
	public void setStage(Stage currentStage) {
		this.currentStage = currentStage;
	}	
	public void setTextStock(String text) {
		detailStock.setText(text);
	}
	public void setStock(int indiceStock) {
		this.indiceStock = indiceStock;
	}
	@FXML
	void onValider() throws IOException{
		ObservableList<StockEau> currentStock = entreprise.getStock().getStockEau();
		String nouveauPrixText = modifPrix.getText();
		String nouvelleQuantiteText = modifQuantite.getText();
		StockEau stock = currentStock.get(indiceStock);
		if(nouveauPrixText != "") {
			Double nouveauPrix = Double.parseDouble(nouveauPrixText);
			if (nouveauPrix > 0 ) {
				stock.getEau().setPrix(nouveauPrix);
			}
		}
		currentStock.set(indiceStock, stock);
		if(nouvelleQuantiteText != "") {
			int nouvelleQuantite = Integer.parseInt(nouvelleQuantiteText);
			if (nouvelleQuantite > 0 ) {
				stock.setQuantite(nouvelleQuantite);
				currentStock.set(indiceStock, stock);
			}
			else {
				currentStock.remove(currentStock.get(indiceStock));
			}
		}
		entreprise.getStock().triStockQuant();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/stock/detail.fxml"));
		Parent viewContent = fxmlLoader.load();
		DetailController controller = fxmlLoader.getController();
		controller.setEntreprise(entreprise);
		controller.setStage(currentStage);
		
		Scene scene = new Scene(viewContent);
		currentStage.setScene(scene);
		currentStage.setTitle("Gestion des stocks");
	}
	@Override
	public void setEntreprise(EntrepriseVenteEau entreprise) {
		// TODO Auto-generated method stub
		this.entreprise = entreprise;
	}
}
			