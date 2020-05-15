package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Empresa_x_servicio;
import modelo.usuario.Empresa;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Empresa_x_servicioController implements IEmpresa_x_servicioController {

	@Override
	public int add(Empresa_x_servicio oEmpXserv) {

		String sql = "INSERT INTO empresa_x_servicio VALUES ( '" + oEmpXserv.getsCif().getsCif() + "', "
				+ oEmpXserv.getiIdSevicio() + ", "+oEmpXserv.getOpinion().getiId_opinion()+")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Empresa_x_servicio oEmpXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oEmpXserv.getiIdSevicio() + "\" AND cif LIKE ";
		sql += "\"" + oEmpXserv.getsCif() + "\"";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Empresa_x_servicio> HistorialEmpXServ(Empresa_x_servicio oEmpXserv) {
		List<Empresa_x_servicio> lEmpXserv = new ArrayList<Empresa_x_servicio>();

		String sql = "SELECT * FROM empresa_x_servicio WHERE cif LIKE '" + oEmpXserv.getsCif().getsCif() + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String cif = rs.getString(1);
				int id_servicio = rs.getInt(2);
				int id_opinion = rs.getInt(3);

				Empresa oEmp = new Empresa(cif);
				Servicio oServ = new Servicio(id_servicio);
				Opinion oOpin = new Opinion(id_opinion);

				lEmpXserv.add(new Empresa_x_servicio(oEmp, oServ, oOpin));
			}
			stm.close();
		} catch (SQLException e) {
			lEmpXserv = null;
		}
		return lEmpXserv;
	}
}
