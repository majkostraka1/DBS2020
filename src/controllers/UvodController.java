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

public class UvodController {

    private MainApp mainApp;
    @FXML
    private TextField datum_objednania;
    @FXML
    private TextField rodne_cislo;

    public UvodController() {

    }

    @FXML
    private void Prihlas() throws SQLException {
        
    	Statement stmt=connection.con.createStatement();
    	Statement stmt2=connection.con.createStatement();
        ResultSet rs2 = stmt2.executeQuery("SELECT * FROM sestricka WHERE sestricka.id_sestricka = " + PrihlasenieController.id);
    	long datum_objednania1 = Long.parseLong(datum_objednania.getText());
    	long cislo_poistenca = Long.parseLong(rodne_cislo.getText());
    	long id_lekar_from_pacient = 0;
    	long id_lek = 0;
    	long id_ses = 0;
    	ResultSet rs=stmt.executeQuery("SELECT ID_lekar FROM pacient WHERE pacient.cislo_poistenca = " + cislo_poistenca);
    	
    	
    	while(rs.next()) {
    		id_lekar_from_pacient = Long.parseLong(rs.getString(1));
    		
    	}
    	
    	while(rs2.next()) {
    		id_ses = Long.parseLong(rs2.getString(3));
        	id_lek = Long.parseLong(rs2.getString(4));       		
        }
    	  	
    	
        String query = " INSERT INTO objednavka_u_lekara (datum_objednania, ID_sestricka, ID_lekar, cislo_poistenca)"
    	        + " VALUES (?, ?, ?, ?)";
        
        if(id_lekar_from_pacient == id_lek) {
        	PreparedStatement preparedStmt = (PreparedStatement) connection.con.prepareStatement(query);
    	    preparedStmt.setLong (1, datum_objednania1);
    	    preparedStmt.setLong (2, id_ses);
    	    preparedStmt.setLong (3, id_lek);
    	    preparedStmt.setLong (4, cislo_poistenca);
    	      
    	    preparedStmt.execute();
    	    
    	    String errorMessage = "Záznam bol pridaný";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(null);
            alert.setTitle("Registrácia bola úspešná!");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }
        
        else {
        	String errorMessage = "Zadaný pacient nepatrí pod vášho lekára";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }
        
    }
    
    @FXML
    public void VratSpat() {
    	mainApp.zobrazUvodne_Prihlasenie();
    }
    
    @FXML
    private void initialize() {
    	
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
