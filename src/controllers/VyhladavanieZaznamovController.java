package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;

import Main.MainApp;
import Main.connection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import tables.Objednavka_u_lekara;
import tables.Pacient;
import tables.Sestricka;
import tables.VypisTable;
import tables.Zakrok;

public class VyhladavanieZaznamovController {
	
	private MainApp mainApp;
	
	@FXML
	private TableView<VypisTable> table;
	@FXML
	private TableColumn<VypisTable, String> first;
	@FXML
	private TableColumn<VypisTable, String> second;
	@FXML
	private TableColumn<VypisTable, String> third;
	@FXML
	private TableColumn<VypisTable, String> fourth;
	
	
	@FXML
	private TableView<VypisTable> table2;
	@FXML
	private TableColumn<VypisTable, String> first2;
	@FXML
	private TableColumn<VypisTable, String> second2;
	
	@FXML
	private TextArea vypis;
	@FXML
	private TextField zadaj_datum;
	@FXML
	private TextField vyhladaj_objednavku;
	@FXML
	private TextField vyhladaj_zakrok;

	Dao<Pacient, String> accountDao;
	
	public void dao() throws SQLException {
		accountDao = DaoManager.createDao(connection.connectionSource, Pacient.class);
	}
	
	Dao<Sestricka, String> accountDao2;
	
	public void dao2() throws SQLException {
		accountDao2 = DaoManager.createDao(connection.connectionSource, Sestricka.class);
	}
	
	Dao<Objednavka_u_lekara, String> accountDao3;
	
	public void dao3() throws SQLException {
		accountDao3 = DaoManager.createDao(connection.connectionSource, Objednavka_u_lekara.class);
	}
	
	Dao<Zakrok, String> accountDao4;
	
	public void dao4() throws SQLException {
		accountDao4 = DaoManager.createDao(connection.connectionSource, Zakrok.class);
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;		
	}
	
	@FXML
	public void vyhladaj_objednavku() throws SQLException {
		
		Objednavka_u_lekara objednavka_u_lekara = new Objednavka_u_lekara();
		dao3();
		
		objednavka_u_lekara.setCislo_poistenca(Long.parseLong(vyhladaj_objednavku.getText()));
		String temp = "";
		
		GenericRawResults<String[]> rawResults = accountDao3.queryRaw("select datum_objednania from objednavka_u_lekara where cislo_poistenca = \"" + objednavka_u_lekara.cislo_poistenca + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		int i = 0;
		String[] resultArray = null;
		
		vypis.appendText("Datumy objednavok:\n");
		for (i = 0; i < results.size(); i++) {
			resultArray = results.get(i);
			vypis.appendText(resultArray[0] + "\n");
		}
		
	}
	
	@FXML
	public void zobraz_pacientov() throws SQLException {
		
        Sestricka sestricka = new Sestricka();
		dao2();
		
        GenericRawResults<String[]> rawResults = accountDao2.queryRaw("select id_lekar from sestricka where sestricka.id_sestricka = \"" + PrihlasenieController.id + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		String[] resultArray = results.get(0);
        
        Pacient pacient = new Pacient();
        dao();
        
        GenericRawResults<String[]> rawResults2 = accountDao.queryRaw("select * from pacient where ID_lekar = \"" + resultArray[0] + "\"" + "group by priezvisko order by priezvisko ASC");
		ArrayList<String[]> results2 = (ArrayList<String[]>) rawResults2.getResults();
		int i = 0;
		String[] resultArray2 = null;
				
		ObservableList<VypisTable> table3 = FXCollections.observableArrayList();
		
		for (i = 0; i < results2.size(); i++) {
			VypisTable temp = new VypisTable();
			resultArray2 = results2.get(i);
			
			temp.setPriezvisko(resultArray2[1]);
			temp.setMeno(resultArray2[0]);
			temp.setRodne_cislo(resultArray2[2]);
			temp.setCislo_poistenca(resultArray2[3]);
			table3.add(temp);		
			
		}
		first.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("priezvisko"));
		second.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("meno"));
		third.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("rodne_cislo"));
		fourth.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("cislo_poistenca"));
		
		table.setItems(table3);
		
	}
	
	@FXML
	public void zobraz_objednavky() throws SQLException {
		
		Objednavka_u_lekara objednavka_u_lekara = new Objednavka_u_lekara();
		dao3();
		
		GenericRawResults<String[]> rawResults = accountDao3.queryRaw("select id_lekar from sestricka where sestricka.id_sestricka = \"" + PrihlasenieController.id + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		String[] resultArray = results.get(0);
		
		GenericRawResults<String[]> rawResults2 = accountDao3.queryRaw("select * from objednavka_u_lekara where ID_lekar = \"" + resultArray[0] + "\"");
		ArrayList<String[]> results2 = (ArrayList<String[]>) rawResults2.getResults();
		int i = 0;
		String[] resultArray2 = null;
		
		ObservableList<VypisTable> table3 = FXCollections.observableArrayList();
		
		for (i = 0; i < results2.size(); i++) {
			VypisTable temp = new VypisTable();
			resultArray2 = results2.get(i);
			
			temp.setDatum(resultArray2[0]);
			temp.setCislo_poistenca(resultArray2[3]);
			table3.add(temp);
			
		}
		
		first2.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("datum"));
		second2.setCellValueFactory(new PropertyValueFactory<VypisTable, String>("cislo_poistenca"));
		
		table2.setItems(table3);
		
	}
	
	@FXML
	public void zobraz_pocet() throws SQLException {
		
		long datum = Long.parseLong(zadaj_datum.getText());
		
		Objednavka_u_lekara objednavka_u_lekara = new Objednavka_u_lekara();
		dao3();
		
		GenericRawResults<String[]> rawResults = accountDao3.queryRaw("select id_lekar from sestricka where sestricka.id_sestricka = \"" + PrihlasenieController.id + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		String[] resultArray = results.get(0);
		
		GenericRawResults<String[]> rawResults2 = accountDao3.queryRaw("select count(*) from objednavka_u_lekara group by datum_objednania, ID_lekar having datum_objednania = " + datum  + " and ID_lekar = \"" + resultArray[0] + "\"");
		ArrayList<String[]> results2 = (ArrayList<String[]>) rawResults2.getResults();
		String[] resultArray2 = results2.get(0);
		
		
		vypis.appendText("Pocet objednavok na vybavenie pre zadany datum: \n" + resultArray2[0]);
		
	}
	
	@FXML
	public void vyhladaj_zakrok() throws SQLException {
		
		Zakrok zakrok = new Zakrok();
		dao4();
		
		zakrok.setCislo_poistenca(Long.parseLong(vyhladaj_zakrok.getText()));
		
		GenericRawResults<String[]> rawResults = accountDao4.queryRaw("select datum_zakroku from vybavenie_chirurgickeho_zakroku where cislo_poistenca = \"" + zakrok.cislo_poistenca + "\"");
		ArrayList<String[]> results = (ArrayList<String[]>) rawResults.getResults();
		int i = 0;
		String[] resultArray = null;
		
		vypis.appendText("Datumy zakrokov:\n");
		for (i = 0; i < results.size(); i++) {
			resultArray = results.get(i);
			vypis.appendText(resultArray[0] + "\n");
		}
		
	}
	
	@FXML
	public void Clear() {
		vypis.clear();
		table.getItems().clear();
		table2.getItems().clear();
	}
	
	@FXML
	public void VratSpat() {
		mainApp.zobrazUvodne_Prihlasenie();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	
}