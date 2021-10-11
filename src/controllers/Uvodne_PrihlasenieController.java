package controllers;

import Main.MainApp;
import javafx.fxml.FXML;

public class Uvodne_PrihlasenieController {
	
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void prihlas_na_vysetrenie() {
		mainApp.zobrazUvod();
	}
	
	@FXML
	public void Zrusit_vysetrenie() {
		mainApp.zobrazZrusenie_objednavky();
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazPrihlasenie();
	}
	
	public void VyhladavanieZaznamov() {
		mainApp.zobrazVyhladavanie_zaznamov();
	}
	
	@FXML
	public void Zmazat_pacienta() {
		mainApp.zobrazZmazanie_pacienta();
	}
	
	@FXML
	public void Pridat_pacienta() {
		mainApp.zobrazPridanie_pacienta();
	}
	
	@FXML
	public void Pridat_zakrok() {
		mainApp.zobrazZakrok();
	}
	
	@FXML
    private void initialize() {
    	
    }

}
