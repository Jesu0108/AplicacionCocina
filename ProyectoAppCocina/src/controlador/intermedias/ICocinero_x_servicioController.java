package controlador.intermedias;

import controlador.usuario.CocineroController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Cocinero_x_servicio;

public interface ICocinero_x_servicioController {

	public int add(Cocinero_x_servicio oCocXserv, CocineroController oCocinero, ServicioController oServicio);

	public int remove(Cocinero_x_servicio oCocXserv);

}
