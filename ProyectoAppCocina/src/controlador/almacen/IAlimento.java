package controlador.almacen;

import modelo.almacen.Alimento;

public interface IAlimento {

	public int add(Alimento oAlimento);

	public int remove(Alimento oAlimento);

	public int existeCliente(Alimento oAlimento);

}
