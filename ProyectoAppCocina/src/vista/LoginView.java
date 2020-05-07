package vista;

import controlador.ControladorGeneral;
import modelo.usuario.Catador;
import modelo.usuario.Cocinero;
import modelo.usuario.Empresa;
import validaciones.ValidaLibrary;

public class LoginView {

	public static Cocinero loginCocinero(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sEmail = null, sContrasenia = null;
		Cocinero oLoginCocinero = null;

		System.out.println("Por favor, introduzca sus credenciales para poder acceder.");
		while (errorControl) {
			try {
				sEmail = ValidaLibrary.leer("Email: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error de email: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				sContrasenia = ValidaLibrary.leer("Contrasenia: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error de contrasenia: " + ex.getMessage());
			}
		}

		Cocinero oCocinero = new Cocinero(sEmail, sContrasenia);

		//Comprobamos que existe un cocinero con esos datos
		
		if (controlador.getUsuarioCtrl().getCocineroCtrl().checkLogin(oCocinero) > 0) {
			oLoginCocinero = oCocinero;
		}
		return oLoginCocinero;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static Catador loginCatador(ControladorGeneral controlador) {
		boolean errorControl = true;
		String sEmail = null, sContrasenia = null;
		Catador oLoginCatador = null;

		System.out.println("Por favor, introduzca sus credenciales para poder acceder.");
		while (errorControl) {
			try {
				sEmail = ValidaLibrary.leer("Email: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error de email: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				sContrasenia = ValidaLibrary.leer("Contrasenia: ");
				errorControl = false;
			} catch (Exception ex) {
				System.out.println("Error de contrasenia: " + ex.getMessage());
			}
		}

		Catador oCatador = new Catador(sEmail, sContrasenia);

		//Comprobamos que existe un catador con esos datos
		
		if (controlador.getUsuarioCtrl().getCatadorCtrl().checkLogin(oCatador) > 0) {
			oLoginCatador = oCatador;
		}
		return oLoginCatador;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
		public static Empresa loginEmpresa(ControladorGeneral controlador) {
			boolean errorControl = true;
			String sEmail = null, sContrasenia = null;
			Empresa oLoginEmpresa = null;

			System.out.println("Por favor, introduzca sus credenciales para poder acceder.");
			while (errorControl) {
				try {
					sEmail = ValidaLibrary.leer("Email: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error de email: " + ex.getMessage());
				}
			}

			errorControl = true;
			while (errorControl) {
				try {
					sContrasenia = ValidaLibrary.leer("Contrasenia: ");
					errorControl = false;
				} catch (Exception ex) {
					System.out.println("Error de contrasenia: " + ex.getMessage());
				}
			}

			Empresa oEmpresa = new Empresa(sEmail, sContrasenia);

			//Comprobamos que existe una empresa con esos datos
			
			if (controlador.getUsuarioCtrl().getEmpresaCtrl().existeEmpresa(oEmpresa) > 0) {
				oLoginEmpresa = oEmpresa;
			}
			return oLoginEmpresa;
		}
}
