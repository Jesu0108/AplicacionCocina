package controlador.intermedias;

import java.util.List;

import modelo.intermedias.Empresa_x_servicio;

public interface IEmpresa_x_servicioController {

	public int add(Empresa_x_servicio oEmpXserv);

	public int remove(Empresa_x_servicio oEmpXserv);

	public List<Empresa_x_servicio> HistorialEmpXServ();

	public int idDB();


}
