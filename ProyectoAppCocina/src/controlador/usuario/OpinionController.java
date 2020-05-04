package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Opinion;

public class OpinionController {
	// Operaciones CRUD

	public int add(Opinion oOpinion) {
		String sql = "INSERT INTO opinion VALUES (\"" + oOpinion.getiPuntuacion() + "\",\"" + oOpinion.getsCritica()
				+ "\",\"" + oOpinion.getiId_opinion()+ ")";
		return ConexionDB.executeUpdate(sql);
	}

	public int remove(Opinion oOpinion) {
		String sql = "DELETE FROM opinion WHERE id_opinion LIKE \"" + oOpinion.getiId_opinion() + "\"";
		return ConexionDB.executeUpdate(sql);
	}
}
