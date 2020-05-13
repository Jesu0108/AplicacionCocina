package controlador.almacen;

import java.util.List;

import modelo.almacen.Material;
import modelo.almacen.Tipo_material;

public interface IMaterialController {

	public int add(Material oMaterial);

	public int remove(Material oMaterial);

	public int existeCliente(Material oMaterial);

	public List<Material> searchMaterialesPorTipo(Tipo_material oTMaterial);

	public List<Material> searchMaterialesPorNombre(Material oMaterial);

	public Material searchMaterial(String sNombreMaterial, Tipo_material oTipMaterial);

	public int updateMaterial(Material oMaterial);

}
