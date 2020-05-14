package vista.almacen;

import controlador.ControladorGeneral;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;
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
		String sNombre_Material = "", sNombre_tipo_Material = "";
		byte bCantidad = 0;

		// Pido los datos del material

		while (errorControl) {
			try {
				sNombre_Material = ValidaLibrary.leer("Introduzca el nombre del Material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		while (errorControl) {
			try {
				bCantidad = (byte) ValidaLibrary
						.valida("Introduzca ls cantidad de material que va a necesitar (1 - 100): ", 1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		// Pido la PK de Tipo_material

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary
						.leer("Introduzca el nombre del tipo de material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Tipo_material oTipoMaterial = new Tipo_material(sNombre_tipo_Material);
		Material oMaterial = new Material(sNombre_Material, bCantidad, oTipoMaterial);

		return controlador.getAlmacenCtrl().getMaterialCtrl().add(oMaterial);
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
		return controlador.getAlmacenCtrl().getMaterialCtrl().remove(oMaterial);
	}

	// -------------------------------------------------------------------------------------------------------

	public static Material buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_Material = "";

		while (errorControl) {
			try {
				sNombre_Material = ValidaLibrary.leer("Introduzca el nombre del Material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		Material oMaterial = new Material(sNombre_Material);
		return controlador.getAlmacenCtrl().getMaterialCtrl().searchMaterialPorNombre(oMaterial);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_Material = "", sNombre_tipo_Material = "";
		byte bCantidad = 0;

		while (errorControl) {
			try {
				sNombre_Material = ValidaLibrary.leer("Introduzca el nombre de material que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Material oMat = new Material(sNombre_Material);
		
		if (controlador.getAlmacenCtrl().getMaterialCtrl().searchMaterialPorNombre(oMat) != null) {
			while (errorControl) {
				try {
					sNombre_Material = ValidaLibrary.leer("Introduzca el nombre del material que va a pedir: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			while (errorControl) {
				try {
					bCantidad = (byte) ValidaLibrary
							.valida("Introduzca ls cantidad de material que va a necesitar (1 - 100): ", 1, 100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			// Pido la PK de Tipo_material

			while (errorControl) {
				try {
					sNombre_tipo_Material = ValidaLibrary
							.leer("Introduzca el nombre del tipo de material que va a pedir: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}
		}

		Tipo_material oTipoMaterial = new Tipo_material(sNombre_tipo_Material);
		Material oMaterial = new Material(sNombre_Material, bCantidad, oTipoMaterial);
		return controlador.getAlmacenCtrl().getMaterialCtrl().updateMaterial(oMaterial);
	}
}
