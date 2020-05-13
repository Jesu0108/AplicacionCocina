package vista.almacen;

import java.text.SimpleDateFormat;
import java.util.Date;

import controlador.ControladorGeneral;
import modelo.almacen.Material;
import validaciones.ValidaLibrary;

public class MaterialView {
	public static void menuMaterial(ControladorGeneral controlador) {
		byte bOpcion = 0;
		do {
			bOpcion = opcionMenuMaterial();
			switch (bOpcion) {
			case 1: // Aniadir
				if (aniadir(controlador) != 0) {
					System.out.println("Material aniadido");
				} else {
					System.out.println("Error al aniadir el material");
				}
				break;
			case 2: // Modificar
				if (modificar(controlador) != 0) {
					System.out.println("Material modificado");
				} else {
					System.out.println("Error al modificar el material");
				}
				break;
			case 3: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Material eliminado");
				} else {
					System.out.println("Error al eliminar el material");
				}
				break;
			case 4: // Buscar
				if (buscar(controlador) != null) {
					System.out.println(buscar(controlador));
				} else {
					System.out.println("Error al buscar el material");
				}
				break;
			default:
				System.out.println("Volviendo...\n");
			}

		} while (bOpcion != 5);
	}

	// -------------------------------------------------------------------------------------------------------

	public static byte opcionMenuMaterial() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\n\nGestion de Materials");
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
		String sNombre_tipo_Material = "", sDateString = "";
		Date dFecha = null;
		byte bTiempo_Material = 0;

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary.leer("Introduzca el tipo de Material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bTiempo_Material = (byte) ValidaLibrary.valida("Introduzca el tiempo estimado de Material (en horas): ",
						1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				sDateString = ValidaLibrary.leer("Introduzca una fecha para el Material (22/5/2020): ");
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

		Material oMaterial = new Material(sNombre_tipo_Material, dFecha, bTiempo_Material);

		return controlador.getUsuarioCtrl().getMaterialCtrl().add(oMaterial);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Material = "";

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary.leer("Introduzca el tipo de Material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Material oMaterial = new Material(sNombre_tipo_Material);
		return controlador.getUsuarioCtrl().getMaterialCtrl().remove(oMaterial);
	}

	// -------------------------------------------------------------------------------------------------------

	public static Material buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Material = "";

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary
						.leer("Introduzca el nombre del tipo de Material que va a buscar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		return controlador.getUsuarioCtrl().getMaterialCtrl().searchMaterial(sNombre_tipo_Material);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Material = "", sDateString = "", sNew_tipo_Material = "";
		Date dFecha = null;
		byte bTiempo_Material = 0;

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary.leer("Introduzca el tipo de Material que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		if (controlador.getUsuarioCtrl().getMaterialCtrl().searchMaterial(sNombre_tipo_Material) != null) {
			while (errorControl) {
				try {
					sNew_tipo_Material = ValidaLibrary.leer("Introduzca el nuevo tipo de Material que va a pedir: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			while (errorControl) {
				try {
					bTiempo_Material = (byte) ValidaLibrary
							.valida("Introduzca el nuevo tiempo estimado de Material (en horas): ", 1, 100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			while (errorControl) {
				try {
					sDateString = ValidaLibrary.leer("Introduzca una nuevo fecha para el Material (22/5/2020): ");
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

		Material oMaterial = new Material(sNew_tipo_Material, dFecha, bTiempo_Material);
		return controlador.getUsuarioCtrl().getMaterialCtrl().updateMaterial(oMaterial);
	}
}
