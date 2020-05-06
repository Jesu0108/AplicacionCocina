package controlador.usuario;

import modelo.usuario.Catador;

public interface ICatadorController {

	public int add(Catador oCatador, PersonaController oPersona);

	public int remove(Catador oCatador);

	public int existeCatador(Catador oCatador);

}
