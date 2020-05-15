package vista.usuario;

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
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 2);
	}

	// -------------------------------------------------------------------------------------------------------

	public static byte opcionMenuOpinion() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\nGestion de Opiniones");
		System.out.println("#############################");
		System.out.println("1. Aniadir nueva opinion.");
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

		errorControl = true;
		while (errorControl) {
			try {
				bPuntuacion = (byte) ValidaLibrary.valida("Introduzca la puntuaci�n (1 - 10): ",1, 10, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Opinion oOpinion = new Opinion(sCritica, bPuntuacion);

		return controlador.getUsuarioCtrl().getOpinionCtrl().add(oOpinion);
	}
}

