package br.com.upf.trabalho.ws.view.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse.Status;

import br.com.upf.trabalho.ws.beans.Cliente;
import br.com.upf.trabalho.ws.beans.Pedido;

@Path("ClienteResource")
public class ClienteResource {

	public static List<Cliente> clientes;
	public static HashMap<Long, Cliente> hashClientes;

	static {
		clientes = new ArrayList<>();
		hashClientes = new HashMap<>();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // formulario html
	public Response insertPostByForm(
			@FormParam("id") Long id, 
			@FormParam("nome") String nome,
			@FormParam("sobrenome") String sobrenome, 
			@FormParam("cpf") String cpf, 
			@FormParam("rg") String rg,
			@FormParam("telefone") String telefone, 
			@FormParam("email") String email,
			@FormParam("siteId") String siteId) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setTelefone(telefone);
		cliente.setEmai(email);
		cliente.setSiteId(siteId);

		Status status = null;
		String msg = null;

		try {
			if (cliente.getId() == 0 || cliente.getId().toString().isEmpty()) {
				msg = "Id do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getNome().isEmpty()) {
				msg = "Nome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSobrenome().isEmpty()) {
				msg = "Sobrenome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getCpf().isEmpty()) {
				msg = "CPF do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getRg().isEmpty()) {
				msg = "Rg do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getTelefone().isEmpty()) {
				msg = "Telefone do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getEmai().isEmpty()) {
				msg = "Email do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSiteId().isEmpty()) {
				msg = "ID da loja deve ser informado.";
				status = Status.BAD_REQUEST;
			} else {
				boolean flag = false;
				for( Cliente cli: clientes){
					if(cli.getId() == cliente.getId()) {
						flag=true;
					}
				}				
				if(flag==false) {
					clientes.add(cliente);
					msg = "Cliente integrado com sucesso!";
					hashClientes.put(cliente.getId(), cliente);
					status = Status.OK;
				}else {
					msg = "Já existe um cliente com este ID, operação não executada!";
					status = Status.NOT_ACCEPTABLE;
				}
			}

		} catch (Exception e) {

			return Response.serverError().build();
		}

		return Response
				.status(status)
				.type(MediaType.APPLICATION_JSON)
				.entity(new Gson().toJson(msg))
				.build();
	}

	@Path("insereCliente")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InserePedido(String ClienteJson) {
		Status status = null;
		String msg = null;
		Cliente cliente = new Gson().fromJson(ClienteJson, Cliente.class);

		try {
			if (cliente.getId() == 0) {
				msg = "Id do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getNome().isEmpty()) {
				msg = "Nome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSobrenome().isEmpty()) {
				msg = "Sobrenome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getCpf().isEmpty()) {
				msg = "CPF do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getRg().isEmpty()) {
				msg = "Rg do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getTelefone().isEmpty()) {
				msg = "Telefone do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getEmai().isEmpty()) {
				msg = "Email do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSiteId().isEmpty()) {
				msg = "ID da loja deve ser informado.";
				status = Status.BAD_REQUEST;
			} else {
				boolean flag = false;
				for( Cliente cli: clientes){
					if(cli.getId() == cliente.getId()) {
						flag=true;
					}
				}				
				if(flag==false) {
					clientes.add(cliente);
					msg = "Cliente integrado com sucesso!";
					hashClientes.put(cliente.getId(), cliente);
					status = Status.OK;
				}else {
					msg = "Já existe um cliente com este ID, operação não executada!";
					status = Status.NOT_ACCEPTABLE;
				}
				
			}

		} catch (Exception e) {

			return Response.serverError().build();
		}

		return Response
				.status(status)
				.type(MediaType.APPLICATION_JSON)
				.entity(new Gson().toJson(msg))
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCliente() {
		return new Gson().toJson(clientes);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buscaClientePorCpf/{cpf}")
	public String getClienteByCpf(@PathParam("cpf") String cpf) {
		Gson json = new Gson();
		List<Cliente> costumer = new ArrayList<>();
		
		for (Cliente cl : clientes) {
			if (cl.getCpf().equals(cpf)) {
				costumer.add(cl);
			}
		}

		if (costumer.size() > 0) {
			return json.toJson(costumer);
		} else {
			return json.toJson("Nenhum cliente com esse CPF");
		}
	}

	@DELETE
	@Path("{id}")
	public Response removeCliente(@PathParam("id") Long id) {
		Status status = null;
		String msg = null;
		
		for( Cliente cli: clientes){
			if(cli.getId()==id){
				clientes.remove(cli);
			}
		}
		
		try {
			if (!hashClientes.containsKey(id)) {
				msg = "Cliente não encontrado!";
				status = Status.NOT_FOUND;
			} else {
				hashClientes.remove(id);
				msg = "Cliente Removido com Sucesso!";
				status = Status.OK;

			}
			
			return Response
					.status(status)
					.type(MediaType.APPLICATION_JSON)
					.entity(new Gson().toJson(msg))
					.build();
			
		} catch (Exception e) {
			
			msg="ERRO: não identificado #Descubra!";
			status = status.NOT_FOUND;
			
			return Response
					.status(status)
					.type(MediaType.APPLICATION_JSON)
					.entity(new Gson().toJson(msg))
					.build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alteraCliente(String clienteJson) {

		Status status = null;
		String msg = null;
		Cliente cliente = new Gson().fromJson(clienteJson, Cliente.class);

		try {
			if (cliente.getId() == 0) {
				msg = "Id do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getNome().isEmpty()) {
				msg = "Nome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSobrenome().isEmpty()) {
				msg = "Sobrenome do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getCpf().isEmpty()) {
				msg = "CPF do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getRg().isEmpty()) {
				msg = "Rg do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getTelefone().isEmpty()) {
				msg = "Telefone do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getEmai().isEmpty()) {
				msg = "Email do Cliente não informado.";
				status = Status.BAD_REQUEST;
			} else if (cliente.getSiteId().isEmpty()) {
				msg = "ID da loja deve ser informado.";
				status = Status.BAD_REQUEST;
			} else {
				boolean flag=false;
				for( Cliente cli: clientes){
					if(cli.getId()==cliente.getId()){
						clientes.remove(cli);
						clientes.add(cliente);
						flag=true;
					}
				}
				if(flag==true) {
					hashClientes.put(cliente.getId(), cliente);
					msg = "Cliente alterado com Sucesso!";
					status = Status.OK;
				}else {
					msg = "Cliente não encontrado!";
					status = Status.NOT_FOUND;
				}

			}
		} catch (Exception e) {

			return Response.serverError().build();
		}
		return Response
				.status(status)
				.type(MediaType.APPLICATION_JSON)
				.entity(new Gson().toJson(msg))
				.build();

	}

}
