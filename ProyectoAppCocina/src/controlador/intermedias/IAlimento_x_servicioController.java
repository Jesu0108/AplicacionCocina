package controlador.intermedias;

import java.util.List;

import modelo.intermedias.Alimento_x_servicio;

public interface IAlimento_x_servicioController {

	public int add(Alimento_x_servicio oAlimXserv);

	public int remove();

	public List<Alimento_x_servicio> HistorialAlimXServ( );


}
