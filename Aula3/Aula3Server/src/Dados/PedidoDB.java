package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Pedido;
import Util.ConnectionFactory;

public class PedidoDB {
	
	private static PedidoDB instance;
	private final ConnectionFactory conexao;
	private final Connection connection;
	private Statement stmt;
	
	private PedidoDB() {
		conexao = new ConnectionFactory();
		connection = conexao.getConexao();
	}
	
	public static PedidoDB getInstance() {
		if(instance == null)
			return new PedidoDB();
		return instance;
	}
	
	// Inserir Registro na Tabela
	public boolean inserir(Pedido p) {
		try {
			stmt = connection.createStatement();
			String sql = "INSERT INTO Pedido (descricao, dt_compra, status) VALUES ('"+ p.getDescricao() +"','"+ p.getDt_compra() +"','" +p.getStatus() +"')";
			System.out.println(sql);
			stmt.execute(sql);
			stmt.close();
			connection.close();
			System.out.println("inserido com sucesso!");
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	// Buscar Registro na Tabela
	public List<Pedido> lerTodos() throws Exception{
		   List<Pedido> pedido = new ArrayList<Pedido>();
		   PreparedStatement p = connection.prepareStatement("SELECT * FROM Pedido");
		   ResultSet rs = p.executeQuery();
		   while(rs.next()){
		      Pedido p1 = new Pedido();
		      p1.setDescricao(rs.getString("descricao"));
		      p1.setDt_compra(rs.getString("dt_compra"));
		      p1.setStatus(rs.getBoolean("status"));
		      pedido.add(p1);
		   }
		   rs.close();
		   p.close();
		   return pedido;
		}

	// Atualizar Registro na Tabela
	public boolean Update(int id, Pedido pedido) throws SQLException {
		 PreparedStatement p = connection.prepareStatement("UPDATE PEDIDO SET descricao = ?, dt_compra = ?, status = ? where num_pedido = '"+ id +"'");
		   p.setString(1, pedido.getDescricao());
		   p.setString(2, pedido.getDt_compra());
		   p.setBoolean(3, pedido.getStatus());
		   p.executeUpdate();
		   p.close();
		return true;
	}

	// Deletar Registro na Tabela
	public int Delete(int id) throws SQLException {
		 Statement p = connection.createStatement();
		   int linhas = p.executeUpdate("DELETE FROM PEDIDO WHERE num_pedido = '"+ id +"'"); 
		   p.close();
		return linhas;
	}
}
