package controlador.intermedias;

import controlador.ConexionDB;
import controlador.almacen.AlimentoController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Alimento_x_servicio;


public class Alimento_x_servicioController implements IAlimento_x_servicioController{
	
	@Override
	public int add(Alimento_x_servicio oAlimXserv, AlimentoController oAlimento, ServicioController oServicio) {

		oAlimento.add(oAlimXserv.getNombre_alimento());
		oServicio.add(oAlimXserv.getiIdSevicio());
		
		String sql = "INSERT INTO alimento_x_servicio VALUES (";
		sql += "\"" + oAlimXserv.getiIdSevicio() + "\",";
		sql += "\"" + oAlimXserv.getNombre_alimento() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Alimento_x_servicio oAlimXserv) {

		String sql = "DELETE FROM Alimento_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oAlimXserv.getiIdSevicio() + "\" AND nombre_alimento LIKE ";
		sql += "\"" + oAlimXserv.getNombre_alimento() + "\"";
		
		return ConexionDB.executeUpdate(sql);
	}

}
