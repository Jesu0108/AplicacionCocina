package controlador.usuario;

import java.util.List;

import modelo.usuario.Cocinero;

public interface iCocineroController {

	public int add(Cocinero oCocinero);

	public int remove(Cocinero oCocinero);

	public int existeCocinero(Cocinero oCocinero);

	public List<Cocinero> searchCocineroPorCiudad(Cocinero oCocinero);

	public int checkLogin(Cocinero oCocinero);

	public Cocinero searchCocinero(Cocinero oCocinero);

}
