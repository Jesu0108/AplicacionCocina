package controlador.usuario;


public class UsuarioContoller {
	private CatadorController catadorCtrl;
	private PersonaController personaCtrl;
	private CocineroController cocineroCtrl;
	private OpinionController OpinionCtrl;
	private ServicioController servicioCtrl;
	private EmpresaController empresaCtrl;
	private Tipo_servicioController tipoServicioCtrl;
	
	public UsuarioContoller() {
		catadorCtrl = new CatadorController();
		personaCtrl = new PersonaController();
		cocineroCtrl = new CocineroController();
		OpinionCtrl = new OpinionController();
		servicioCtrl = new ServicioController();
		empresaCtrl = new EmpresaController();
		tipoServicioCtrl = new Tipo_servicioController();
		
	    }

	public CatadorController getCatadorCtrl() {
		return catadorCtrl;
	}

	public PersonaController getPersonaCtrl() {
		return personaCtrl;
	}

	public CocineroController getCocineroCtrl() {
		return cocineroCtrl;
	}

	public OpinionController getOpinionCtrl() {
		return OpinionCtrl;
	}

	public ServicioController getServicioCtrl() {
		return servicioCtrl;
	}
	
	public EmpresaController getEmpresaCtrl() {
		return empresaCtrl;
	}

	public Tipo_servicioController getTipoServicioCtrl() {
		return tipoServicioCtrl;
	}


}
