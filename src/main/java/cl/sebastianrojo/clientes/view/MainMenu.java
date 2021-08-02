package cl.sebastianrojo.clientes.view;

import java.util.Scanner;

import cl.sebastianrojo.clientes.service.ClienteService;
import cl.sebastianrojo.clientes.util.Utilidad;
import cl.sebastianrojo.clientes.service.ArchivoService;

public class MainMenu extends Menu {

	Scanner sc = new Scanner(System.in);
	ClienteService clienteServicio;
	ArchivoService archivoServicio;
		
	public MainMenu() {
		clienteServicio = new ClienteService();
		archivoServicio = new ArchivoService();
		iniciarMenu();
	}

	private void iniciarMenu() {
		int opcion;
		do {
			System.out.println("SISTEMA DE CLIENTES");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opción:");
			opcion = Integer.parseInt(sc.nextLine());
			if(opcion == 1) {
				listarClientes();
			} else if(opcion == 2) {
				agregarCliente();
			} else if(opcion == 3) {
				editarCliente();
			} else if(opcion == 4) {
				cargarDatos();
			} else if(opcion == 5) {
				exportarDatos();
			} else if(opcion == 6) {
				break;
			} else {
				System.out.println("Opción inválida, intente nuevamente");
			}
		} while(opcion != 6);
		terminarPrograma();
	}

	@Override
	public void listarClientes() {
		System.out.println("\n__________________________________");
		clienteServicio.listarClientes();
		System.out.println("\n__________________________________");
	}

	@Override
	public void agregarCliente() {
		System.out.println("\n__________________________________");
		clienteServicio.agregarCliente();
		System.out.println("\n__________________________________");
	}

	@Override
	public void editarCliente() {
		System.out.println("\n__________________________________");
		clienteServicio.editarCliente();
		System.out.println("\n__________________________________");
		
	}

	@Override
	public void cargarDatos() {
		System.out.println("\n__________________________________");
		clienteServicio.setListaClientes(archivoServicio.cargarDatos());
		System.out.println("\n__________________________________");
	}

	@Override
	public void exportarDatos() {
		System.out.println("\n__________________________________");
		archivoServicio.exportarDatos(clienteServicio.getListaClientes());
		System.out.println("\n__________________________________");
	}

	@Override
	public void terminarPrograma() {
		Utilidad.limpiarPantalla();
		Utilidad.mostrarMensaje("Finalizando sistema");
		System.exit(0);		
	}

}
