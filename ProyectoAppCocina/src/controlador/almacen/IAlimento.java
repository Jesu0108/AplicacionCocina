package controlador.almacen;

import java.util.List;

import modelo.almacen.Alimento;

public interface IAlimento {

	public int add(Alimento oAlimento);

	public int remove(Alimento oAlimento);

	public int existeCliente(Alimento oAlimento);

	public List<Alimento> searchAlimentosPorNombre(Alimento oAlimento);

	public Alimento searchAlimento(String sNombreAlimento);

	public int updateAlimento(Alimento oAlimento);

}
