package vista.usuario;

import java.util.Date;
import java.text.SimpleDateFormat;

import controlador.ControladorGeneral;
import modelo.usuario.Servicio;
import modelo.usuario.Tipo_servicio;
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
				if (modificar(controlador) != 0) {
					System.out.println("Servicio modificado");
				} else {
					System.out.println("Error al modificar el servicio");
				}
				break;
			case 3: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Servicio eliminado");
				} else {
					System.out.println("Error al eliminar el servicio");
				}
				break;
			case 4: // Buscar
				if (buscar(controlador) != null) {
					System.out.println(buscar(controlador));
				} else {
					System.out.println("Error al buscar el servicio");
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
		String sNombre_tipo_servicio = "", sDateString = "";
		Date dFecha = null;
		byte bTiempo_servicio = 0;
		int iCalidad = 0;

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				iCalidad = (int) ValidaLibrary.valida("Introduzca la calidad minima del servicio que va a pedir (0 - 1000): ",0,1000,1);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}		
		
		Tipo_servicio oTipServ = new Tipo_servicio(sNombre_tipo_servicio,iCalidad);
		
		errorControl = true;
		while (errorControl) {
			try {
				bTiempo_servicio = (byte) ValidaLibrary.valida("Introduzca el tiempo estimado de servicio (en horas): ",
						1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				sDateString = ValidaLibrary.leer("Introduzca una fecha para el servicio (22/5/2020): ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				dFecha = new SimpleDateFormat("dd/MM/yyyy").parse(sDateString);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Servicio oServicio = new Servicio(dFecha, bTiempo_servicio,oTipServ);

		return controlador.getUsuarioCtrl().getServicioCtrl().add(oServicio);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_servicio = "";

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Tipo_servicio oTipServ = new Tipo_servicio(sNombre_tipo_servicio);
		Servicio oServ = new Servicio (oTipServ);
		return controlador.getUsuarioCtrl().getServicioCtrl().remove(oServ);
	}

	// -------------------------------------------------------------------------------------------------------

	public static Servicio buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_servicio = "";

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary
						.leer("Introduzca el nombre del tipo de servicio que va a buscar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		Tipo_servicio oTipServ = new Tipo_servicio(sNombre_tipo_servicio);
		Servicio oServ = new Servicio (oTipServ);
		return controlador.getUsuarioCtrl().getServicioCtrl().searchServicio(oServ);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_tipo_servicio = "", sDateString = "", sNew_tipo_servicio = "";
		Date dFecha = null;
		byte bTiempo_servicio = 0;
		int iCalidad =0;

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Tipo_servicio oTipServ = new Tipo_servicio(sNombre_tipo_servicio);
		if (controlador.getUsuarioCtrl().getTipoServicioCtrl().searchTipoServicio(oTipServ) != null) {
			
			errorControl = true;
			while (errorControl) {
				try {
					sNew_tipo_servicio = ValidaLibrary.leer("Introduzca el nuevo tipo de servicio que va a pedir: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			errorControl = true;
			while (errorControl) {
				try {
					iCalidad = (int) ValidaLibrary.valida("Introduzca la calidad minima del servicio que va a pedir (0 - 1000): ",0,1000,1);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}	
			
			errorControl = true;
			while (errorControl) {
				try {
					bTiempo_servicio = (byte) ValidaLibrary
							.valida("Introduzca el nuevo tiempo estimado de servicio (en horas): ", 1, 100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			errorControl = true;
			while (errorControl) {
				try {
					sDateString = ValidaLibrary.leer("Introduzca una nuevo fecha para el servicio (22/5/2020): ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

			errorControl = true;
			while (errorControl) {
				try {
					dFecha = new SimpleDateFormat("dd/MM/yyyy").parse(sDateString);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}
		}
		Tipo_servicio oNewTipServ = new Tipo_servicio(sNew_tipo_servicio,iCalidad);
		Servicio oServicio = new Servicio(dFecha, bTiempo_servicio,oNewTipServ);
		return controlador.getUsuarioCtrl().getServicioCtrl().updateServicio(oServicio);
	}
}
