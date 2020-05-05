package controlador.almacen;

import modelo.almacen.Tipo_material;

public interface ITipo_materialController {

	public int add(Tipo_material oTMaterial);

	public int remove(Tipo_material oTMaterial);

	public int existeCliente(Tipo_material oTMaterial);

}
