package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Alimento;
import modelo.intermedias.Alimento_x_servicio;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Alimento_x_servicioController implements IAlimento_x_servicioController {

	@Override
	public int add(Alimento_x_servicio oAlimXserv) {

		String sql = "INSERT INTO alimento_x_servicio VALUES ( " + oAlimXserv.getiIdSevicio().getiId_servicio() + ", '"
				+ oAlimXserv.getNombre_alimento().getsNombre_alimento() + "', "
				+ oAlimXserv.getOpinion().getiId_opinion() + ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove() {

		String sql = "DELETE FROM Alimento_x_servicio;";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
    public List<Alimento_x_servicio> HistorialAlimXServ ( ) {
	List<Alimento_x_servicio> lAlimXserv = new ArrayList<Alimento_x_servicio>();

	String sql = "SELECT * FROM alimento_x_servicio;";
	Statement stm = null;

	try {
	    stm = ConexionDB.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    	String email = rs.getString(1);
	    	int id_servicio = rs.getInt(2);
	    	int id_opinion = rs.getInt(3);
	    	
	    	Alimento oAlim = new Alimento(email);
	    	Servicio oServ = new Servicio (id_servicio);
	    	Opinion oOpin = new Opinion (id_opinion);
	    	
	    	lAlimXserv.add(new Alimento_x_servicio(oAlim,oServ,oOpin));
	    }
	    stm.close();
	} catch (SQLException e) {
		lAlimXserv = null;
	}
	return lAlimXserv;
    }
	
}
