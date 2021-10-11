package controllers;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tables.Pacient;
import tables.Zakrok;
import tables.Miestnost;
import tables.Nemocnica;

public class PridanieZakrokuController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField datum;
	
	@FXML
    private TextField meno;
	
	@FXML
    private TextField oddelenie;
	
	@FXML
    private TextField miestnost;
	
	@FXML
    private TextField cislo;
	
	Dao<Nemocnica, String> Dao;
	
	public void dao() throws SQLException {
		Dao = DaoManager.createDao(connection.connectionSource, Nemocnica.class);
	}

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazZakrok();
	}
	
	public void Prihlas() throws SQLException {
		
		dao();
		Zakrok zakrok = new Zakrok();
		boolean temp1 = false, temp2 = false, temp3 = false;
		String meno_nemocnice = meno.getText();
		String meno_oddelenia = oddelenie.getText();
		long rc = Long.parseLong(cislo.getText());
		
		
		GenericRawResults<String[]> rawResults = Dao.queryRaw("select meno_nemocnice from nemocnica where meno_nemocnice = \"" + meno_nemocnice + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		String[] resultArray = null;
		
		try {
			resultArray = results.get(0);
		} 
		catch(Exception e) {
			String errorMessage = "Nemocnica sa nenašla";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();
		}
		
		if(resultArray[0].equals(meno_nemocnice) && resultArray[0] != null) {
			zakrok.setMeno_nemocnice(resultArray[0]);
			temp1 = true;
		}
		
		
		
		GenericRawResults<String[]> rawResults2 = Dao.queryRaw("select specializacia_oddelenia from oddelenie where meno_nemocnice = \"" + meno_nemocnice + "\" and specializacia_oddelenia = \""
				+ meno_oddelenia + "\"");
		ArrayList<String[]> results2 = (ArrayList<String[]>) rawResults2.getResults();
		String[] resultArray2 = null;
		
		try {
			resultArray2 = results2.get(0);
		} 
		catch(Exception e) {
			String errorMessage = "Oddelenie sa nenašlo";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();;
		}

		if(resultArray2[0].equals(meno_oddelenia) && resultArray[0] != null) {
			zakrok.setSpecializacia_oddelenia(resultArray2[0]);
			temp2 = true;
		}
		
		else {
			String errorMessage = "Oddelenie sa nenašlo";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();
		}
		
		GenericRawResults<String[]> rawResults3 = Dao.queryRaw("select cislo_poistenca from pacient where id_lekar = " + PrihlasenieController.id_lek);
		ArrayList<String[]> results3 = (ArrayList<String[]>) rawResults3.getResults();
		
		for(int i = 0; i < results3.size(); i++) {
			String[] resultArray3 = results3.get(i);

			if(resultArray3[0].equals(Long.toString(rc)) && resultArray[0] != null) {
				zakrok.setCislo_poistenca(rc);
				temp3 = true;
				break;
			}
		}
		
		
		if(temp3 == false) {
			String errorMessage = "pacient sa nenašiel";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();
		}
		
		zakrok.setDatum_zakroku(Long.parseLong(datum.getText()));
		
		if(temp1 == true && temp2 == true && temp3 == true) {
			Dao<Zakrok, String> Dao2;
			Dao2 = DaoManager.createDao(connection.connectionSource, Zakrok.class);
			
			Dao2.create(zakrok);
			
			Miestnost izba = new Miestnost();
			izba.setDatum_zakroku(Long.parseLong(datum.getText()));
			izba.setMeno_nemocnice(meno_nemocnice);
			izba.setSpecializacia_oddelenia(meno_oddelenia);
			izba.setCislo_poistenca(rc);
			if(miestnost.getText().equals("")) 
				izba.setCislo_miestnosti(-1);
			else
				izba.setCislo_miestnosti(Long.parseLong(miestnost.getText()));
			
			Dao<Miestnost, String> Dao3;
			Dao3 = DaoManager.createDao(connection.connectionSource, Miestnost.class);
			
			Dao3.create(izba);
		}
		
		
	}
	
	@FXML
    private void initialize() {
    	
    }

}
