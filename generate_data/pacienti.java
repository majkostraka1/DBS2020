package generate_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;


public class pacienti {
	
	ArrayList<String> arrayList_mena = new ArrayList<>();
	ArrayList<String> arrayList_priezviska = new ArrayList<>();
	ArrayList<String> arrayList_slovmena = new ArrayList<>();
	ArrayList<String> arrayList_slovpriezviska = new ArrayList<>();
	ArrayList<String> arrayList_slovmenaz = new ArrayList<>();
	ArrayList<String> arrayList_slovpriezviskaz = new ArrayList<>();
	public static final String fileName="ZenskeMena.txt";
	public static final String fileName2="ZenskePriezviska.txt";
	public static final String fileName3="KrstneMena.txt";
	public static final String fileName4="Priezviska.txt";
	public static final String fileName5="MuzskeMena.txt";
	public static final String fileName6="MuzskePriezviska.txt";
	
	public ArrayList<String> napln_mena() {
		 
        try {
            File file = new File(fileName3);
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
	        File file = new File(fileName4);
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
	
	public ArrayList<String> napln_menam() {
		 
        try {
            File file = new File(fileName5);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_slovmena.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_slovmena;
	}
	
	public ArrayList<String> napln_priezviskam() {
		 
	    try {
	        File file = new File(fileName6);
	        Scanner myReader = new Scanner(file);
	        while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	//            System.out.println(data);
	            arrayList_slovpriezviska.add(data);
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Gotti an error");
	        e.printStackTrace();
	    }
	    return arrayList_slovpriezviska;
	}
	
	public ArrayList<String> napln_menaz() {
		 
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                arrayList_slovmenaz.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Gotti an error");
            e.printStackTrace();
        }
        return arrayList_slovmenaz;
}

	public ArrayList<String> napln_priezviskaz() {
		 
	    try {
	        File file = new File(fileName2);
	        Scanner myReader = new Scanner(file);
	        while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	//            System.out.println(data);
	            arrayList_slovpriezviskaz.add(data);
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Gotti an error");
	        e.printStackTrace();
	    }
	    return arrayList_slovpriezviskaz;
	}
	
	public void generate() throws SQLException {
		
		String query = " INSERT INTO pacient (meno, priezvisko, rodne_cislo, cislo_poistenca, ID_lekar)"
    	        + " VALUES (?, ?, ?, ?, ?)";
		int pom = 0;
		int pom2 = 0;
		long icp = 5610150838l;
		long datum;
		String meno;
		String priezvisko;
		int mesiac;
		int den;
		int add;
		String rodne_cislo;
		long rodne_cislo_final;
		
		Statement stmt = main.con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM sestricka ORDER BY RAND() LIMIT 226000");
		
		for(long i = 0; i < 800000; i++) {
			Random random = new Random();
			int r_int = random.nextInt(3);
			rodne_cislo = "";
			
			pom = random.nextInt(100);
			
			if(pom < 40) {
				pom2 = random.nextInt(20);
				mesiac = random.nextInt(12) + 1;
				den = random.nextInt(30) + 1;
				add = random.nextInt(9000) + 1000;
				if(pom2 < 10)
					rodne_cislo = "200" + pom2;
				else
					rodne_cislo = "20" + pom2;
				
				if(mesiac < 10)
					rodne_cislo = rodne_cislo + 0 + mesiac;
				else
					rodne_cislo += mesiac;
				
				if(den < 10)
					rodne_cislo = rodne_cislo + 0 + den + add;
				else
					rodne_cislo = rodne_cislo + den + add;
				
				rodne_cislo_final = Long.parseLong(rodne_cislo);
			}
			
			else {
				mesiac = random.nextInt(12) + 1;
				den = random.nextInt(30) + 1;
				add = random.nextInt(9000) + 1000;
				rodne_cislo = "19" + pom;
				
				if(mesiac < 10)
					rodne_cislo = rodne_cislo + 0 + mesiac;
				else
					rodne_cislo += mesiac;
				
				if(den < 10)
					rodne_cislo = rodne_cislo + 0 + den + add;
				else
					rodne_cislo = rodne_cislo + den + add;
				
				rodne_cislo_final = Long.parseLong(rodne_cislo);
				
			}
			//System.out.println(meno + " " + priezvisko + " " + id_lekar);
			
			if(r_int == 0) { // muzske slovenske
				meno = arrayList_slovmena.get(random.nextInt(213));
				priezvisko = arrayList_slovpriezviska.get(random.nextInt(716));
			}
			
			else if(r_int == 1) { // muzske slovenske
				meno = arrayList_slovmenaz.get(random.nextInt(194));
				priezvisko = arrayList_slovpriezviskaz.get(random.nextInt(924));
			}
			
			else { // muzske slovenske
				meno = arrayList_mena.get(random.nextInt(1999));
				priezvisko = arrayList_priezviska.get(random.nextInt(18839));
			}
			
	        while(rs.next()) {
	        	//System.out.println(meno + " " + priezvisko + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rodne_cislo_final + " " + icp);
	        	PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
		    	   preparedStmt.setString (1, meno);
		    	   preparedStmt.setString (2, priezvisko);
		    	   preparedStmt.setLong (3, rodne_cislo_final);
		    	   preparedStmt.setLong (4, icp);
		    	   preparedStmt.setLong (5, rs.getInt(4));
		    	      
		    	   preparedStmt.execute();
	        	break;
	        }
				
				
			icp += 3;
				
		}
		
		System.out.println("done");
	}
	
	public void navsteva() throws SQLException {
		
		String query = " INSERT INTO objednavka_u_lekara (datum_objednania, ID_sestricka, ID_lekar, cislo_poistenca)"
	        + " VALUES (?, ?, ?, ?)";
		long id_sestricka = 0;
		long id_lekar = 0;
		long cislo_poistenca = 0;
		long datum = 20200914;
		Random random = new Random();
		long temp = 0, temp2 = 0;
		String temp3 = "";
		
		Statement stmt = main.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM pacient ORDER BY RAND() LIMIT 1100000");
		Statement stmt2 = main.con.createStatement();
		ResultSet rs2;
		
		//ResultSet rs2 = stmt.executeQuery("SELECT * FROM sestricka WHERE id_lekar = " + id_lekar);
		
		for(int i = 0; i < 50000; i++) {
			
			//rs = stmt.executeQuery("SELECT * FROM pacient ORDER BY RAND() LIMIT 10000");
			
			temp = random.nextInt(12) + 1;
			temp2 = random.nextInt(29) + 1;
			temp3 = "";
			
			if(temp <= 4) {
				temp = 5;
				if(temp >= 10) {
					temp3 = "2020" + temp;
				}
				else
					temp3 = "20200" + temp;
				
			}
			else {
				if(temp >= 10) {
					temp3 = "2020" + temp;
				}
				else
					temp3 = "20200" + temp;
			}
			
			if(temp2 <= 9) {
				temp3 = temp3 + "0" + temp2;
			}
			else
				temp3 = temp3 + temp2;
			
			
			
			datum = Long.parseLong(temp3);
			
			while(rs.next()) {
				
				//id_sestricka = Long.parseLong(rs.getString(2));
				id_lekar = Long.parseLong(rs.getString(5));
				cislo_poistenca = Long.parseLong(rs.getString(4));
				rs2 = stmt2.executeQuery("SELECT * FROM sestricka WHERE id_lekar = " + id_lekar);
				while(rs2.next()) {
					id_sestricka = Long.parseLong(rs2.getString(3));
					break;
				}
				
				break;
			}
			System.out.println(id_sestricka + " " + id_lekar + " " + cislo_poistenca + " " + datum);
			
			PreparedStatement preparedStmt = (PreparedStatement) main.con.prepareStatement(query);
	    	   preparedStmt.setLong (1, datum);
	    	   preparedStmt.setLong (2, id_sestricka);
	    	   preparedStmt.setLong (3, id_lekar);
	    	   preparedStmt.setLong (4, cislo_poistenca);
	    	      
	    	   preparedStmt.execute();
		}
		
		
	
	}

}
