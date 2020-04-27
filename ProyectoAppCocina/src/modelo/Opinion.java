package modelo;

public class Opinion implements IOpinion{
	private int iId_opinion; //PK
	private String sCritica;
	private byte iPuntuacion;
		
	public Opinion(int iId_opinion, String sCritica, byte iPuntuacion) {
		setiId_opinion(iId_opinion);
		setsCritica(sCritica);
		setiPuntuacion(iPuntuacion);
	}
	
	public Opinion(int iId_opinion) {
		setiId_opinion(iId_opinion);
	}
	
	@Override
	public int getiId_opinion() {
		return iId_opinion;
	}
	
	private boolean setiId_opinion(int iId_opinion) {
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

	@Override
	public String toString() {
		String sResultado="";
		sResultado+= "Puntuacion: "+getiPuntuacion();
		sResultado+="Critica: "+getsCritica();
		return sResultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iId_opinion;
		result = prime * result + iPuntuacion;
		result = prime * result + ((sCritica == null) ? 0 : sCritica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Opinion other = (Opinion) obj;
		if(this.iId_opinion== other.iId_opinion) {
		    bExito = true;
		}
		return bExito;
	}
	
	
	
}
