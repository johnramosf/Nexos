package com.credibanco.bankinc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.credibanco.bankinc.dao.ClienteDao;
import com.credibanco.bankinc.model.Cliente;


public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public List<com.credibanco.bankinc.model.Cliente> listarClientes() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public void guardar(com.credibanco.bankinc.model.Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	public void eliminar(com.credibanco.bankinc.model.Cliente cliente) {
		
      clienteDao.delete(cliente);
	}

	@Override
	public com.credibanco.bankinc.model.Cliente encontrarPorId(String noCliente) {
		Long clienteId = Long.parseLong(noCliente);
		return clienteDao.findById(clienteId).get();
	}

}