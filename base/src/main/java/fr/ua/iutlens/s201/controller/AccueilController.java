package fr.ua.iutlens.s201.controller;

import java.io.IOException;

import fr.ua.iutlens.s201.model.EntrepriseVenteEau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccueilController implements IController{
	private Stage stage;
	private EntrepriseVenteEau entreprise;
	private 
	enum TypeStage {
		CLIENT("client/"),EAU("eau/"),ENTREPOT("entrepot/"),STOCK("stock/");

		private String nomFXML;
		TypeStage(String nomFXML) {
			this.nomFXML=nomFXML;
		}
		String getNomFXML() {
			return nomFXML;
		}
	}
    @FXML
    void onClient(ActionEvent event) throws IOException {
    	changeStage(TypeStage.CLIENT);
    }

    @FXML
    void onEau(ActionEvent event) throws IOException {
    	changeStage(TypeStage.EAU);
    }

    @FXML
    void onEntrepot(ActionEvent event) throws IOException {
    	changeStage(TypeStage.ENTREPOT);
    }

    @FXML
    void onStock(ActionEvent event) throws IOException {
    	changeStage(TypeStage.STOCK);
    }
    
    void changeStage(TypeStage type) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/"+type.getNomFXML()+"detail.fxml"));
        Parent viewContent = fxmlLoader.load();
        IController controller = fxmlLoader.getController();
        controller.setEntreprise(entreprise);
        
		Scene scene = new Scene(viewContent);
        stage.setScene(scene);
        controller.setStage(stage);
        stage.setTitle("O De France");
    }

	@Override
	public void setStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}

	@Override
	public void setEntreprise(EntrepriseVenteEau enterprise) {
		// TODO Auto-generated method stub
		this.entreprise = enterprise;
	}
}
