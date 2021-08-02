package cl.sebastianrojo.clientes.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import cl.sebastianrojo.clientes.model.Cliente;

public class ExportadorCSV extends Exportador {
	
	List<Cliente> listaClientes;
	String fileName;
	
	@Override
	public void exportar(List<Cliente> listaClientes, String fileName) {
		String data = "";
		File directorio = new File("src/main/resources");
		if(!fileName.endsWith(".csv")) {
			fileName = fileName.concat(".csv");
		}
		File fichero = new File(directorio + "/" + fileName);		
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
		try {
			fichero.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			for(Cliente cliente : listaClientes) {
				data += cliente.getRunCliente() + "," + cliente.getNombreCliente() + "," + cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + "," + cliente.getNombreCategoria() + "\n";
			}
			bw.write(data);
			bw.close();
		} catch (Exception e) {
			System.out.println("Error al generar archivo csv");
		}
	}

}
