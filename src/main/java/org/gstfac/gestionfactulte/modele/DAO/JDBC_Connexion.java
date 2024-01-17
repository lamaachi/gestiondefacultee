package org.gstfac.gestionfactulte.modele.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connexion {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String LOCAL = "jdbc:mysql://localhost:3306/dbfacucd";
	private static final String USER = "root";
	private static final String PASSWD = "";
	public static Connection jdbc_con = null;
	
	public static Connection getConnetion()  {
		   if (jdbc_con == null) {
				try {
					Class.forName( DRIVER );
					System.out.println(DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					jdbc_con = DriverManager.getConnection(LOCAL,USER,PASSWD);
					System.out.println(LOCAL);
				} catch (SQLException e) {
					e.printStackTrace();
				}
        }
        return jdbc_con;
    }

}
