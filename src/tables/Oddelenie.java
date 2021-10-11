package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "oddelenie")
public class Oddelenie {
	
	@DatabaseField(columnName = "specializacia_oddelenia")
	private String specializacia_oddelenia;
	
	@DatabaseField(columnName = "meno_nemocnice")
	private String meno_nemocnice;
	
	public Oddelenie() {
		
	}
	
	public String getSpecializacia_oddelenia() {
		return this.specializacia_oddelenia;
	}
	
	public String getMeno_nemocnice() {
		return this.meno_nemocnice;
	}

}
