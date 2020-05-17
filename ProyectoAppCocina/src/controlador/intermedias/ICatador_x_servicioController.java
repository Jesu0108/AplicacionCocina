package controlador.intermedias;

import java.util.List;

import modelo.intermedias.Catador_x_servicio;

public interface ICatador_x_servicioController {

	public int add(Catador_x_servicio oCatXserv);

	public int remove();

	public List<Catador_x_servicio> HistorialCatXServ();

	public int idDB();
}
