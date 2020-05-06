package controlador.intermedias;

import controlador.almacen.AlimentoController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Alimento_x_servicio;

public interface IAlimento_x_servicioController {

	public int add(Alimento_x_servicio oAlimXserv, AlimentoController oAlimento, ServicioController oServicio);

	public int remove(Alimento_x_servicio oAlimXserv);

}
