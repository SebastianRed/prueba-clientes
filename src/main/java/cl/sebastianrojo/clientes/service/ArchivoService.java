package cl.sebastianrojo.clientes.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.sebastianrojo.clientes.model.CategoriaEnum;
import cl.sebastianrojo.clientes.model.Cliente;

public class ArchivoService {

	ClienteService clienteServicio;
	Scanner sc = new Scanner(System.in);

	public ArrayList<Cliente> cargarDatos() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clienteServicio = new ClienteService();
		System.out.println("CARGAR DATOS");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		System.out.println("(Por defecto: src/main/resources/DBClientes.csv)");
		File file = new File(sc.nextLine());
		System.out.println("-----------------------------------------------");
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				while (line != null) {
					String[] clienteLine = line.split(",");
					CategoriaEnum categoria = clienteLine[4].equals(CategoriaEnum.ACTIVO.toString())
							? CategoriaEnum.ACTIVO
							: CategoriaEnum.INACTIVO;
					Cliente cliente = new Cliente(clienteLine[0], clienteLine[1], clienteLine[2], clienteLine[3],
							categoria);
					clientes.add(cliente);
					line = br.readLine();
				}
				br.close();
				System.out.println("Datos cargados correctamente en la lista");
			} catch (IOException e) {
				System.out.println("Error al cargar archivo");
			}
		} else {
			System.out.println("Archivo inexistente");
		}
		return clientes;
	}

	public void exportarDatos(List<Cliente> clientes) {
		System.out.println("EXPORTAR DATOS");
		if (clientes.size() == 0) {
			System.out.println("Lista de clientes vacía");
		} else {
			System.out.println("Seleccione el formato a exportar:");
			System.out.println("1.- Formato csv");
			System.out.println("2.- Formato txt");
			System.out.println("Ingrese una opción para exportar:");
			try {
				int opcion = Integer.parseInt(sc.nextLine());
				System.out.println("----------------------------------");
				if (opcion != 1 && opcion != 2) {
					System.out.println("Opción inválida");
				} else {
					System.out.println("Ingresa la ruta en donde desea exportar el archivo ." + (opcion == 1 ? "csv" : "txt"));
					System.out.println("dentro del directorio src/main/resources/");
					String ruta = sc.nextLine();
					switch (opcion) {
					case 1:
						ExportadorCSV exportarCSV = new ExportadorCSV();
						exportarCSV.exportar(clientes, ruta);
						break;
					case 2:
						ExportadorTXT exportarTXT = new ExportadorTXT();
						exportarTXT.exportar(clientes, ruta);
						break;
					default:
						System.out.println("Opción inválida");
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Error al intentar exportar datos");
			}
		}

	}

}
