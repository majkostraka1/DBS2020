package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tables.Miestnost;
import tables.Nemocnica;
import tables.Zakrok;

public class AktualizaciaZakrokuController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField rodne_cislo;
	
	@FXML
    private TextField datum;
	
	@FXML
    private TextField cislo_izby;
	
	@FXML
    private TextField nemocnica;
	
	@FXML
    private TextField oddelenie;

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazZakrok();
	}
	
	public void aktualizuj() throws SQLException {
		
		long rc = Long.parseLong(rodne_cislo.getText());
		long datum1 = Long.parseLong(datum.getText());
		
		Miestnost miestnost = new Miestnost();
		
		Dao<Zakrok, String> Dao;
		Dao = DaoManager.createDao(connection.connectionSource, Zakrok.class);
		
		GenericRawResults<String[]> rawResults = Dao.queryRaw("select * from vybavenie_chirurgickeho_zakroku where datum_zakroku = " + datum1 + " and cislo_poistenca = " + rc);
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		String[] resultArray = null;
		try {
			resultArray = results.get(0);
		} 
		catch(Exception e) {
			String errorMessage = "Prosím zadajte platné údaje";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(null);
            alert.setTitle("CHYBA");
            alert.setContentText(errorMessage);

            alert.showAndWait();
		}
		
		
		if(Long.parseLong(resultArray[0]) == datum1 && Long.parseLong(resultArray[3]) == rc && resultArray[0] != null) {
			String nemocnica1 = nemocnica.getText();
			String oddelenie1 = oddelenie.getText();
			String cislo_izby1 = cislo_izby.getText();
			
			if(!(nemocnica1.equals(""))) {
				Dao<Nemocnica, String> Dao2;
				Dao2 = DaoManager.createDao(connection.connectionSource, Nemocnica.class);
				
				GenericRawResults<String[]> rawResults2 = Dao2.queryRaw("select meno_nemocnice from nemocnica where meno_nemocnice = \"" + nemocnica1 + "\"");
				ArrayList<String[]> results2 = (ArrayList<String[]>) rawResults2.getResults();
				String[] resultArray2 = null;
				
				try {
					resultArray2 = results2.get(0);
				} 
				catch(Exception e) {
					String errorMessage = "Nemocnica sa nenašla";
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.initOwner(null);
		            alert.setTitle("CHYBA");
		            alert.setContentText(errorMessage);

		            alert.showAndWait();
				}
				
				if(resultArray2[0].equals(nemocnica1) && resultArray2[0] != null) {
					Dao<Miestnost, String> Dao3;
					Dao3 = DaoManager.createDao(connection.connectionSource, Miestnost.class);
					
					TransactionManager.callInTransaction(connection.connectionSource,
							  new Callable<Void>() {
							    public Void call() throws Exception {
							    	UpdateBuilder<Miestnost, String> ub = Dao3.updateBuilder();
									ub.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum1);
									ub.updateColumnValue("meno_nemocnice", nemocnica1);			
									ub.update();
							        return null;
							    }
							});
					
					TransactionManager.callInTransaction(connection.connectionSource,
							  new Callable<Void>() {
							    public Void call() throws Exception {
							    	UpdateBuilder<Miestnost, String> ub2 = Dao3.updateBuilder();
									ub2.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum1);
									ub2.updateColumnValue("specializacia_oddelenia", "Doplnte oddelenie prosim");			
									ub2.update();
							        return null;
							    }
							});
				
				}
				
			}
			
			if(!(oddelenie1.equals(""))) {
				Dao<Nemocnica, String> Dao2;
				Dao2 = DaoManager.createDao(connection.connectionSource, Nemocnica.class);
				
				GenericRawResults<String[]> rawResults2 = Dao2.queryRaw("select specializacia_oddelenia from oddelenie where meno_nemocnice = \"" + nemocnica1 + "\" and specializacia_oddelenia = \""
						+ oddelenie1 + "\"");
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

		            alert.showAndWait();
				}
				
				if(resultArray2[0].equals(oddelenie1) && resultArray2[0] != null) {
					Dao<Miestnost, String> Dao3;
					Dao3 = DaoManager.createDao(connection.connectionSource, Miestnost.class);
					
					TransactionManager.callInTransaction(connection.connectionSource,
							  new Callable<Void>() {
							    public Void call() throws Exception {
							    	UpdateBuilder<Miestnost, String> ub = Dao3.updateBuilder();
									ub.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum1);
									ub.updateColumnValue("specializacia_oddelenia", oddelenie1);			
									ub.update();
							        return null;
							    }
							});

				}
				
			}
			
			if(!(cislo_izby1.equals(""))) {
				Dao<Miestnost, String> Dao3;
				Dao3 = DaoManager.createDao(connection.connectionSource, Miestnost.class);
				
				TransactionManager.callInTransaction(connection.connectionSource,
						  new Callable<Void>() {
						    public Void call() throws Exception {
						    	UpdateBuilder<Miestnost, String> ub = Dao3.updateBuilder();
								ub.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum1);
								ub.updateColumnValue("cislo_miestnosti", Long.parseLong(cislo_izby1));			
								ub.update();
						        return null;
						    }
						});
				
			}
			
			String errorMessage = "Úspešná aktualizácia";
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.initOwner(null);
	        alert.setTitle("Aktualizované!");
	        alert.setContentText(errorMessage);

	        alert.showAndWait();
			
		}
		
	}


}
