package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrihlasenieController {
	
	public static String id;
	public static String id_lek;

    private MainApp mainApp;
    
    @FXML
    private TextField id_sestricka;

    public PrihlasenieController() {

    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleVstupit() throws SQLException {
    	String id = id_sestricka.getText();
    	boolean temp = false;
    	Statement stmt = connection.con.createStatement();
        ResultSet rs = stmt.executeQuery("select id_sestricka from sestricka");
        while(rs.next()) {
        	if(id.equals(rs.getString(1))) {
        		temp = true;
        		this.id = rs.getString(1);
        	}
        }
        Statement stmt2 = connection.con.createStatement();
        ResultSet rs2 = stmt2.executeQuery("select id_lekar from sestricka where id_sestricka = " + id);
        while(rs2.next()) {
        	this.id_lek = rs2.getString(1);
        }
        
        if(temp == true)
        	mainApp.zobrazUvodne_Prihlasenie();
        
    }

    @FXML
    private void initialize() {
    }



}
