package vista.intermedias;

import java.util.List;

import controlador.ControladorGeneral;
import modelo.intermedias.Alimento_x_servicio;
import modelo.intermedias.Catador_x_servicio;
import modelo.intermedias.Cocinero_x_servicio;
import modelo.intermedias.Empresa_x_servicio;
import modelo.intermedias.Material_x_servicio;
import validaciones.ValidaLibrary;

public class HistorialesView {
	public static void menuHistorial(ControladorGeneral controlador) {
		byte bOpcion = 0;
		do {
			bOpcion = opcionMenuHistoriales();
			switch (bOpcion) {
			case 1: // Alimentos
				if (mostrarAlim(controlador) != null) {
					System.out.println(mostrarAlim(controlador));
				} else {
					System.out.println("Error al aniadir el alimento");
				}
				break;
			case 2: // Material
				if (mostrarMaterial(controlador) != null) {
					System.out.println(mostrarMaterial(controlador));
				} else {
					System.out.println("Error al modificar el alimento");
				}
				break;
			case 3: // Catador
				if (mostrarCatador(controlador) != null) {
					System.out.println(mostrarCatador(controlador));
				} else {
					System.out.println("Error al eliminar el alimento");
				}
				break;
			case 4: // Cocinero
				if (mostrarCatador(controlador) != null) {
					System.out.println(mostrarCatador(controlador));
				} else {
					System.out.println("Error al buscar el alimento");
				}
				break;
			case 5: // Empresa
				if (mostrarEmpresa(controlador) != null) {
					System.out.println(mostrarEmpresa(controlador));
				} else {
					System.out.println("Error al buscar el alimento");
				}
				break;
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 6);
	}

	// -------------------------------------------------------------------------------------------------------

	public static byte opcionMenuHistoriales() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\nMenu de Historiales");
		System.out.println("#############################");
		System.out.println("1. Alimentos.");
		System.out.println("2. Material.");
		System.out.println("3. Catador.");
		System.out.println("4. Cocinero.");
		System.out.println("5. Empresa.");

		while (errorControl) {
			try {
				bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 5, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		return bOpcion;
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Alimento_x_servicio> mostrarAlim(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getAlimXservCtrl().HistorialAlimXServ();
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Material_x_servicio> mostrarMaterial(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getMatXservCtrl().HistorialCatXServ();
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Catador_x_servicio> mostrarCatador(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getCatXservCtrl().HistorialCatXServ();
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Cocinero_x_servicio> mostrarCocinero(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getCocXservCtrl().HistorialCocXServ();
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Empresa_x_servicio> mostrarEmpresa(ControladorGeneral controlador) {
		return controlador.getInterCtrl().getEmpXservCrtl().HistorialEmpXServ();
	}
}
