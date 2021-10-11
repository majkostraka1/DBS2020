package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sestricka")
public class Sestricka {

	@DatabaseField(columnName = "meno")
	public String meno;
	
	@DatabaseField(columnName = "priezvisko")
	public String priezvisko;
	
	@DatabaseField(columnName = "id_sestricka")
	public long id_sestricka;
	
	@DatabaseField(columnName = "id_lekar")
	public long id_lekar;
	
	public Sestricka() {
		
	}
	
	public void setMeno(String arg) {
		this.meno = arg;
	}
	
	public void setPriezvisko(String arg) {
		this.priezvisko = arg;
	}
	
	public void setID_sestricka(long arg) {
		this.id_sestricka = arg;
	}
	
	public void setID_lekar(long arg) {
		this.id_lekar = arg;
	}
}
