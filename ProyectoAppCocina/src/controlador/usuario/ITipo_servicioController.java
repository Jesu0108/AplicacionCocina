package controlador.usuario;

import modelo.usuario.Tipo_servicio;

public interface ITipo_servicioController {

	public int add(Tipo_servicio oTipo_servicio);

	public int remove(Tipo_servicio oTipo_servicio);

	public int existeTipo_servicio(Tipo_servicio oTipo_servicio);

}
