package controlador.almacen;

import controlador.ControladorGeneral;
import modelo.almacen.Material;

public interface IMaterialController {

	public int add(Material oMaterial);

	public int remove(Material oMaterial);

	public int existeMaterial(Material oMaterial);

	public Material searchMaterialPorTipo(Material oMaterial);

	public int updateMaterial(Material oMaterial);

	public Material searchMaterialPorNombre(Material oMaterial, ControladorGeneral oCont);

}
