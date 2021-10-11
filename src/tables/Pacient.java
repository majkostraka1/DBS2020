package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pacient")
public class Pacient {
	
	@DatabaseField(columnName = "meno")
	public String meno;
	
	@DatabaseField(columnName = "priezvisko")
	public String priezvisko;
	
	@DatabaseField(columnName = "rodne_cislo")
	public long rodne_cislo;
	
	@DatabaseField(columnName = "cislo_poistenca")
	public long cislo_poistenca;
	
	@DatabaseField(columnName = "ID_lekar")
	public long ID_lekar;
	
	public Pacient() {
		
	}
	
	public void setMeno(String arg) {
		this.meno = arg;
	}
	
	public void setPriezvisko(String arg) {
		this.priezvisko = arg;
	}
	
	public void setRodne_cislo(long arg) {
		this.rodne_cislo = arg;
	}
	
	public void setCisloPoistenca(long arg) {
		this.cislo_poistenca = arg;
	}
	
	public void setID_lekar(long arg) {
		this.ID_lekar = arg;
	}
	
	

}
