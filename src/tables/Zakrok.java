package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "vybavenie_chirurgickeho_zakroku")
public class Zakrok {
	
	@DatabaseField(columnName = "datum_zakroku")
	public long datum_zakroku;
	
	@DatabaseField(columnName = "meno_nemocnice")
	public String meno_nemocnice;
	
	@DatabaseField(columnName = "specializacia_oddelenia")
	public String specializacia_oddelenia;
	
	@DatabaseField(columnName = "cislo_poistenca")
	public long cislo_poistenca;
	
	public void setDatum_zakroku(long arg) {
		this.datum_zakroku = arg;
	}
	
	public void setMeno_nemocnice(String arg) {
		this.meno_nemocnice = arg;
	}
	
	public void setSpecializacia_oddelenia(String arg) {
		this.specializacia_oddelenia = arg;
	}
	
	public void setCislo_poistenca(long arg) {
		this.cislo_poistenca = arg;
	}

}
