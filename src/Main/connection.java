package Main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.mysql.jdbc.PreparedStatement;

import tables.Pacient;

public class connection {
	
	public static Connection con;
	public static ConnectionSource connectionSource = null;
	
	public void CreateConnection() throws SQLException {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nemocnicny_system","root","qwerasdf");
			 
			 connectionSource = new JdbcConnectionSource("jdbc:mysql://localhost:3306/nemocnicny_system","root","qwerasdf");
			 
			 System.out.println("connected!!!");
		 }
		 catch(ClassNotFoundException ex) {
			 System.out.print("NEPRIPOJILO TO NWM PRECO");
			 Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
		 }
	 }



}
