package controlador.usuario;

import java.util.List;

import modelo.usuario.Catador;

public interface ICatadorController {

	public int add(Catador oCatador);

	public int remove(Catador oCatador);

	public int existeCatador(Catador oCatador);

	public List<Catador> searchCatadorPorCiudad(Catador oCatador);

	public int checkLogin(Catador oCatador);

	public Catador searchCatador(Catador oCatador);

}
