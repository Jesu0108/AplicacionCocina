package vista.intermedias;

import java.util.List;

import controlador.ControladorGeneral;
import modelo.intermedias.Alimento_x_servicio;
import validaciones.ValidaLibrary;

public class Alimento_x_servicioView {
	public static void menuAlimXServ(ControladorGeneral controlador) {
		int bOpcion = 0;
		do {
			bOpcion = opcionMenuAlimXServ();
			switch (bOpcion) {

			case 1: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Eliminado correctamente");
				} else {
					System.out.println("Error al eliminar el historial");
				}
				break;
			case 2: // Mostrar
				System.out.println(mostrar(controlador));
				break;
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 3);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int opcionMenuAlimXServ() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\nGestion de Materials");
		System.out.println("#############################");
		System.out.println("1. Eliminar.");
		System.out.println("2. Mostrar");
		System.out.println("3. Volver.");

		while (errorControl) {
			try {
				bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 3, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		return bOpcion;
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		System.out.println("Se va a eliminar todo el historial...\n");
		return controlador.getInterCtrl().getAlimXservCtrl().remove();
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Alimento_x_servicio> mostrar(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getAlimXservCtrl().HistorialAlimXServ();
	}
}
