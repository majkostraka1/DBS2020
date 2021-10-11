package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.mysql.jdbc.PreparedStatement;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tables.Pacient;
import Main.connection;

public class PridaniePacientaController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField meno;
	@FXML
    private TextField priezvisko;
	@FXML
    private TextField rodne_cislo;
	@FXML
    private TextField cislo_poistenca;
	
	Dao<Pacient, String> accountDao;
	
	public void dao() throws SQLException {
		accountDao = DaoManager.createDao(connection.connectionSource, Pacient.class);
	}
	

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	
	@FXML
	public void Pridaj_pacienta() throws SQLException {
		
		String meno1 = meno.getText();
		String priezvisko1 = priezvisko.getText();
		long rodne_cislo1 = Long.parseLong(rodne_cislo.getText());
		long cislo_poistenca1 = Long.parseLong(cislo_poistenca.getText());

    	Statement stmt=connection.con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT ID_lekar FROM sestricka WHERE ID_sestricka = " + PrihlasenieController.id);
		
		String id_lekar1 = "";
		
		while(rs.next())
			id_lekar1 = rs.getString(1);
		
		
		String query = " INSERT INTO pacient (meno, priezvisko, rodne_cislo, cislo_poistenca, ID_lekar)"
    	        + " VALUES (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt = (PreparedStatement) connection.con.prepareStatement(query);
	    preparedStmt.setString (1, meno1);
	    preparedStmt.setString (2, priezvisko1);
	    preparedStmt.setLong (3, rodne_cislo1);
	    preparedStmt.setLong (4, cislo_poistenca1);
	    preparedStmt.setLong (5, Long.parseLong(id_lekar1));
	    
	      
	    preparedStmt.execute();
	    
	    String errorMessage = "záznam bol pridaný";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(null);
        alert.setTitle("Registrácia dokončená!");
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
