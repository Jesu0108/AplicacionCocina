package modelo;

public class Opinion implements IOpinion{
	private int iId_opinion;
	private String sCritica;
	private byte iPuntuacion;
		
	public Opinion(int iId_opinion, String sCritica, byte iPuntuacion) {
		setiId_opinion(iId_opinion);
		setsCritica(sCritica);
		setiPuntuacion(iPuntuacion);
	}
	
	@Override
	public int getiId_opinion() {
		return iId_opinion;
	}
	
	@Override
	public boolean setiId_opinion(int iId_opinion) {
		boolean bExito=false;
		if(iId_opinion>-1) {
			this.iId_opinion = iId_opinion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String getsCritica() {
		return sCritica;
	}
	
	@Override
	public boolean setsCritica(String sCritica) {
		boolean bExito=false;
		if(sCritica != null) {
			this.sCritica = sCritica;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public byte getiPuntuacion() {
		return iPuntuacion;
	}
	
	@Override
	public boolean setiPuntuacion(byte iPuntuacion) {
		boolean bExito=false;
		if(iPuntuacion > -1) {
			this.iPuntuacion = iPuntuacion;
			bExito=true;
		}
		bExito = true;
		return bExito;
	}
	
	
	
}
