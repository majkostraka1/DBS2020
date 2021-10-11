package generate_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class nemocnice {
	
	ArrayList<String> arrayList_mestask = new ArrayList<>();
	ArrayList<String> arrayList_mestacz = new ArrayList<>();
	ArrayList<String> arrayList_nemocnice = new ArrayList<>();
	
	public static final String fileName="MestaSK.txt";
	public static final String fileName2="MestaCZ.txt";
	public static final String fileName3="NemocnicaMena.txt";
	
	public ArrayList<String> napln_mestask() {
		 
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_mestask.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_mestask;
	}
	
	public ArrayList<String> napln_mestacz() {
		 
        try {
            File file = new File(fileName2);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_mestacz.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_mestacz;
	}
	
	public ArrayList<String> napln_nemocnice() {
		 
        try {
            File file = new File(fileName3);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_nemocnice.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_nemocnice;
	}
	
	public void generate() throws SQLException {
		
		String[] temp = {"","","",""};
		Random random = new Random();
		String meno = "";
		String mesto = "";
		
		String query = " INSERT INTO nemocnica (meno_nemocnice, mesto, stat)"
    	        + " VALUES (?, ?, ?)";
		
		for(int i = 0; i < 585; i++) {
			
			temp[0] = "";
			temp[1] = "";
			temp[2] = "";
			temp[3] = "";
			mesto = arrayList_mestacz.get(i);
			
			for(int j = 0; j < 4; j++) {
				meno = arrayList_nemocnice.get(random.nextInt(97)) + " " + mesto;
				temp[j] = meno;
				//System.out.println(meno + " " + mesto);
				if(j >= 1) {
					while(temp[0].equals(temp[1])) {
						meno = arrayList_nemocnice.get(random.nextInt(97)) + " " + mesto;
						temp[j] = meno;
					}
				}
				if(j == 2) {
					while((temp[1].equals(temp[2])) || (temp[0].equals(temp[2]))) {
						meno = arrayList_nemocnice.get(random.nextInt(97)) + " " + mesto;
						temp[j] = meno;
					}
				}
				if(j == 3) {
					while((temp[0].equals(temp[3])) || (temp[1].equals(temp[3])) || (temp[2].equals(temp[3]))) {
						meno = arrayList_nemocnice.get(random.nextInt(97)) + " " + mesto;
						temp[j] = meno;
					}
				}
				PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
			    preparedStmt.setString (1, meno);
			    preparedStmt.setString (2, mesto);
			    preparedStmt.setString (3, "Česká republika");
			    	      
			    preparedStmt.execute();


				System.out.println(meno + " " + mesto);
				
			}
		}
	}

}
