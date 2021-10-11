package controllers;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import Main.MainApp;
import Main.connection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tables.Miestnost;
import tables.Zakrok;

public class ZmazanieZakrokuController {
	
	private MainApp mainApp;
	
	@FXML
    private TextField rodne_cislo;
	
	@FXML
    private TextField datum;
	
	public void Zmaz() throws SQLException {
		
		String datum_objednavky = datum.getText();
		String rc = rodne_cislo.getText();
		 
		Dao<Zakrok, String> Dao;
		Dao = DaoManager.createDao(connection.connectionSource, Zakrok.class);
		Dao<Miestnost, String> Dao2;
		Dao2 = DaoManager.createDao(connection.connectionSource, Miestnost.class);
		
		
		TransactionManager.callInTransaction(connection.connectionSource,
				  new Callable<Void>() {
				    public Void call() throws Exception {
				    	DeleteBuilder<Zakrok, String> deleteBuilder = Dao.deleteBuilder();
				    	DeleteBuilder<Miestnost, String> deleteBuilder2 = Dao2.deleteBuilder();
				    	
				    	deleteBuilder.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum_objednavky);	
				    	Dao.delete(deleteBuilder.prepare());
				    	
				    	deleteBuilder2.where().eq("cislo_poistenca", rc).and().eq("datum_zakroku", datum_objednavky);	
				    	Dao2.delete(deleteBuilder2.prepare());
				        return null;
				    }
				});
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazZakrok();
	}

}
