package br.com.upf.trabalho.ws.enumPedido;

public enum StatusPedido {
	PA("AUTORIZADO"), PF("FATURADO"), PET("TRANPORTE"), PE("ENTREGUE");

	public String pedStatus;

	StatusPedido(String status) {
		pedStatus = status;
	}
}
