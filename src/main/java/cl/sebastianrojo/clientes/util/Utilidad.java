package cl.sebastianrojo.clientes.util;

public class Utilidad {

	public static void limpiarPantalla() {
		for(int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
}
