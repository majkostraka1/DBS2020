package tables;

import javafx.beans.property.SimpleStringProperty;

public class VypisTable {
	
	private SimpleStringProperty priezvisko;
	private SimpleStringProperty meno;
	private SimpleStringProperty rodne_cislo;
	private SimpleStringProperty cislo_poistenca;
	private SimpleStringProperty datum;
	
	public VypisTable() {
		
	}
	
	public void setPriezvisko(String arg) {
		this.priezvisko = new SimpleStringProperty(arg);
	}
	
	public void setMeno(String arg) {
		this.meno = new SimpleStringProperty(arg);
	}
	
	public void setRodne_cislo(String arg) {
		this.rodne_cislo = new SimpleStringProperty(arg);
	}
	
	public void setCislo_poistenca(String arg) {
		this.cislo_poistenca = new SimpleStringProperty(arg);
	}
	
	public void setDatum(String arg) {
		this.datum = new SimpleStringProperty(arg);
	}
	
	public String getPriezvisko() {
		return priezvisko.get();
	}
	
	public String getMeno() {
		return meno.get();
	}
	
	public String getRodne_cislo() {
		return rodne_cislo.get();
	}
	
	public String getCislo_poistenca() {
		return cislo_poistenca.get();
	}
	
	public String getDatum() {
		return datum.get();
	}
	
}
