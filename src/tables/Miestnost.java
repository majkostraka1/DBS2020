package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "miestnost_operacie")
public class Miestnost {
	
	@DatabaseField(columnName = "cislo_miestnosti")
	public long cislo_miestnosti;
	
	@DatabaseField(columnName = "meno_nemocnice")
	public String meno_nemocnice;
	
	@DatabaseField(columnName = "specializacia_oddelenia")
	public String specializacia_oddelenia;
	
	@DatabaseField(columnName = "datum_zakroku")
	private long datum_zakroku;
	
	@DatabaseField(columnName = "cislo_poistenca")
	private long cislo_poistenca;
	
	public Miestnost() {
		
	}
	
	public void setCislo_miestnosti(long arg) {
		this.cislo_miestnosti = arg;
	}
	
	public void setMeno_nemocnice(String arg) {
		this.meno_nemocnice = arg;
	}
	
	public void setSpecializacia_oddelenia(String arg) {
		this.specializacia_oddelenia = arg;
	}
	
	public void setDatum_zakroku(long arg) {
		this.datum_zakroku = arg;
	}
	
	public void setCislo_poistenca(long arg) {
		this.cislo_poistenca = arg;
	}
	
	

}
