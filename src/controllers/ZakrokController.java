package controllers;

import Main.MainApp;
import javafx.fxml.FXML;

public class ZakrokController {
	
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void objednaj() {
		mainApp.zobrazPridanie_zakroku();
	}
	
	@FXML
	public void aktualizuj() {
		mainApp.zobrazAktualizaciaZakroku();
	}
	
	@FXML
	public void zmaz() {
		mainApp.zobrazZmazanieZakroku();
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazUvodne_Prihlasenie();
	}

}
