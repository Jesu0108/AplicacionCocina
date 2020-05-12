package controlador.intermedias;

import controlador.ConexionDB;
import controlador.usuario.EmpresaController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Empresa_x_servicio;

public class Empresa_x_servicioController implements IEmpresa_x_servicioController{
	@Override
	public int add(Empresa_x_servicio oEmpXserv, EmpresaController oEmpresa, ServicioController oServicio) {

		oEmpresa.add(oEmpXserv.getsCif());
		oServicio.add(oEmpXserv.getiIdSevicio());

		String sql = "INSERT INTO empresa_x_servicio VALUES (";
		sql += "\"" + oEmpXserv.getsCif() + "\",";
		sql += "\"" + oEmpXserv.getiIdSevicio() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Empresa_x_servicio oEmpXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oEmpXserv.getiIdSevicio() + "\" AND cif LIKE ";
		sql += "\"" + oEmpXserv.getsCif() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
}
