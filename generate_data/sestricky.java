package generate_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class sestricky {
	
	ArrayList<String> arrayList_mena = new ArrayList<>();
	ArrayList<String> arrayList_priezviska = new ArrayList<>();
	public static final String fileName="ZenskeMena.txt";
	public static final String fileName2="ZenskePriezviska.txt";
	
	public ArrayList<String> napln_mena() {
		 
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
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
	//            System.out.println(data);
	            arrayList_priezviska.add(data);
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Gotti an error");
	        e.printStackTrace();
	    }
	    return arrayList_priezviska;
	}
	
	public void generate() throws SQLException {
		
		String query = " INSERT INTO sestricka (meno, priezvisko, id_sestricka, id_lekar)"
    	        + " VALUES (?, ?, ?, ?)";
		Random random = new Random();
		long id = 857312;
		long id_sestricka = 4284538;
		int r_int = random.nextInt(2);
		PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
		
		for(int i = 0; i < 110000; i++) {
			
			String meno = arrayList_mena.get(random.nextInt(194));
			String priezvisko = arrayList_priezviska.get(random.nextInt(924));
			preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
			//System.out.println(meno + priezvisko + id_sestricka + id);
			
	    	   preparedStmt.setString (1, meno);
	    	   preparedStmt.setString (2, priezvisko);
	    	   preparedStmt.setLong (3, id_sestricka);
	    	   preparedStmt.setLong (4, id);
	    	      
	    	   preparedStmt.execute();
				
				
			
			id_sestricka += 5;
			
			if(r_int == 0) {
				
				meno = arrayList_mena.get(random.nextInt(194));
				priezvisko = arrayList_priezviska.get(random.nextInt(924));
				preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
				//System.out.println(meno + priezvisko + id_sestricka + id);
				
		    	   preparedStmt.setString (1, meno);
		    	   preparedStmt.setString (2, priezvisko);
		    	   preparedStmt.setLong (3, id_sestricka);
		    	   preparedStmt.setLong (4, id);
		    	      
		    	   preparedStmt.execute();
		    	   
		    	   id_sestricka += 5;
				
			}
				
			r_int = random.nextInt(2);
			id += 3;
			
		}
	}

}
