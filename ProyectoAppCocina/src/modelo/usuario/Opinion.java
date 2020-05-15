package modelo.usuario;

public class Opinion implements IOpinion{
	private int iId_opinion; //PK
	private String sCritica;
	private byte bPuntuacion;
		
	
	public Opinion(int iId_opinion,String sCritica, byte bPuntuacion) {
		setiId_opinion(iId_opinion);
		setsCritica(sCritica);
		setbPuntuacion(bPuntuacion);
	}
	
	public Opinion(String sCritica, byte bPuntuacion) {
		setiId_opinion(0);
		setsCritica(sCritica);
		setbPuntuacion(bPuntuacion);
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
	public byte getbPuntuacion() {
		return bPuntuacion;
	}
	
	@Override
	public boolean setbPuntuacion(byte bPuntuacion) {
		boolean bExito=false;
		if(bPuntuacion > -1) {
			this.bPuntuacion = bPuntuacion;
			bExito=true;
		}
		bExito = true;
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado="";
		sResultado+= "Puntuacion: "+getbPuntuacion();
		sResultado+="Critica: "+getsCritica();
		return sResultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iId_opinion;
		result = prime * result + bPuntuacion;
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
