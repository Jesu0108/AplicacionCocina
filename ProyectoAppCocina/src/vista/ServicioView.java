package vista;

import java.sql.Date;

import controlador.ControladorGeneral;
import modelo.usuario.Servicio;
import validaciones.ValidaLibrary;

public class ServicioView {
	public static void menuServicio(ControladorGeneral controlador) {
		byte bOpcion = 0;
		do {
			bOpcion = opcionMenuServicio();
			switch (bOpcion) {
			case 1: // Aniadir
				if (aniadir(controlador) != 0) {
					System.out.println("Servicio aniadido");
				} else {
					System.out.println("Error al aniadir el servicio");
				}
				break;
			case 2: // Modificar

				break;
			case 3: // Eliminar

				break;
			case 4: // Buscar

				break;
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 5);
	}

	// -------------------------------------------------------------------------------------------------------

	public static byte opcionMenuServicio() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\n\nGestion de Servicios");
		System.out.println("#############################");
		System.out.println("1. Aniadir.");
		System.out.println("2. Modificar.");
		System.out.println("3. Eliminar.");
		System.out.println("4. Buscar.");
		System.out.println("5. Volver.");

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

	public static int aniadir(ControladorGeneral controlador) {
		boolean errorControl = true;
		int iId_servicio = 0;
		String sNombre_tipo_servicio = "";
		Date dFecha = null;
		byte bTiempo_servicio = 0;

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a pedir: ");
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		while (errorControl) {
			try {
				bTiempo_servicio = (byte)ValidaLibrary.valida("Introduzca el tiempo estimado de servicio (en horas): ",1,100,3);
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Servicio oServicio = new Servicio(iId_servicio, sNombre_tipo_servicio, dFecha, bTiempo_servicio);

		return controlador.getUsuarioCtrl().getServicioCtrl().add(oServicio);

	}

}
