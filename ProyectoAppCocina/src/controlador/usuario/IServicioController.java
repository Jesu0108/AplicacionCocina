package controlador.usuario;

import modelo.usuario.Servicio;

public interface IServicioController {

	public int add(Servicio oServicio);

	public int remove(Servicio oServicio);

	public int existeServicio(Servicio oServicio);

	public Servicio searchCatador(Servicio oServicio);

}
