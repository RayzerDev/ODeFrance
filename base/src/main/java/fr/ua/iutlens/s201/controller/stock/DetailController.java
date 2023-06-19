/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.ua.iutlens.s201.controller.stock;

import java.io.IOException;

import fr.ua.iutlens.s201.controller.IController;
import fr.ua.iutlens.s201.model.EntrepriseVenteEau;
import fr.ua.iutlens.s201.model.StockEau;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * La classe HelloController illustre le fonctionnement du contrôleur associé à
 * une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class DetailController implements IController{

	/**
	 * Le label de l'application, où l'on va pouvoir afficher des messages. Ce label
	 * sera initialisé automatiquement par JavaFX grâce à l'annotation {@link FXML}.
	 */
	@FXML
	private Label descriptifDetail;

	@FXML
	private Button commander;

	@FXML
	private ListView<StockEau> listeObject;
	
	private Stage currentStage;
	
	private EntrepriseVenteEau entreprise;
	
	public void setStage(Stage stage) {
		this.currentStage = stage;
		descriptifDetail.setText("Selectionnez à gauche une eau !");
		listeObject.setCellFactory(list -> {
			  return new ListCell<>() {
			    @Override
			    public void updateItem(StockEau stocks, boolean empty) {
			        super.updateItem(stocks, empty);
			        if (empty || (stocks == null)) {
			          setText(null);
			        } else {
			          setText(stocks.getEau().toString());
			        }
			      }
			    };
			});
		listeObject.setItems(
				entreprise.getStock().getStockEau());
		listeObject.getSelectionModel().selectedItemProperty().addListener((p, o, n) -> {
			descriptifDetail.setText(n.toString());
		});
	}
	
	public void setEntreprise(EntrepriseVenteEau entreprise) {
		this.entreprise = entreprise;
	}

    @FXML
    public void onAccueil() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/accueil.fxml"));
		Parent viewContent = fxmlLoader.load();
		IController controller = fxmlLoader.getController();
		controller.setStage(currentStage);
		controller.setEntreprise(entreprise);
		Scene scene = new Scene(viewContent);
		currentStage.setScene(scene);
		currentStage.setTitle("Accueil");
    }

    @FXML
    public void onCommander() {
    	
    }
    
	@FXML
	public void onModifier() throws IOException{
		if(listeObject.getSelectionModel().getSelectedIndex() == -1)
			return;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/stock/modif.fxml"));
		Parent viewContent = fxmlLoader.load();
		ModifController controller = fxmlLoader.getController();
		controller.setEntreprise(entreprise);
		controller.setTextStock(listeObject.getSelectionModel().getSelectedItem().toString());
		controller.setStock(listeObject.getSelectionModel().getSelectedIndex());
		controller.setStage(currentStage);
		Scene scene = new Scene(viewContent);
		currentStage.setScene(scene);
		currentStage.setTitle("Modification des stocks");
	}
	
    @FXML
	public void onRetirer() throws IOException {
		if(listeObject.getSelectionModel().getSelectedIndex() == -1)
			return;
    }
    
    @FXML
	public void onAjouter() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/stock/ajout.fxml"));
		Parent viewContent = fxmlLoader.load();
		IController controller = fxmlLoader.getController();
		controller.setEntreprise(entreprise);
		controller.setStage(currentStage);
		Scene scene = new Scene(viewContent);
		currentStage.setScene(scene);
		currentStage.setTitle("Ajout des stocks");
    }
}