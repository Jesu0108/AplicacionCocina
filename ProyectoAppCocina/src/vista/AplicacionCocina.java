package vista;

import controlador.ControladorGeneral;
import modelo.usuario.Catador;
import modelo.usuario.Cocinero;
import modelo.usuario.Empresa;
import controlador.ConexionDB;
import validaciones.ValidaLibrary;
import vista.almacen.*;
import vista.usuario.*;

public class AplicacionCocina {

	public static void main(String[] args) {

		byte bOpcionMenuPrincipal, bOpcion, bEleccion, bCuenta;
		ControladorGeneral controlador = new ControladorGeneral("appcocina");

		System.out.println("\n-----------BIENVENIDO/A-----------\n");
		System.out.println("Por favor elija entre las siguientes opciones: \n");

		bOpcion = (byte) ValidaLibrary.valida("1 - Iniciar sesion\n2 - Registrarse\nOpcion elejida: ", 1, 2, 3);

		if (bOpcion == 1) {
			// Logeo del usuario
			if (ConexionDB.checkConnectionDatabase()) {

				System.out.println("Introduzca el tipo de cuenta que tiene: ");

				bEleccion = (byte) ValidaLibrary.valida("1 - Cocinero\\n2 - Catador\\3 - Empresa\nOpcion elejida: ", 1,
						3, 3);

				if (bEleccion == 1) {
					Cocinero oCocinero = LoginView.loginCocinero(controlador);
					while (oCocinero == null) {
						System.out.println("Acceso no autorizado, intentelo de nuevo.\n");
						oCocinero = LoginView.loginCocinero(controlador);
					}
				} else if (bEleccion == 2) {
					Catador oCatador = LoginView.loginCatador(controlador);
					while (oCatador == null) {
						System.out.println("Acceso no autorizado, intentelo de nuevo.\n");
						oCatador = LoginView.loginCatador(controlador);
					}
				} else {
					Empresa oEmpresa = LoginView.loginEmpresa(controlador);
					while (oEmpresa == null) {
						System.out.println("Acceso no autorizado, intentelo de nuevo.\n");
						oEmpresa = LoginView.loginEmpresa(controlador);
					}
				}

				System.out.println("\n-----------Bienvenido/a a nuestra aplicacion-----------\n");

				do {

					bOpcionMenuPrincipal = menuPrincipal();
					switch (bOpcionMenuPrincipal) {
					case 1: // Gestion de Servicios
						try {
							ServicioView.menuServicio(controlador);
						} catch (Exception ex) {
							System.out.println("Error: " + ex.getMessage());
						}
						break;
					case 2: // Gestion de Alimentos
						try {
							AlimentoView.menuAlimento(controlador);;
						} catch (Exception ex) {
							System.out.println("Error: " + ex.getMessage());
						}
						break;
					case 3: // Gestion Materiales
						try {
							MaterialView.menuMaterial(controlador);
						} catch (Exception ex) {
							System.out.println("Error: " + ex.getMessage());
						}
						break;
					case 4:// Gestion Opiniones
						try {
							OpinionView.menuOpinion(controlador);;
						} catch (Exception ex) {
							System.out.println("Error: " + ex.getMessage());
						}
						break;
					case 5:
						System.out.println("Adios.");
						break;
					default:
						System.out.println("Opcion incorrecta.");
					}
				} while (bOpcionMenuPrincipal != 5);
			}
		} else {
			System.out.println("Elija el tipo de cuenta que quiere crear: ");
			
			bCuenta = (byte) ValidaLibrary.valida("1 - Cocinero\\n2 - Catador\\3 - Empresa\nOpcion elejida: ", 1, 3, 3);
			
			System.out.println(RegisterView.registro(bCuenta,controlador));
		}
	}

	// ------------------------------------------------------------------------------------------------------

	private static byte menuPrincipal() {
		Byte bOpcion = 1;
		boolean bExito = false;
		System.out.println("¿Que deseas gestionar?");
		System.out.println("1. Gestionar servicios.");
		System.out.println("2. Gestionar Alimentos.");
		System.out.println("3. Gestionar Materiales");
		System.out.println("4. Gestionar Opiniones");
		System.out.println("5. Salir");
		do {
			try {
				bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion valida: ", 1, 5, 3);
				bExito = true;
			} catch (NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		} while (!bExito);

		return bOpcion;
	}
}
