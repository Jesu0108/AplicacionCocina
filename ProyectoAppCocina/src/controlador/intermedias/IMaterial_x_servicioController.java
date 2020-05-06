package controlador.intermedias;

import controlador.almacen.MaterialController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Material_x_servicio;

public interface IMaterial_x_servicioController {

	public int add(Material_x_servicio oMatXserv, MaterialController oMaterial, ServicioController oServicio);

	public int remove(Material_x_servicio oMatXserv);

}
