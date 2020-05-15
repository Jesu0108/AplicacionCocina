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
					System.out.println("Error al aniadir el Servicio");
				}
				break;
			case 2: // Modificar
				if (modificar(controlador) != 0) {
					System.out.println("Servicio modificado");
				} else {
					System.out.println("Error al modificar el Servicio");
				}
				break;
			case 3: // Eliminar
				if (eliminar(controlador) != 0) {
					System.out.println("Servicio eliminado");
				} else {
					System.out.println("Error al eliminar el Servicio");
				}
				break;
			case 4: // Buscar
				if (buscar(controlador) != null) {
					System.out.println(buscar(controlador));
				} else {
					System.out.println("Error al buscar el Servicio");
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

		System.out.println("\nGestion de Servicios");
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
		int iCalidad = 0;
		Date dFecha = null;
		byte bTiempo_servicio=0;

		// Pedimos los datos para el tipo de servicio

		while (errorControl) {
			try {
				sNombre_tipo_servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a aniadir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				iCalidad = (int) ValidaLibrary.valida("Introduzca la calidad minima para el servicio (1 - 600): ", 1,
						600, 1);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Tipo_servicio oTipServicio = new Tipo_servicio(sNombre_tipo_servicio, iCalidad);

		//Pedimos los datos para el Servicio
		
		errorControl = true;
		while (errorControl) {
			try {
				bTiempo_servicio = (byte) ValidaLibrary.valida("Introduzca el tiempo minnimo de servicio (en horas): ", 1,100, 3);
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
		// Aniadimos el tipo de servicio a la DB

		if (controlador.getUsuarioCtrl().getTipoServicioCtrl().add(oTipServicio) != 0) {
			System.out.println("Tipo de servicio aniadido correctamente\n");
		} else {
			System.out.println("Ha ocurrido un problema al aniadir el tipo de servicio\n");
		}

		// Aniadimos el servicio a la DB
		Servicio oServicio = new Servicio(dFecha, bTiempo_servicio, oTipServicio);

		return controlador.getUsuarioCtrl().getServicioCtrl().add(oServicio);
	}

	// -------------------------------------------------------------------------------------------------------

	public static int eliminar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_Servicio = "";

		while (errorControl) {
			try {
				sNombre_Servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a borrar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		return controlador.getUsuarioCtrl().getServicioCtrl().remove(new Servicio(new Tipo_servicio(sNombre_Servicio)));
	}

	// -------------------------------------------------------------------------------------------------------

	public static Servicio buscar(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sNombre_Servicio = "";

		while (errorControl) {
			try {
				sNombre_Servicio = ValidaLibrary.leer("Introduzca el tipo de servicio que va a buscar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
		return controlador.getUsuarioCtrl().getServicioCtrl().searchServicio(new Servicio(new Tipo_servicio(sNombre_Servicio)));
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		Servicio oServ = null;
		String sNombre_Servicio = "", sDateString = "";
		Date dFecha = null;
		byte bTiempo_servicio=0;
		
		while (errorControl) {
			try {
				sNombre_Servicio = ValidaLibrary.leer("Introduzca el nombre de Servicio que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		if (controlador.getUsuarioCtrl().getServicioCtrl().searchServicio(new Servicio(new Tipo_servicio (sNombre_Servicio)))!= null) {
			
			oServ = controlador.getUsuarioCtrl().getServicioCtrl().searchServicio(new Servicio(new Tipo_servicio (sNombre_Servicio)));
			
			//Pedimos los nuevos datos
			
			errorControl = true;
			while (errorControl) {
				try {
					bTiempo_servicio = (byte) ValidaLibrary.valida("Introduzca el nuevo tiempo de servicio (en horas): ", 1,100, 3);
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}	
			
			errorControl = true;
			while (errorControl) {
				try {
					sDateString = ValidaLibrary.leer("Introduzca la nueva fecha para el servicio (22/5/2020): ");
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
		}else {
			System.out.println("No se encuentra un servicio con ese nombre\n");
		}

		oServ.setbTiempo_servicio(bTiempo_servicio);
		oServ.setdFecha(dFecha);
		
		return controlador.getUsuarioCtrl().getServicioCtrl().updateServicio(oServ);
	}
}
