package controlador.usuario;

import java.util.List;

import modelo.usuario.Empresa;

public interface IEmpresaController {

	public int add(Empresa oEmpresa);

	public int remove(Empresa oEmpresa);

	public int existeEmpresa(Empresa oEmpresa);

	public List<Empresa> buscarEmpresaPorCif(Empresa oEmpresa);

}
