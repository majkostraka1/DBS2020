package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ZmazaniePacientaController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField cislo_poistenca;
	

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	
	@FXML
	public void Zmaz_pacienta() throws SQLException {
		
		long cislo_poistenca1 = Long.parseLong(cislo_poistenca.getText());
		
		
		PreparedStatement st = (PreparedStatement) connection.con.prepareStatement("DELETE FROM pacient WHERE cislo_poistenca = " + cislo_poistenca1 );
        st.executeUpdate(); 
        
        String errorMessage = "Pacient bol zmazaný";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(null);
        alert.setTitle("Zmazanie bolo úspešné!");
        alert.setContentText(errorMessage);

        alert.showAndWait();

	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazUvodne_Prihlasenie();
	}
	
    @FXML
    private void initialize() {
    	
    }

}
