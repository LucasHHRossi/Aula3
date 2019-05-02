package Util;

import java.sql.SQLException;
import java.util.List;

import Dados.PedidoDB;
import Entidades.Pedido;

public class TestarConexao {
	
	public static void main(String args[]) throws Exception{
		ConnectionFactory test = new ConnectionFactory();
		test.getConexao();
		//inserir();
		//ler();
		//atualizar();
		//deletar();
	}

	// Inserir Registro na Tabela
	public static void inserir() {
		Pedido pedido = getPedido();
		PedidoDB.getInstance().inserir(pedido);
		
	}

	private static Pedido getPedido() {
		return new Pedido("Verificar Pedido","05/03/2019",true );
	}
	
	// Lêr todos os registro da tabela
	private static void ler() throws Exception {
		List<Pedido> pedido = PedidoDB.getInstance().lerTodos();
		for (Pedido items : pedido) {
			System.out.println(items);
		}
	}
	
	/* Atualizar um registro na tabela
	private static void atualizar() throws SQLException {
		int id = 2;
		Pedido pedido = updatePedido();
		boolean update = PedidoDB.getInstance().Update(id, pedido);
		if(update)
			System.out.println("Atualizado com sucesso!!!");
	}

	private static Pedido updatePedido() {
		
		return new Pedido("Pedido Verificado Atualizado","07/04/2019",true);
	}
	
	// Deletar Registro na Tabela
	private static void deletar() throws SQLException {
		int id = 3;
		int delete = PedidoDB.getInstance().Delete(id);
		if(delete >= 1)
			System.out.println(delete + " linha deletada!!!");
		
	}*/

}
