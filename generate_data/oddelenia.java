package generate_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class oddelenia {
	
	ArrayList<String> arrayList_oddelenia = new ArrayList<>();
	public static final String fileName="Oddelenia.txt";
	
	public ArrayList<String> napln_oddelenia() {
		 
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_oddelenia.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_oddelenia;
	}
	
	public void generate() throws SQLException {
		
		String oddelenie = "";
		int temp = 3892;
		String query = " INSERT INTO oddelenie (specializacia_oddelenia, meno_nemocnice)"
    	        + " VALUES (?, ?)";
		
		Statement stmt = main.con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM nemocnica");
		
		while(rs.next()) {
			
			for(int i = 0; i < 22; i++) {
				
				oddelenie = arrayList_oddelenia.get(i);
				PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
			    preparedStmt.setString (1, oddelenie + " " + temp);
			    preparedStmt.setString (2, rs.getString(1));
			    
			    preparedStmt.execute();
				
				System.out.println(oddelenie + temp + " " + rs.getString(1));
				

			}
			temp++;
		}
	}

}
