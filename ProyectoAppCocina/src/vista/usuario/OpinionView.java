package vista.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

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
				if (buscar(controlador) != null) {
					System.out.println(buscar(controlador));
				} else {
					System.out.println("Error al buscar el Opinion");
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
		String sNombre_tipo_Opinion = "", sDateString = "";
		Date dFecha = null;
		byte bTiempo_Opinion = 0;

		while (errorControl) {
			try {
				sNombre_tipo_Opinion = ValidaLibrary.leer("Introduzca el tipo de Opinion que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bTiempo_Opinion = (byte) ValidaLibrary.valida("Introduzca el tiempo estimado de Opinion (en horas): ",
						1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				sDateString = ValidaLibrary.leer("Introduzca una fecha para el Opinion (22/5/2020): ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				dFecha = new SimpleDateFormat("dd/MM/yyyy").parse(sDateString);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Opinion oOpinion = new Opinion(sNombre_tipo_Opinion, dFecha, bTiempo_Opinion);

		return controlador.getUsuarioCtrl().getOpinionCtrl().add(oOpinion);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Opinion = "";

		while (errorControl) {
			try {
				sNombre_tipo_Opinion = ValidaLibrary.leer("Introduzca el tipo de Opinion que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Opinion oOpinion = new Opinion(sNombre_tipo_Opinion);
		return controlador.getUsuarioCtrl().getOpinionCtrl().remove(oOpinion);
	}

	// -------------------------------------------------------------------------------------------------------

	public static Opinion buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Opinion = "";

		while (errorControl) {
			try {
				sNombre_tipo_Opinion = ValidaLibrary
						.leer("Introduzca el nombre del tipo de Opinion que va a buscar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		return controlador.getUsuarioCtrl().getOpinionCtrl().searchOpinion(sNombre_tipo_Opinion);
	}
}

