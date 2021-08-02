package cl.sebastianrojo.clientes.model;

public class Cliente {
	
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	public Cliente() {
		
	}
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "- Datos del cliente -\nRUN: " + runCliente + "\nNombre: " + nombreCliente + "\nApellido: " + apellidoCliente + "\nAños como cliente: " + aniosCliente + "\nCategoría de cliente: " + nombreCategoria.getEstado();
	}
	
}
