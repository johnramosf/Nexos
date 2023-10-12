package com.credibanco.bankinc.service;

import java.util.List;

import com.credibanco.bankinc.model.Cliente;

public interface ClienteService {
	
    public List<Cliente> listarClientes();
    
    public void guardar(Cliente cliente);
    
    public void eliminar(Cliente cliente);
    
    public Cliente encontrarPorId(String noCliente);
      

}
