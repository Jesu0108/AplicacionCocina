package controlador.intermedias;

public class IntermediasController {
	private Alimento_x_servicioController alimXservCtrl;
	private Catador_x_servicioController catXservCtrl;
	private Cocinero_x_servicioController cocXservCtrl;
	private Material_x_servicioController matXservCtrl;
	private Empresa_x_servicioController empXservCrtl;
	
	public IntermediasController() {
		alimXservCtrl = new Alimento_x_servicioController();
		catXservCtrl = new Catador_x_servicioController();
		cocXservCtrl = new Cocinero_x_servicioController();
		matXservCtrl = new Material_x_servicioController();
		empXservCrtl = new Empresa_x_servicioController();
	}
	
	public Alimento_x_servicioController getAlimXservCtrl() {
		return alimXservCtrl;
	}

	public Catador_x_servicioController getCatXservCtrl() {
		return catXservCtrl;
	}

	public Cocinero_x_servicioController getCocXservCtrl() {
		return cocXservCtrl;
	}


	public Material_x_servicioController getMatXservCtrl() {
		return matXservCtrl;
	}

	public Empresa_x_servicioController getEmpXservCrtl() {
		return empXservCrtl;
	}
}
