package controlador.intermedias;

import controlador.usuario.EmpresaController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Empresa_x_servicio;

public interface IEmpresa_x_servicioController {

	public int add(Empresa_x_servicio oEmpXserv, EmpresaController oEmpresa, ServicioController oServicio);

	public int remove(Empresa_x_servicio oEmpXserv);

}
