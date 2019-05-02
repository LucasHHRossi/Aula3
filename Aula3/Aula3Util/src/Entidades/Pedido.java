package Entidades;

public class Pedido {
	
	private String descricao;
	private String dt_compra;
	private boolean status;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDt_compra() {
		return dt_compra;
	}
	public void setDt_compra(String dt_compra) {
		this.dt_compra = dt_compra;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Pedido(String descricao, String dt_compra, boolean status) {
		this.descricao = descricao;
		this.dt_compra = dt_compra;
		this.status = status;
	}
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return descricao + "," + dt_compra + "," + status;
	}
}
