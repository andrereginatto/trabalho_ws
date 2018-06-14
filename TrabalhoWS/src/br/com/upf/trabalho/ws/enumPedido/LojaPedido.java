package br.com.upf.trabalho.ws.enumPedido;

public enum LojaPedido {
	PB("PEDROSTORE"), AR("ANDRESTORE"), UPF("UPFSTORE"), RE("RICARDOSTORE"), NS("NSEISTORE");

	public String store;

	LojaPedido(String status) {
		store = status;
	}
}

