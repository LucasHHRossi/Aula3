package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConexao() {
		String usuario = "sa";
		String senha = "logatti";
		//String usuario = "sa";
		//String senha = "Programador1%";
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 String dbUrl = "jdbc:sqlserver://localhost:1434;databaseName=chatBox" +
                     ";user=" + usuario + ";password=" + senha + ";";
			 
			 //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 //String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=chatBox" +
                     //";user=" + usuario + ";password=" + senha + ";";
			 
			 Connection conexao = DriverManager.getConnection(dbUrl);
			 
			 if(conexao != null) {
				 System.out.println("Conexão obtida com sucesso!" + conexao);
				 return conexao;
			 }
			 
		}catch (ClassNotFoundException e) {
		    // Erro caso o driver JDBC não foi instalado
		    e.printStackTrace();
		    
		} catch (SQLException e) {
		    // Erro caso haja problemas para se conectar ao banco de dados
		    e.printStackTrace();
		}
		
		return null;
	}
}
