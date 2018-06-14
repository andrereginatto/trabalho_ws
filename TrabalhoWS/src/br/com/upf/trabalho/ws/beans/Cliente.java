package br.com.upf.trabalho.ws.beans;

public class Cliente {	
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String telefone;
	private String email;
	private String siteId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmai() {
		return email;
	}
	public void setEmai(String email) {
		this.email = email;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	

}

//"customer": {
//    "firstName": "MISLENE PEREIRA",
//    "lastName": "BUENO",
//    "nickName": null,
//    "birthDate": "15/02/1984",
//    "cpf": "22561776883",
//    "rg": "",
//    "gender": "female",
//    "phoneHome": "19193225902",
//    "branchPhoneHome": null,
//    "cell": null,
//    "email": "mislene_bueno@hotmail.com",
//    "siteId": "bobst