package br.com.upf.trabalho.ws.view.service;

import br.com.upf.trabalho.ws.beans.Cliente;
import br.com.upf.trabalho.ws.beans.Pedido;

public class ContainerResponse {
	
	private String message;
	private Pedido pedido;
	private Cliente cliente;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
