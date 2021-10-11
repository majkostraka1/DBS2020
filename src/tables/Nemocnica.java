package tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nemocnica")
public class Nemocnica {
	
	@DatabaseField(columnName = "meno_nemocnice")
	public String meno_nemocnice;
	
	@DatabaseField(columnName = "mesto")
	private String mesto;
	
	@DatabaseField(columnName = "stat")
	private String stat;
	
	public Nemocnica() {
		
	}
	
	public String getMeno_nemocnice() {
		return this.meno_nemocnice;
	}
	
	public String getMesto() {
		return this.mesto;
	}
	
	public String getStat() {
		return this.stat;
	}
	
	
}
