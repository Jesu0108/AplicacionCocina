package controlador.intermedias;

import java.util.List;

import modelo.intermedias.Material_x_servicio;

public interface IMaterial_x_servicioController {

	public int add(Material_x_servicio oMatXserv);

	public int remove(Material_x_servicio oMatXserv);

	public List<Material_x_servicio> HistorialCatXServ(Material_x_servicio oMatXserv);

}
