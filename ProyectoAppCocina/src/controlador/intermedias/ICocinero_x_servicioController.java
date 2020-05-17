package controlador.intermedias;

import java.util.List;

import modelo.intermedias.Cocinero_x_servicio;

public interface ICocinero_x_servicioController {

	public int add(Cocinero_x_servicio oCocXserv);

	public int remove(Cocinero_x_servicio oCocXserv);

	public List<Cocinero_x_servicio> HistorialCocXServ();

	public int idDB();

}
