package Main;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.connection;

public class MainApp extends Application {

    private Stage primaryStage;
    Scene scene;
    private BorderPane rootLayout;
    public static Connection con;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nemocničný systém");
        initRootLayout();
        zobrazPrihlasenie();
    }


    public void initRootLayout() {
        try {
            // Load root layout from .fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/KorenoveProstredie.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void zobrazPrihlasenie() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Prihlasenie.fxml"));
            AnchorPane registracia = (AnchorPane) loader.load();

            rootLayout.setCenter(registracia);

            PrihlasenieController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public void zobrazUvod() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Uvod.fxml"));
            AnchorPane uvod = (AnchorPane) loader.load();

            rootLayout.setCenter(uvod);

            UvodController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazUvodne_Prihlasenie() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Uvodne_Prihlasenie.fxml"));
            AnchorPane uvodne_prihlasenie = (AnchorPane) loader.load();

            rootLayout.setCenter(uvodne_prihlasenie);

            Uvodne_PrihlasenieController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazZrusenie_objednavky() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/ZmazanieObjednavky.fxml"));
            AnchorPane zrusenie = (AnchorPane) loader.load();

            rootLayout.setCenter(zrusenie);

            ZrusenieObjednavkyController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazVyhladavanie_zaznamov() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/VyhladavanieZaznamov.fxml"));
            AnchorPane zobraz = (AnchorPane) loader.load();

            rootLayout.setCenter(zobraz);

            VyhladavanieZaznamovController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazZmazanie_pacienta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/ZmazaniePacienta.fxml"));
            AnchorPane zmazanie = (AnchorPane) loader.load();

            rootLayout.setCenter(zmazanie);

            ZmazaniePacientaController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazPridanie_pacienta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/PridaniePacienta.fxml"));
            AnchorPane zmazanie = (AnchorPane) loader.load();

            rootLayout.setCenter(zmazanie);

            PridaniePacientaController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazPridanie_zakroku() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/PridanieZakroku.fxml"));
            AnchorPane pridanie = (AnchorPane) loader.load();

            rootLayout.setCenter(pridanie);

            PridanieZakrokuController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazZakrok() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Zakrok.fxml"));
            AnchorPane zakrok = (AnchorPane) loader.load();

            rootLayout.setCenter(zakrok);

            ZakrokController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazAktualizaciaZakroku() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/AktualizaciaZakroku.fxml"));
            AnchorPane aktualizacia = (AnchorPane) loader.load();

            rootLayout.setCenter(aktualizacia);

            AktualizaciaZakrokuController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    
    public void zobrazZmazanieZakroku() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/ZmazanieZakroku.fxml"));
            AnchorPane zmazanie = (AnchorPane) loader.load();

            rootLayout.setCenter(zmazanie);

            ZmazanieZakrokuController controller = loader.getController();
            controller.setMainApp(this);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException, SQLException {
    	connection db = new connection();
		try {
			db.CreateConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
        launch(args);
    }

}
