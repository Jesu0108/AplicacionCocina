package modelo.usuario;

import java.sql.Date;

public class Servicio implements IServicio {
	private int iId_servicio; // PK
	private String sNombre_tipo_servicio;
	private Date dFecha;
	private byte bTiempo_servicio; // NN

	public Servicio(int iId_servicio, String sNombre_tipo_servicio, Date dFecha, byte bTiempo_servicio) {

		setiId_servicio(iId_servicio);
		setsNombre_tipo_servicio(sNombre_tipo_servicio);
		setdFecha(dFecha);
		setbTiempo_servicio(bTiempo_servicio);
	}

	public Servicio(int iId_servicio) {

		setiId_servicio(iId_servicio);
	}
	
	public Servicio(String sNombre_tipo_servicio) {
		setsNombre_tipo_servicio(sNombre_tipo_servicio);
	}

	// Getters and Setters

	@Override
	public int getiId_servicio() {
		return iId_servicio;
	}

	private boolean setiId_servicio(int iId_servicio) {
		boolean bExito = false;
		if (iId_servicio > -1) {
			this.iId_servicio = iId_servicio;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsNombre_tipo_servicio() {
		return sNombre_tipo_servicio;
	}

	@Override
	public boolean setsNombre_tipo_servicio(String sNombre_tipo_servicio) {
		boolean bExito = false;
		if (sNombre_tipo_servicio != null) {
			this.sNombre_tipo_servicio = sNombre_tipo_servicio;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getCif() {
		return cif;
	}

	@Override
	public boolean setCif(String cif) {
		boolean bExito = false;
		if (cif != null) {
			this.cif = cif;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public Date getdFecha() {
		return dFecha;
	}

	@Override
	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}

	@Override
	public byte getbTiempo_servicio() {
		return bTiempo_servicio;
	}

	@Override
	public boolean setbTiempo_servicio(byte bTiempo_servicio) {
		boolean bExito = false;
		if (bTiempo_servicio > -1) {
			this.bTiempo_servicio = bTiempo_servicio;
			bExito = true;
		}
		return bExito;
	}

	// ----------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bTiempo_servicio;
		result = prime * result + ((dFecha == null) ? 0 : dFecha.hashCode());
		result = prime * result + iId_servicio;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((sNombre_tipo_servicio == null) ? 0 : sNombre_tipo_servicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Servicio other = (Servicio) obj;
		if (this.iId_servicio == other.iId_servicio) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "Servicio: " + getsNombre_tipo_servicio() + "\n";
		sResultado += "Tiempo de servicio estimado: " + getbTiempo_servicio() + "\n";
		sResultado += "Con fecha: " + getdFecha() + "\n";
		sResultado += "Para domicilio con CIF: " + getCif();
		return sResultado;
	}
}
