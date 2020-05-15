package controlador.intermedias;

import java.util.List;

import controlador.usuario.CatadorController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Catador_x_servicio;

public interface ICatador_x_servicioController {

	public int add(Catador_x_servicio oCatXserv, CatadorController oCatador, ServicioController oServicio);

	public int remove(Catador_x_servicio oCatXserv);

	public List<Catador_x_servicio> HistorialCatXServ(Catador_x_servicio oCatXserv);

}
