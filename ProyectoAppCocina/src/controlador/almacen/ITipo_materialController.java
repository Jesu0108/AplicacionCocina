package controlador.almacen;

import modelo.almacen.Tipo_material;

public interface ITipo_materialController {

	public int add(Tipo_material oTMaterial);

	public int remove(Tipo_material oTMaterial);

	public int existeTipoMaterial(Tipo_material oTMaterial);

	public Tipo_material searchTipo_material(Tipo_material oTMaterial);

	public int updateTipo_material(Tipo_material oTMaterial);

}
