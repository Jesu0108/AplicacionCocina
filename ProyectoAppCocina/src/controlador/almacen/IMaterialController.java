package controlador.almacen;

import modelo.almacen.Material;

public interface IMaterialController {

	public int add(Material oMaterial);

	public int remove(Material oMaterial);

	public int existeCliente(Material oMaterial);

	public Material searchMaterialPorTipo(Material oMaterial);

	public int updateMaterial(Material oMaterial);

	public Material searchMaterialPorNombre(Material oMaterial);

}
