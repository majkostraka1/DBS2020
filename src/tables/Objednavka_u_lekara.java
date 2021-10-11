package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "objednavka_u_lekara")
public class Objednavka_u_lekara {
	
	@DatabaseField(columnName = "datum_objednania")
	public long datum_objednania;
	
	@DatabaseField(columnName = "ID_sestricka")
	public long ID_sestricka;
	
	@DatabaseField(columnName = "ID_lekar")
	public long ID_lekar;
	
	@DatabaseField(columnName = "cislo_poistenca")
	public long cislo_poistenca;
	
	public Objednavka_u_lekara() {
		
	}
	
	
	public void setDatum_objednania(long arg) {
		this.datum_objednania = arg;
	}
	
	public void setID_sestricka(long arg) {
		this.ID_sestricka = arg;
	}
	
	public void setID_lekar(long arg) {
		this.ID_lekar = arg;
	}
	
	public void setCislo_poistenca(long arg) {
		this.cislo_poistenca = arg;
	}
}
