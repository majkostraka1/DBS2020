package generate_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;



public class lekari {
	
	ArrayList<String> arrayList_mena = new ArrayList<>();
	ArrayList<String> arrayList_priezviska = new ArrayList<>();
	public static final String fileName="KrstneMena.txt";
	public static final String fileName2="Priezviska.txt";
	
	public ArrayList<String> napln_mena() {
		 
	        try {
	            File file = new File(fileName);
	            Scanner myReader = new Scanner(file);
	            while (myReader.hasNextLine()) {
	                String data = myReader.nextLine();
//	                System.out.println(data);
	                arrayList_mena.add(data);
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Gotti an error");
	            e.printStackTrace();
	        }
	        return arrayList_mena;
	}
	
	public ArrayList<String> napln_priezviska() {
		 
        try {
            File file = new File(fileName2);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_priezviska.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_priezviska;
}
	
	public void generate() throws SQLException {
		
		String query = " INSERT INTO lekar (id, meno, priezvisko)"
    	        + " VALUES (?, ?, ?)";
		int count = 0;
		long id = 857312;
		long pom = 0;
		
		for(long i = 0; i < 110000; i++) {
			Random random = new Random();
			
			String meno = arrayList_mena.get(random.nextInt(1999));
			String priezvisko = arrayList_priezviska.get(random.nextInt(18839));
			long id_lekar = id;
			//System.out.println(meno + " " + priezvisko + " " + id_lekar);
				
				
			PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
	    	   preparedStmt.setLong (1, id_lekar);
	    	   preparedStmt.setString (2, meno);
	    	   preparedStmt.setString (3, priezvisko);
	    	      
	    	   preparedStmt.execute();
				
			id += 3;
				
		}
		
		System.out.println("done");
	}

}
