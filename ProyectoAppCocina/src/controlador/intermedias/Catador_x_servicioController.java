package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Catador_x_servicio;
import modelo.usuario.Catador;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Catador_x_servicioController implements ICatador_x_servicioController {

	@Override
	public int add(Catador_x_servicio oCatXserv) {
		
		String sql = "INSERT INTO catador_x_servicio VALUES ( '" + oCatXserv.getEmail().getsEmail() + "', "
				+ oCatXserv.getId_servicio().getiId_servicio() + ", " + oCatXserv.getOpinion().getiId_opinion() + ");";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Catador_x_servicio oCatXserv) {

		String sql = "DELETE FROM catador_x_servicio WHERE id_servicio LIKE "
				+ oCatXserv.getId_servicio().getiId_servicio() + " AND email LIKE '" + oCatXserv.getEmail().getsEmail() + "';";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
    public List<Catador_x_servicio> HistorialCatXServ (Catador_x_servicio oCatXserv) {
	List<Catador_x_servicio> lCatXserv = new ArrayList<Catador_x_servicio>();

	String sql = "SELECT * FROM catador_x_servicio WHERE email LIKE '" + oCatXserv.getEmail().getsEmail() + "';";
	Statement stm = null;

	try {
	    stm = ConexionDB.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    	String email = rs.getString(1);
	    	int id_servicio = rs.getInt(2);
	    	int id_opinion = rs.getInt(3);
	    	
	    	Catador oCat = new Catador(email);
	    	Servicio oServ = new Servicio (id_servicio);
	    	Opinion oOpin = new Opinion (id_opinion);
	    	
	    	lCatXserv.add(new Catador_x_servicio(oCat,oServ,oOpin));
	    }
	    stm.close();
	} catch (SQLException e) {
		lCatXserv = null;
	}
	return lCatXserv;
    }
}
