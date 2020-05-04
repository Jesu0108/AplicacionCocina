package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import controlador.ConexionDB;
import modelo.usuario.Opinion;

public class OpinionController {
	// Operaciones CRUD

	public int add(Opinion oOpinion) {
		String sql = "INSERT INTO opinion VALUES (\"" + oOpinion.getiPuntuacion() + "\",\"" + oOpinion.getsCritica()
				+ "\",\"" + oOpinion.getiId_opinion() + ")";
		return ConexionDB.executeUpdate(sql);
	}

	public int remove(Opinion oOpinion) {
		String sql = "DELETE FROM opinion WHERE id_opinion LIKE \"" + oOpinion.getiId_opinion() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	//Operacion de b�squeda por el ID
	
	public List<Opinion> buscarOpinionPorId(Opinion oOpinion) {

		List<Opinion> lOpiniones = new ArrayList<Opinion>();
		String sql = "SELECT * FROM opinion WHERE id=" + oOpinion.getiId_opinion();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int iId_opinion = rs.getInt(1);
				String sCritica = rs.getString(2);
				byte bPuntuacion = (byte) rs.getInt(3);
				lOpiniones.add(new Opinion(iId_opinion,sCritica,bPuntuacion));
			}
			stm.close();
		} catch (SQLException e) {
			lOpiniones = null;
		}
		return lOpiniones;
	}

}
