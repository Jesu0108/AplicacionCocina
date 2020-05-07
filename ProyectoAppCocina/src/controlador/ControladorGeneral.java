package controlador;

import controlador.almacen.AlmacenController;
import controlador.intermedias.IntermediasController;
import controlador.usuario.UsuarioContoller;
import controlador.ConexionDB;

public class ControladorGeneral {

	private UsuarioContoller usuarioCtrl;
	private AlmacenController almacenCtrl;
	private IntermediasController interCtrl;

	public ControladorGeneral(String sDatabase) {
		usuarioCtrl = new UsuarioContoller();
		almacenCtrl = new AlmacenController();
		interCtrl = new IntermediasController();
		new ConexionDB(sDatabase);
	}

	public UsuarioContoller getUsuarioCtrl() {
		return usuarioCtrl;
	}

	public AlmacenController getAlmacenCtrl() {
		return almacenCtrl;
	}

	public IntermediasController getInterCtrl() {
		return interCtrl;
	}

}
