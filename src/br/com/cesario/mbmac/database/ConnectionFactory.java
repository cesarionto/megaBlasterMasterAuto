package br.com.cesario.mbmac.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Essa classe é responsavel por fazer uma conexão com o MySQL atraves da string. 
 * @author cesar
 *
 */
public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mbma",
					"root", "");
		} catch (SQLException e) {
			throw new RuntimeException (e);
		} catch (ClassNotFoundException e){
			throw new RuntimeException (e);
		}
	}
}