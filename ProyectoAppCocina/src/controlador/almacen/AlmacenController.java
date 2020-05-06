package controlador.almacen;

public class AlmacenController {
	private AlimentoController alimentoCtrl;
	private MaterialController materialCtrl;
	private Tipo_materialController tipoMaterialCtrl;

	public AlmacenController() {
		alimentoCtrl = new AlimentoController();
		materialCtrl = new MaterialController();
		tipoMaterialCtrl = new Tipo_materialController();
	}

	public AlimentoController getAlimentoCtrl() {
		return alimentoCtrl;
	}

	public MaterialController getMaterialCtrl() {
		return materialCtrl;
	}

	public Tipo_materialController getTipoMaterialCtrl() {
		return tipoMaterialCtrl;
	}

}
