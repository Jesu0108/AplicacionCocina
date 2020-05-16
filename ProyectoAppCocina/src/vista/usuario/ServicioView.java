package vista.usuario;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import controlador.ControladorGeneral;
import modelo.almacen.Alimento;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;
import modelo.intermedias.Alimento_x_servicio;
import modelo.intermedias.Catador_x_servicio;
import modelo.intermedias.Cocinero_x_servicio;
import modelo.intermedias.Empresa_x_servicio;
import modelo.intermedias.Material_x_servicio;
import modelo.usuario.*;
import validaciones.ValidaLibrary;
import vista.LoginView;

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
		String sNombre_tipo_servicio = "", sNombre_alimento = "", sNombre_Material = "", sNombre_tipo_Material = "";
		int iCalidad = 0, iAnio = 0, iCantidad = 0, iError = 0;
		Date dFecha = null;
		byte bTiempo_servicio = 0, bDia = 0, bMes = 0, bCantidad = 0, bCuenta = 0;

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

		// Aniadimos el tipo de servicio a la DB

		if (controlador.getUsuarioCtrl().getTipoServicioCtrl().add(oTipServicio) != 0) {
			System.out.println("Tipo de servicio aniadido correctamente\n");
		} else {
			System.out.println("Ha ocurrido un problema al aniadir el tipo de servicio\n");
		}

		// Pedimos los datos para el Servicio

		errorControl = true;
		while (errorControl) {
			try {
				bTiempo_servicio = (byte) ValidaLibrary.valida("Introduzca el tiempo minnimo de servicio (en horas): ",
						1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				bDia = (byte) ValidaLibrary.valida("Introduzca el dia del servicio (22/5/2020): ", 1, 31, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				bMes = (byte) ValidaLibrary.valida("Introduzca un mes para el servicio (22/5/2020): ", 1, 31, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				iAnio = (int) ValidaLibrary.valida("Introduzca un anio para el servicio (22/5/2020): ", 1, 3000, 1);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				dFecha = new GregorianCalendar(iAnio, bMes - 1, bDia).getTime();
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		Servicio oServicio = new Servicio(dFecha, bTiempo_servicio, oTipServicio);

		iError = controlador.getUsuarioCtrl().getServicioCtrl().add(oServicio);

		// Recogemos los datos de los alimentos para el servicio
		errorControl = true;
		while (errorControl) {
			try {
				sNombre_alimento = ValidaLibrary.leer("Introduzca el nombre del plato que va a aniadir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				bCantidad = (byte) ValidaLibrary.valida("Introduzca la cantidad (1 - 100): ", 1, 100, 3);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		// Aniadimos el alimento a la DB

		Alimento oAlimento = new Alimento(sNombre_alimento, bCantidad);

		if (controlador.getAlmacenCtrl().getAlimentoCtrl().add(oAlimento) != 0) {
			System.out.println("Plato aniadido con exito");
		} else {
			System.out.println("Error al aniadir el Plato");
		}

		// Hacemos el historial con los datos

		Alimento_x_servicio AlimXserv = new Alimento_x_servicio(oAlimento, oServicio);

		if (controlador.getInterCtrl().getAlimXservCtrl().add(AlimXserv) != 0) {
			System.out.println("\nAlimento guardado en el historial\n");
		} else {
			System.out.println("\nError al guardar en el historial de alimentos\n");
		}

		// Recogemos los datos de los materiales para el servicio
		// Pido la PK de Tipo_material

		errorControl = true;
		while (errorControl) {
			try {
				sNombre_tipo_Material = ValidaLibrary
						.leer("Introduzca el nombre del tipo de material que va a pedir: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				iCalidad = (int) ValidaLibrary.valida(
						"\nIntroduzca la calidad minima del tipo de material que va a pedir(1 - 1000): ", 1, 1000, 1);
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
				iCantidad = (int) ValidaLibrary
						.valida("Introduzca la cantidad de material que va a necesitar (1 - 100): ", 1, 100, 1);
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		// Aniadimos a la DB el tipo de material

		Tipo_material oTipoMaterial = new Tipo_material(sNombre_tipo_Material, iCalidad);

		if (controlador.getAlmacenCtrl().getTipoMaterialCtrl().add(oTipoMaterial) != 0) {
			System.out.println("Se ha aniadido el tipo de material\n");
		} else {
			System.out.println("Error al aniadir el tipo de material\n");
		}

		// Aniadimos el material

		Material oMaterial = new Material(sNombre_Material, oTipoMaterial, iCantidad);

		if (controlador.getAlmacenCtrl().getMaterialCtrl().add(oMaterial) != 0) {
			System.out.println("Material aniadido con exito\n");
		} else {
			System.out.println("Error al aniadir el Material\n");
		}

		// Lo aniadimos al historial de material

		Material_x_servicio oMatXser = new Material_x_servicio(oMaterial, oServicio);

		if (controlador.getInterCtrl().getMatXservCtrl().add(oMatXser) != 0) {
			System.out.println("Aniadido al historial de material");
		} else {
			System.out.println("Error al aniadir al historial de material");
		}

		// Vemos que tipo de cuenta tiene y la aniadimos a su respectivo historial

		System.out.println("\nVerifique su cuenta para poder terminar su pedido");

		bCuenta = (byte) ValidaLibrary.valida("1 - Cocinero\n2 - Catador\n3 - Empresa\nOpcion Elegida: ", 1, 3, 3);

		if (bCuenta == 2) {
			Catador oCat = LoginView.loginCatador(controlador);
			Catador_x_servicio oCatXserv = new Catador_x_servicio(oCat, oServicio);

			if (controlador.getInterCtrl().getCatXservCtrl().add(oCatXserv) != 0) {
				System.out.println("Aniadido al historial de usuario");
			} else {
				System.out.println("Error al aniadir al historial de usuario");
			}

		} else if (bCuenta == 1) {

			Cocinero oCoc = LoginView.loginCocinero(controlador);
			Cocinero_x_servicio oCocXserv = new Cocinero_x_servicio(oCoc, oServicio);

			if (controlador.getInterCtrl().getCocXservCtrl().add(oCocXserv) != 0) {
				System.out.println("Aniadido al historial de usuario");
			}

		} else {

			Empresa oEmp = LoginView.loginEmpresa(controlador);
			Empresa_x_servicio oEmpXserv = new Empresa_x_servicio(oEmp, oServicio);

			if (controlador.getInterCtrl().getEmpXservCrtl().add(oEmpXserv) != 0) {
				System.out.println("Aniadido al historial de usuario");

			}
		}

		// Aniadimos el servicio a la DB

		return iError;
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
		return controlador.getUsuarioCtrl().getServicioCtrl()
				.searchServicio(new Servicio(new Tipo_servicio(sNombre_Servicio)));
	}

	// -------------------------------------------------------------------------------------------------------

	public static int modificar(ControladorGeneral controlador) {
		boolean errorControl = true;
		Servicio oServ = null;
		String sNombre_Servicio = "", sDateString = "";
		Date dFecha = null;
		byte bTiempo_servicio = 0;

		while (errorControl) {
			try {
				sNombre_Servicio = ValidaLibrary.leer("Introduzca el nombre de Servicio que va a modificar: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

		if (controlador.getUsuarioCtrl().getServicioCtrl()
				.searchServicio(new Servicio(new Tipo_servicio(sNombre_Servicio))) != null) {

			oServ = controlador.getUsuarioCtrl().getServicioCtrl()
					.searchServicio(new Servicio(new Tipo_servicio(sNombre_Servicio)));

			// Pedimos los nuevos datos

			errorControl = true;
			while (errorControl) {
				try {
					bTiempo_servicio = (byte) ValidaLibrary
							.valida("Introduzca el nuevo tiempo de servicio (en horas): ", 1, 100, 3);
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
		} else {
			System.out.println("No se encuentra un servicio con ese nombre\n");
		}

		oServ.setbTiempo_servicio(bTiempo_servicio);
		oServ.setdFecha(dFecha);

		return controlador.getUsuarioCtrl().getServicioCtrl().updateServicio(oServ);
	}
}
