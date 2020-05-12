package modelo.usuario;

import java.sql.Date;

public interface IServicio {

	public int getiId_servicio();

	public String getsNombre_tipo_servicio();

	public boolean setsNombre_tipo_servicio(String sNombre_tipo_servicio);

	public Date getdFecha();

	public void setdFecha(Date dFecha);

	public byte getbTiempo_servicio();

	public boolean setbTiempo_servicio(byte bTiempo_servicio);

	

	

}
