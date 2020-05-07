package vista;

import validaciones.ValidaLibrary;

public class AplicacionCocina {

	public static void main(String[] args) {
		/*ArticuloView vistaArticulo = new ArticuloView();
		SocioView vistaSocio = new SocioView();
		AlquilerView vistaAlquiler = new AlquilerView();
		ReservaView vistaReservas = new ReservaView();
		InstalacionView vistaInstalacion = new InstalacionView();

		byte bOpcionMenuPrincipal;

		Terminal t = new Terminal();
		System.out.println("\n-----------CLUB DEPORTIVO-----------\n");

		do {
			bOpcionMenuPrincipal = menuPrincipal();
			switch (bOpcionMenuPrincipal) {
			case 1: // Gestion de Articulos
				try {
					vistaArticulo.subMenuArticulos(t);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			case 2: // Gestion de Socios
				try {
					vistaSocio.subMenuSocios(t);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			case 3: // Gestion Instalacioines
				try {
					vistaInstalacion.subMenuInstalaciones(t);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			case 4:// Gestion Reservas
				try {
					vistaReservas.subMenuReservas(t);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			case 5:// Gestion Alquiler
				try {
					vistaAlquiler.subMenuAlquileres(t);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			case 6: 
				System.out.println("Adios.");
				break;
			default:
				System.out.println("Opcion incorrecta.");
			}
		} while (bOpcionMenuPrincipal != 6);
	}

	// ------------------------------------------------------------------------------------------------------

	private static byte menuPrincipal() {
		Byte bOpcion = 1;
		boolean bExito = false;
		System.out.println("¿Que deseas gestionar?");
		System.out.println("1. Gestionar articulos.");
		System.out.println("2. Gestionar Socios.");
		System.out.println("3. Gestionar Instalaciones");
		System.out.println("4. Gestionar Reservas");
		System.out.println("5. Gestionar Alquileres");
		System.out.println("6. Salir");
		do {
			try {
				bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion valida: ", 1, 6, 3);
				bExito = true;
			} catch (NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		} while (!bExito);

		return bOpcion;
	}

	// ------------------------------------------------------------------------------------------------------

	public static byte subMenu(String sClase) {
		Byte bOpcion = 1;

		System.out.println("¿Que deseas hacer?");
		System.out.println("---------------------------");
		System.out.println("1. Aniadir " + sClase);
		System.out.println("2. Modificar " + sClase);
		System.out.println("3. Eliminar " + sClase);
		System.out.println("4. Buscar " + sClase);
		System.out.println("5. Mostrar " + sClase);
		System.out.println("6. Volver a menu principal");
		try {
			bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion valida: ", 1, 6, 3);
		} catch (NumberFormatException ex) {
			System.out.println("Error: " + ex.getMessage());
		}

		return bOpcion;
	}*/
}
}
