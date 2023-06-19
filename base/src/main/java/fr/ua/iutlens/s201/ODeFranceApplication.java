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

package fr.ua.iutlens.s201;

import java.io.IOException;

import fr.ua.iutlens.s201.controller.IController;
import fr.ua.iutlens.s201.model.Eau;
import fr.ua.iutlens.s201.model.Entrepot;
import fr.ua.iutlens.s201.model.EntrepriseVenteEau;
import fr.ua.iutlens.s201.model.StockEau;
import fr.ua.iutlens.s201.model.TypeEau;
import fr.ua.iutlens.s201.model.TypeEtabPublic;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * La classe HelloApplication illustre le fonctionnement d'une {@link Application} JavaFX.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class ODeFranceApplication extends Application {

    /**
     * Cette méthode permet d'initialiser l'affichage de la fenêtre de l'application.
     *
     * @param stage La fenêtre (initialement vide) de l'application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Il faut d'abord récupérer la description de la vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/accueil.fxml"));
    	Parent viewContent = fxmlLoader.load();
        IController controller = fxmlLoader.getController();
        EntrepriseVenteEau entreprise =  new EntrepriseVenteEau("Drinkin'Riviera",8,"Avenue du 8 mai 1945","59117","Landrecies","59");
        entreprise.ajoutEntrepot("1410", "Maison d'Anthony", 6, "Avenue du 8 mai 1945", "59550", "Landrecies","Nord");
        entreprise.ajoutEntrepot("13", "Maison ", 65, "Avenue du 1945", "62110", "Hénin","Nord");
        entreprise.ajoutEau("Cristaline", TypeEau.PLATE, 0.4);
        entreprise.ajoutEau("Perrier", TypeEau.GAZEUSE, 1.03);
        entreprise.ajoutEau("Vittel",TypeEau.PLATE,0.66);
        entreprise.ajoutStockEntrepot(entreprise.getEau(0), entreprise.getEntrepot("1410"), 50);
        entreprise.ajoutStockEntrepot(entreprise.getEau(1), entreprise.getEntrepot("13"), 100);
        entreprise.ajouteClient("1486", "14-10-2020",6,
				"Rue du J","59423","Lens",
				"Pas-De-Calais","0618964562","machin@dsqkjl.com",
				"JeanBon","11556844151654");
        entreprise.ajouteClient("1400", "10-08-2020",19,
				"Rue du S","59423","Lens",
				"Pas-De-Calais","0618946562","chose@dssdfjl.com",
				"IUT",TypeEtabPublic.EPA);
        entreprise.ajouteClientParticulier("1400", "10-08-2020",19,
				"Rue du C","59423","Lens",
				"Pas-De-Calais","0618637562","ahhhh@gmail.com",
				"Jean","Fil");
        controller.setEntreprise(entreprise);
    	controller.setStage(stage);
    	
        // Ensuite, on la place dans une Scene...
		Scene scene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre.
        stage.setScene(scene);
        controller.setStage(stage);
        // On peut ensuite donner un titre à la fenêtre.
        stage.setTitle("O De France");

        // Enfin, on affiche la fenêtre.
        stage.show();
    }

    /**
     * Cette méthode exécute l'application JavaFX.
     * Pour le cours d'IHM, la méthode {@code main} d'une application JavaFX sera
     * toujours la même : un simple appel à la méthode {@link #launch(String...)}
     * définie dans la classe {@link Application}.
     *
     * @param args Les arguments de la ligne de commande (dont on ne tient pas compte).
     *
     * @see #launch(String...)
     */
    public static void main(String[] args) {
        launch();
    }

}
