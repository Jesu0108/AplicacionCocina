package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Catador_x_servicio;
import modelo.usuario.Catador;
import modelo.usuario.Servicio;

public class Catador_x_servicioController implements ICatador_x_servicioController {

	@Override
	public int add(Catador_x_servicio oCatXserv) {
		
		int i = 0;

		// Seleccionamos el id_servicio que queremos para poder
		// usarlo en la query del insert

		String sql1 = "SELECT id_servicio FROM servicio WHERE nombre_tipo_servicio = '"
				+ oCatXserv.getId_servicio().getoNombre_tipo_servicio().getsNombre_tipo_servicio()+ "' ;";

		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql1);

			i = rs.getInt(1);

			stm.close();
		} catch (SQLException e) {
			i = 0;
		}
		
		
		String sql = "INSERT INTO catador_x_servicio VALUES ( '" + oCatXserv.getEmail().getsEmail() + "', "
				+ i + ");";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Catador_x_servicio oCatXserv) {

		String sql = "DELETE FROM catador_x_servicio WHERE id_servicio LIKE "
				+ oCatXserv.getId_servicio().getiId_servicio() + " AND email LIKE '" + oCatXserv.getEmail().getsEmail() + "';";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
    public List<Catador_x_servicio> HistorialCatXServ ( ) {
	List<Catador_x_servicio> lCatXserv = new ArrayList<Catador_x_servicio>();

	String sql = "SELECT * FROM catador_x_servicio;";
	Statement stm = null;

	try {
	    stm = ConexionDB.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    	String email = rs.getString(1);
	    	int id_servicio = rs.getInt(2);
	    	
	    	Catador oCat = new Catador(email);
	    	Servicio oServ = new Servicio (id_servicio);
	    	
	    	lCatXserv.add(new Catador_x_servicio(oCat,oServ));
	    }
	    stm.close();
	} catch (SQLException e) {
		lCatXserv = null;
	}
	return lCatXserv;
    }
}
