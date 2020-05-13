package vista.usuario;

import java.util.List;

import controlador.ControladorGeneral;
import modelo.usuario.Opinion;
import validaciones.ValidaLibrary;

public class OpinionView {
	public static void menuOpinion(ControladorGeneral controlador) {
		byte bOpcion = 0;
		do {
			bOpcion = opcionMenuOpinion();
			switch (bOpcion) {
			case 1: // Aniadir
				if (aniadir(controlador) != 0) {
					System.out.println("Opinion aniadida");
				} else {
					System.out.println("Error al aniadir su Opinion");
				}
				break;
			case 2: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Opinion eliminado");
				} else {
					System.out.println("Error al eliminar el Opinion");
				}
				break;
			case 3: // Buscar
				if (mostrar(controlador) != null) {
					System.out.println(mostrar(controlador));
				} else {
					System.out.println("Error al mostrar las opiniones");
				}
				break;
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 4);
	}

	// -------------------------------------------------------------------------------------------------------

	public static byte opcionMenuOpinion() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\n\nGestion de Opinions");
		System.out.println("#############################");
		System.out.println("1. Aniadir.");
		System.out.println("2. Eliminar.");
		System.out.println("3. Buscar.");
		System.out.println("4. Volver.");

		while (errorControl) {
			try {
				bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 4, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		return bOpcion;
	}

	// -------------------------------------------------------------------------------------------------------

	public static int aniadir(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sCritica = "";
		byte bPuntuacion = 0;

		while (errorControl) {
			try {
				sCritica = ValidaLibrary.leer("Introduzca una critica: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bPuntuacion = (byte) ValidaLibrary.valida("Introduzca la puntuación (1 - 10): ",1, 10, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}


		Opinion oOpinion = new Opinion(sCritica, bPuntuacion);

		return controlador.getUsuarioCtrl().getOpinionCtrl().add(oOpinion);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sCritica = "";
		byte bPuntuacion = 0;

		while (errorControl) {
			try {
				sCritica = ValidaLibrary.leer("Introduzca una critica: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bPuntuacion = (byte) ValidaLibrary.valida("Introduzca la puntuación (1 - 10): ",1, 10, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Opinion oOpinion = new  Opinion(sCritica, bPuntuacion);
		return controlador.getUsuarioCtrl().getOpinionCtrl().remove(oOpinion);
	}

	// -------------------------------------------------------------------------------------------------------

	public static List<Opinion> mostrar(ControladorGeneral controlador) {
		return controlador.getUsuarioCtrl().getOpinionCtrl().buscarOpiniones();
	}
}

