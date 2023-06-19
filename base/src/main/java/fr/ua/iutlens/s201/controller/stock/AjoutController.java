package fr.ua.iutlens.s201.controller.stock;

import java.io.IOException;

import fr.ua.iutlens.s201.controller.IController;
import fr.ua.iutlens.s201.model.Eau;
import fr.ua.iutlens.s201.model.Entrepot;
import fr.ua.iutlens.s201.model.EntrepriseVenteEau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutController implements IController{

    @FXML
    private TextField ajoutQuantite;

    @FXML
    private ChoiceBox<Eau> eauChoice;

    @FXML
    private ChoiceBox<Entrepot> entrepotChoice;

    @FXML
    private Label statutText;

    private EntrepriseVenteEau entreprise;
    private Stage stage;
    
    @FXML
    void onRetour(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/stock/detail.fxml"));
		Parent viewContent = fxmlLoader.load();
		IController controller = fxmlLoader.getController();
		controller.setEntreprise(entreprise);
		controller.setStage(stage);
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		stage.setTitle("Gestion des stocks");
    }
    
    @FXML
    void onValider(ActionEvent event) throws IOException {
    	Eau selectedEau = eauChoice.getValue();
    	Entrepot selectedEntrepot= entrepotChoice.getValue();
    	if(selectedEau == null) {
    		statutText.setText("Vous n'avez pas selectionné d'eau");
    		return;
    	}
    	if(selectedEntrepot == null) {
    		statutText.setText("Vous n'avez pas selectionné d'entrepot");
    		return;
    	}
    	if(ajoutQuantite.getText()=="") {
    		statutText.setText("Vous n'avez pas mis une quantité acceptable.");
    		return;
    	}
    	int quantite = Integer.parseInt(ajoutQuantite.getText());
    	entreprise.ajoutStockEntrepot(selectedEau, selectedEntrepot, quantite);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/stock/detail.fxml"));
		Parent viewContent = fxmlLoader.load();
		IController controller = fxmlLoader.getController();
		controller.setEntreprise(entreprise);
		controller.setStage(stage);
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		stage.setTitle("Gestion des stocks");
    }

	@Override
	public void setStage(Stage stage) {
		this.stage = stage;
    	eauChoice.setItems(entreprise.getEaux());
    	entrepotChoice.setItems(entreprise.getEntrepots());
	}

	@Override
	public void setEntreprise(EntrepriseVenteEau entreprise) {
		this.entreprise = entreprise;
	}
	
}
