package controlador.intermedias;

import controlador.usuario.CatadorController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Catador_x_servicio;

public interface ICatador_x_servicioController {

	public int add(Catador_x_servicio oCatXserv, CatadorController oCatador, ServicioController oServicio);

	public int remove(Catador_x_servicio oCatXserv);

}
