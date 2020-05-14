package vista;

import controlador.ControladorGeneral;
import modelo.usuario.Catador;
import modelo.usuario.Cocinero;
import modelo.usuario.Empresa;
import validaciones.ValidaLibrary;


public class RegisterView {
	public static String registro(byte bCuenta,ControladorGeneral controlador) {
		String sResultado="";
		if (bCuenta == 1) {
			String sEmail = "", sContrasenia = "", sNombre = "", sApellidos = "", 
					sTelefono = "", sExperiencia = "", sCiudad = "", sEspecialidad = "";

			//Comprobamos que los datos que se introducen son correctos
			
			try {
				sEmail = ValidaLibrary.leer("Email: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sContrasenia = ValidaLibrary.leer("Ccontrasenia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sNombre = ValidaLibrary.leer("Nombre: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sApellidos = ValidaLibrary.leer("Apellidos: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sTelefono = ValidaLibrary.leer("Telefono: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sExperiencia = ValidaLibrary.leer("Experiencia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sCiudad = ValidaLibrary.leer("Ciudad: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sEspecialidad = ValidaLibrary.leer("Especialidad: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}

			Cocinero oNewCocinero = new Cocinero(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia,
					sCiudad, sEspecialidad);

			if(controlador.getUsuarioCtrl().getCocineroCtrl().add(oNewCocinero)>0) {
				sResultado="Felicidades, ya tiene una cuenta como COCINERO";
			}else {
				sResultado="Ha ocurrido un error";
			}
			
			
			
			
		}else if (bCuenta == 2) {
			String sEmail = "", sContrasenia = "", sNombre = "", sApellidos = "", 
					sTelefono = "", sExperiencia = "", sCiudad = "";
			byte bCriterio=0;

			//Comprobamos que los datos que se introducen son correctos
			
			try {
				sEmail = ValidaLibrary.leer("Email: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sContrasenia = ValidaLibrary.leer("Ccontrasenia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sNombre = ValidaLibrary.leer("Nombre: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sApellidos = ValidaLibrary.leer("Apellidos: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sTelefono = ValidaLibrary.leer("Telefono: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sExperiencia = ValidaLibrary.leer("Experiencia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sCiudad = ValidaLibrary.leer("Ciudad: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				bCriterio = (byte)ValidaLibrary.valida("Elija su criterio (1-10)", 1, 10, 3);
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}

			Catador oNewCatador = new Catador(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia,
					sCiudad, bCriterio);

			controlador.getUsuarioCtrl().getCatadorCtrl().add(oNewCatador);
			
			sResultado="Felicidades, ya tiene una cuenta como CATADOR";
			
		}else {
			String sEmail = "", sContrasenia = "", sNombre = "", sApellidos = "", 
					sTelefono = "", sExperiencia = "", sCiudad = "",sDomicilio="",sCif="";
			

			//Comprobamos que los datos que se introducen son correctos
			
			try {
				sEmail = ValidaLibrary.leer("Email: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sContrasenia = ValidaLibrary.leer("Ccontrasenia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sNombre = ValidaLibrary.leer("Nombre: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sApellidos = ValidaLibrary.leer("Apellidos: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sTelefono = ValidaLibrary.leer("Telefono: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sExperiencia = ValidaLibrary.leer("Experiencia: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sCiudad = ValidaLibrary.leer("Ciudad: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			
			try {
				sDomicilio = ValidaLibrary.leer("Domicilio: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
			try {
				sCif = ValidaLibrary.leer("CIF: ");
			} catch (NullPointerException ex) {
				System.out.println("Error: " + ex.getMessage());
			}

			Empresa oNewEmpresa = new Empresa(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia,
					sCiudad, sDomicilio,sCif);

			controlador.getUsuarioCtrl().getEmpresaCtrl().add(oNewEmpresa);
			
			sResultado= "Felicidades, ya tiene una cuenta como EMPRESA";
		}
		
		return sResultado;
	}
}
