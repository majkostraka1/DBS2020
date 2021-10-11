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

public class ZrusenieObjednavkyController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField cislo_poistenca;
	@FXML
    private TextField datum_objednania;
	

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	
	@FXML
	public void Zrus_objednavku() throws SQLException {
		
		long cislo_poistenca1 = Long.parseLong(cislo_poistenca.getText());
		long datum_objednavky = Long.parseLong(datum_objednania.getText());
		
		long temp1 = 0, temp2 = 0;
		long id_lekar = 0;
		
		Statement stmt2=connection.con.createStatement();
        ResultSet rs2 = stmt2.executeQuery("SELECT * FROM objednavka_u_lekara WHERE objednavka_u_lekara.ID_sestricka = " + PrihlasenieController.id);
        
        while(rs2.next()) {
        	temp1 = Long.parseLong(rs2.getString(4));
        	temp2 = Long.parseLong(rs2.getString(1));
        }
		
		PreparedStatement st = (PreparedStatement) connection.con.prepareStatement("DELETE FROM objednavka_u_lekara WHERE cislo_poistenca = " + cislo_poistenca1 + " AND datum_objednania = " + datum_objednavky);
		
		
		if(temp1 == cislo_poistenca1 && temp2 == datum_objednavky) {
			
			st.executeUpdate(); 
			
			String errorMessage = "Záznam bol odstránený";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(null);
            alert.setTitle("Operácia prebehla úspešne");
            alert.setContentText(errorMessage);

            alert.showAndWait();
		}
		
		else {
			
			String errorMessage = "Záznam sa nenašiel";
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

}
