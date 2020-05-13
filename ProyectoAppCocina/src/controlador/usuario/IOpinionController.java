package controlador.usuario;

import java.util.List;

import modelo.usuario.Opinion;

public interface IOpinionController {

	public int add(Opinion oOpinion);

	public int remove(Opinion oOpinion);

	public int existeOpinion(Opinion oOpinion);

	public List<Opinion> buscarOpiniones();

	public Opinion searchOpinionPorId(Opinion oOpinion);
	

}
