package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Catador;

public class CatadorController {
	
    public int remove (Catador oCatador) {
	String sql = "DELETE FROM catador WHERE email LIKE \""+oCatador.getsEmail()+"\"";
	return ConexionDB.executeUpdate(sql);
    }

    // ##########
    public int existeCliente (Catador oCatador) {
	String sql = "SELECT COUNT(*) FROM catador WHERE email LIKE \"" + oCatador.getsEmail() + "\"";
	return ConexionDB.executeCount(sql);
    }
}
