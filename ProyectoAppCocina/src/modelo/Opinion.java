package modelo;

public class Opinion {
	private int iId_opinion;
	private String sCritica;
	private byte iPuntuacion;
		
	public Opinion(int iId_opinion, String sCritica, byte iPuntuacion) {
		setiId_opinion(iId_opinion);
		setsCritica(sCritica);
		setiPuntuacion(iPuntuacion);
	}
	
	public int getiId_opinion() {
		return iId_opinion;
	}
	
	public boolean setiId_opinion(int iId_opinion) {
		boolean bExito=false;
		if(iId_opinion>-1) {
			this.iId_opinion = iId_opinion;
			bExito = true;
		}
		return bExito;
	}
	
	public String getsCritica() {
		return sCritica;
	}
	
	public boolean setsCritica(String sCritica) {
		boolean bExito=false;
		if(sCritica != null) {
			this.sCritica = sCritica;
			bExito = true;
		}
		return bExito;
	}
	
	public byte getiPuntuacion() {
		return iPuntuacion;
	}
	
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
