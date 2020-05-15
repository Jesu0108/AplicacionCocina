package vista.almacen;

import controlador.ControladorGeneral;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;
import validaciones.ValidaLibrary;

public class MaterialView {
	public static void menuMaterial(ControladorGeneral controlador) {
		int bOpcion = 0;
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

	public static int opcionMenuMaterial() {
		byte bOpcion = 0;
		boolean errorControl = true;

		System.out.println("\nGestion de Materials");
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
		int iCantidad = 0, iCalidad = 0;

		// Pido la PK de Tipo_material

				while (errorControl) {
					try {
						sNombre_tipo_Material = ValidaLibrary.leer("Introduzca el nombre del tipo de material que va a pedir: ");
						errorControl = false;
					} catch (Exception ex) {
						System.out.println("Error: " + ex.getMessage());
					}
				}
				
				errorControl = true;
				while (errorControl) {
					try {
						iCalidad = (int) ValidaLibrary.valida("Introduzca la calidad minima del tipo de material que va a pedir(1 - 1000): ",1,1000,1);
						errorControl = false;
					} catch (Exception ex) {
						System.out.println("Error: " + ex.getMessage());
					}
				}
		
		// Pido los datos del material

		errorControl = true;
		while (errorControl) {
			try {
				sNombre_Material = ValidaLibrary.leer("Introduzca de que material lo va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				iCantidad = (int) ValidaLibrary.valida("Introduzca la cantidad de material que va a necesitar (1 - 100): ", 1, 100, 1);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		//Aniadimos a la DB el tipo de material si no existe
		
		Tipo_material oTipoMaterial = new Tipo_material(sNombre_tipo_Material,iCalidad);
		
		if(controlador.getAlmacenCtrl().getTipoMaterialCtrl().searchTipo_material(oTipoMaterial)== null) {
			
			//Comprobamos que se ha aniadido
			
			if(controlador.getAlmacenCtrl().getTipoMaterialCtrl().add(oTipoMaterial) != 0) {
				System.out.println("Se ha aniadido el tipo de material");
			}else {
				System.out.println("Error al aniadir el tipo de material");
			}
			
		}else {
			System.out.println("El tipo de material ya existe, no se creará uno nuevo");
		}
		
		//Aniadimos el amterial
		
		Material oMaterial = new Material(sNombre_Material, iCantidad);

		return controlador.getAlmacenCtrl().getMaterialCtrl().add(oMaterial);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_Material = "";

		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary.leer("Introduzca el tipo de Material que va a eliminar: ");
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
				sNombre_Material = ValidaLibrary.leer("Introduzca el nombre del Material que va a buscar: ");
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
		String sNombre_Material = "";
		int iCantidad = 0;
		
		while (errorControl) {
			try {
				sNombre_Material = ValidaLibrary.leer("Introduzca el nombre de material para modificar su cantidad: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Material oMat = new Material(sNombre_Material);
		
		if (controlador.getAlmacenCtrl().getMaterialCtrl().searchMaterialPorNombre(oMat) != null) {

			errorControl = true;
			while (errorControl) {
				try {
					iCantidad = (int) ValidaLibrary
							.valida("Introduzca la nueva cantidad de material que va a necesitar (1 - 100): ", 1, 100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

		}

		oMat.setiCantidad(iCantidad);
		
		return controlador.getAlmacenCtrl().getMaterialCtrl().updateMaterial(oMat);
	}
}
