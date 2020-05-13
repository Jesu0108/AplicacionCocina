package vista.almacen;

import controlador.ControladorGeneral;
import modelo.almacen.Alimento;
import validaciones.ValidaLibrary;

public class AlimentoView {
	public static void menuServicio(ControladorGeneral controlador) {
		byte bOpcion = 0;
		do {
			bOpcion = opcionMenuServicio();
			switch (bOpcion) {
			case 1: // Aniadir
				if (aniadir(controlador) != 0) {
					System.out.println("Alimento aniadido");
				} else {
					System.out.println("Error al aniadir el Alimento");
				}
				break;
			case 2: // Modificar
				if (modificar(controlador) != 0) {
					System.out.println("Alimento modificado");
				} else {
					System.out.println("Error al modificar el Alimento");
				}
				break;
			case 3: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Alimento eliminado");
				} else {
					System.out.println("Error al eliminar el Alimento");
				}
				break;
			case 4: // Buscar
				if (buscar(controlador) != null) {
					System.out.println(buscar(controlador));
				} else {
					System.out.println("Error al buscar el Alimento");
				}
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

		System.out.println("\n\nGestion de Alimentos");
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
		String sNombre_alimento = "";
		byte bCantidad = 0;

		while (errorControl) {
			try {
				sNombre_alimento = ValidaLibrary.leer("Introduzca el tipo de Alimento que va a aniadir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bCantidad = (byte) ValidaLibrary.valida("Introduzca la cantidad de alimentos que va a aniadir (1 - 100): ",1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Alimento oAlimento = new Alimento(sNombre_alimento, bCantidad);

		return controlador.getAlmacenCtrl().getAlimentoCtrl().add(oAlimento);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_alimento = "";

		while (errorControl) {
			try {
				sNombre_alimento = ValidaLibrary.leer("Introduzca el tipo de Alimento que va a aniadir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Alimento oAlimento = new Alimento(sNombre_alimento);
		return controlador.getAlmacenCtrl().getAlimentoCtrl().remove(oAlimento);
	}

	// -------------------------------------------------------------------------------------------------------

	public static Alimento buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_alimento = "";

		while (errorControl) {
			try {
				sNombre_alimento = ValidaLibrary
						.leer("Introduzca el nombre del tipo de servicio que va a buscar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		return controlador);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_alimento = "", sDateString = "", sNew_tipo_servicio = "";
		
		byte bTiempo_servicio = 0;

		while (errorControl) {
			try {
				sNombre_alimento = ValidaLibrary.leer("Introduzca el nombre de alimento que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		if (controlador.getAlmacenCtrl().getAlimentoCtrl() != null) {
			while (errorControl) {
				try {
					sNew_tipo_servicio = ValidaLibrary.leer("Introduzca el nuevo tipo de servicio que va a pedir: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			while (errorControl) {
				try {
					bTiempo_servicio = (byte) ValidaLibrary
							.valida("Introduzca el nuevo tiempo estimado de servicio (en horas): ", 1, 100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			while (errorControl) {
				try {
					sDateString = ValidaLibrary.leer("Introduzca una nuevo fecha para el servicio (22/5/2020): ");
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
		}

		Servicio oServicio = new Servicio(sNew_tipo_servicio, dFecha, bTiempo_servicio);
		return controlador.getUsuarioCtrl().getServicioCtrl().updateServicio(oServicio);
	}
}
