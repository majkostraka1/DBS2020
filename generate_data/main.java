package generate_data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class main {
	
public static Connection con;
	
	public static void CreateConnection() throws SQLException {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nemocnicny_system","root","qwerasdf");
			 System.out.println("connected!!!");
		 }
		 catch(ClassNotFoundException ex) {
			 System.out.print("NEPRIPOJILO TO NWM PRECO");
			 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	 }
	
	public static void main(String[] args) throws IOException, SQLException {
		CreateConnection();
		pacienti pacient = new pacienti();
		pacient.navsteva();
	}

}
