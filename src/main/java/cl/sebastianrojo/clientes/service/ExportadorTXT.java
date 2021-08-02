package cl.sebastianrojo.clientes.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import cl.sebastianrojo.clientes.model.Cliente;

public class ExportadorTXT extends Exportador {
	
	List<Cliente> listaClientes;
	String fileName;
	
	@Override
	public void exportar(List<Cliente> listaClientes, String fileName) {
		String data = "Listado de clientes\n";
		File directorio = new File("src/main/resources");
		if(!fileName.endsWith(".txt")) {
			fileName = fileName.concat(".txt");
		}
		File fichero = new File(directorio + "/" + fileName);		
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
		try {
			fichero.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			for(Cliente cliente : listaClientes) {
				data += "\n" + cliente.toString() + "\n";
			}
			bw.write(data);
			bw.close();
		} catch (Exception e) {
			System.out.println("Error al generar archivo txt");
		}
	}

}
