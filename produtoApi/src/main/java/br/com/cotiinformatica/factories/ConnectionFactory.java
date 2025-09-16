package br.com.cotiinformatica.factories;



import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	
	
	public Connection getConnection() {
		try {

			var host = "jdbc:postgresql://localhost:5432/bd_produto";
			var user = "postgres";
			var pass = "sambonha";

			return DriverManager.getConnection(host, user, pass);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
