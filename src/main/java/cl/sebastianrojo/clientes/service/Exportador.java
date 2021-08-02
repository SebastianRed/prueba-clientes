package cl.sebastianrojo.clientes.service;

import java.util.List;

import cl.sebastianrojo.clientes.model.Cliente;


public abstract class Exportador {
	
	public abstract void exportar(List<Cliente> listaClientes, String fileName);
	
}
