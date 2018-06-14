package br.com.upf.trabalho.ws.beans;
import java.util.Date;
import br.com.upf.trabalho.ws.enumPedido.LojaPedido;
import br.com.upf.trabalho.ws.enumPedido.StatusPedido;

public class Pedido {
	
	//status Pedido: PA=aprovado, PF=faturado, PET=enviado para Transportadora, PE=Entregue
	//PB("PEDROSTORE"), AR("ANDRESTORE"), UPF("UPFSTORE"), RE("RICARDOSTORE"), NS("NSEISTORE")
	
	private Long id;
	private Date dataVenda;
	private StatusPedido statusAtualPedido;
	private LojaPedido loja;
	private double totalPedido;
	private double totalDisconto;
	private double precoFrete;
	private double discontoFrete;
	private String coupon;
	private String obs;
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;

		//SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//String data = fmt.format(dataVenda);
		//this.dataVenda = fmt.parse(data);
	}
	public StatusPedido getStatusAtualPedido() {
		return statusAtualPedido;
	}
	public void setStatusAtualPedido(StatusPedido statusAtualPedido) {
		this.statusAtualPedido = statusAtualPedido;
	}
	public LojaPedido getLoja() {
		return loja;
	}
	public void setLoja(LojaPedido loja) {
		this.loja = loja;
	}
	public double getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	public double getTotalDisconto() {
		return totalDisconto;
	}
	public void setTotalDisconto(double totalDisconto) {
		this.totalDisconto = totalDisconto;
	}
	public double getPrecoFrete() {
		return precoFrete;
	}
	public void setPrecoFrete(double precoFrete) {
		this.precoFrete = precoFrete;
	}
	public double getDiscontoFrete() {
		return discontoFrete;
	}
	public void setDiscontoFrete(double discontoFrete) {
		this.discontoFrete = discontoFrete;
	}

	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

//{
//	"id": "8449",
//    "dataVenda": "25/05/2018 17:01:30",
//    "StatusPedido": "PRF",
//    "loja": "ELLUS",
//    "totalPedido": "1076.40",
//    "totalDisconto": "119.60",
//    "precoFrete": "18.00",
//    "discontoFrete": "0.0",
//    "coupon": "SASA" ,
//    "obs": "asasa",
//    "cliente": {
//    	"id": "12",
//    	"nome": "Juca Cadela",
//    	"sobrenome": "colto",
//    	"dataAniversario": "17/08/1957",
//    	"cpf": "12126",
//    	"rg": "123439",
//    	"telefone": "3328484",
//    	"email": "cadeladjow@gmail.com",
//    	"siteId": "RC"
//    	
//    }
//}
