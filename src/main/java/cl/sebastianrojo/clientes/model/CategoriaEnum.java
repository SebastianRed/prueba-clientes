package cl.sebastianrojo.clientes.model;

public enum CategoriaEnum {
	
	ACTIVO("Activo"), INACTIVO("Inactivo");
	
	private String estado;

	private CategoriaEnum(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
