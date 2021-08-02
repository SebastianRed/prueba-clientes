package cl.sebastianrojo.clientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.sebastianrojo.clientes.model.CategoriaEnum;
import cl.sebastianrojo.clientes.model.Cliente;

public class ClienteService {

	Scanner sc = new Scanner(System.in);
	
	private Cliente cliente;
	private List<Cliente> listaClientes;

	public ClienteService() {
		listaClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {
		System.out.print("LISTA DE CLIENTES");
		if (listaClientes.size() == 0) {
			System.out.println("\nLista de clientes vacía");
		} else {
			for (Cliente cliente : listaClientes) {
				System.out.println("\n" + cliente.toString());
			}
		}
	}

	public void agregarCliente() {
		System.out.println("CREAR CLIENTE");
		Cliente cliente = new Cliente();
		System.out.println("Ingresar RUN de cliente:");
		cliente.setRunCliente(sc.nextLine());
		System.out.println("Ingresar nombre de cliente:");
		cliente.setNombreCliente(sc.nextLine());
		System.out.println("Ingresar apellido de cliente:");
		cliente.setApellidoCliente(sc.nextLine());
		System.out.println("Ingresar años como cliente");
		cliente.setAniosCliente(sc.nextLine());
		cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
		listaClientes.add(cliente);
	}

	public void editarCliente() {
		System.out.println("EDITAR CLIENTE");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.- Cambiar el estado del cliente");
		System.out.println("2.- Editar los datos ingresados del cliente");
		System.out.println("Ingrese opción:");
		int opcion = Integer.parseInt(sc.nextLine());
		switch (opcion) {
		case 1:
			System.out.println("Ingrese RUN del cliente a editar:");
			cliente = buscarCliente(sc.nextLine());
			System.out.println("-----Actualizando estado del Cliente----");
			if(cliente != null) {
				System.out.println("El estado actual es: " + cliente.getNombreCategoria().getEstado());
				System.out.println("1.- Si desea cambiar el estado del cliente a " + (!cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO) ? CategoriaEnum.ACTIVO.getEstado() : CategoriaEnum.INACTIVO.getEstado()).toLowerCase());
				System.out.println("2.- Si desea mantener el estado del cliente " + (cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO) ? CategoriaEnum.ACTIVO.getEstado() : CategoriaEnum.INACTIVO.getEstado()).toLowerCase());
				opcion = Integer.parseInt(sc.nextLine());
				switch(opcion) {
				case 1:
					cliente.setNombreCategoria(!cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO) ? CategoriaEnum.ACTIVO : CategoriaEnum.INACTIVO);
					System.out.println("Estado del cliente cambiado a " + cliente.getNombreCategoria().getEstado().toLowerCase());
					break;
				case 2:
					System.out.println("Estado del cliente no modificado");
					break;
				default:
					System.out.println("Opción inválida");
					break;
				}
			} else {
				System.out.println("Cliente inexistente");
			}
			break;
		case 2:
			System.out.println("Ingrese RUN del cliente a editar:");
			cliente = buscarCliente(sc.nextLine());
			if(cliente != null) {
				System.out.println("----Actualizando datos del cliente-----");
				System.out.println("1.-El RUN del cliente es: " + cliente.getRunCliente());
				System.out.println("2.-El Nombre del cliente es: " + cliente.getNombreCliente());
				System.out.println("3.-El Apellido del cliente es: " + cliente.getApellidoCliente());
				System.out.println("4.-Los años como cliente son: " + cliente.getAniosCliente());
				System.out.println("Ingrese opcion a editar de los datos del cliente:");
				opcion = Integer.parseInt(sc.nextLine());
				switch(opcion) {
				case 1:
					System.out.println("Ingrese nuevo RUN del cliente:");
					cliente.setRunCliente(sc.nextLine());
					System.out.println("Datos cambiados con éxito");
					break;
				case 2:
					System.out.println("Ingrese nuevo nombre del cliente:");
					cliente.setNombreCliente(sc.nextLine());
					System.out.println("Datos cambiados con éxito");
					break;
				case 3:
					System.out.println("Ingrese nuevo apellido del cliente:");
					cliente.setApellidoCliente(sc.nextLine());
					System.out.println("Datos cambiados con éxito");
					break;
				case 4:
					System.out.println("Ingrese años como cliente:");
					cliente.setAniosCliente(sc.nextLine());
					System.out.println("Datos cambiados con éxito");
					break;
				default:
					System.out.println("Opción inválida");
					break;
				}
			} else {
				System.out.println("Cliente inexistente");
			}
			break;
		default:
			System.out.println("Opción inválida");
			break;
		}
	}
	
	private Cliente buscarCliente(String rut) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(rut)) {
				return cliente;
			}
		}
		return null;
	}

}
