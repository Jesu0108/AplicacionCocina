package modelo.usuario;

import java.util.Date;

public interface IServicio {

	public int getiId_servicio();
	
	public Date getdFecha();

	public void setdFecha(Date dFecha);

	public byte getbTiempo_servicio();

	public boolean setbTiempo_servicio(byte bTiempo_servicio);

	public Tipo_servicio getoNombre_tipo_servicio();

	public boolean setoNombre_tipo_servicio(Tipo_servicio oNombre_tipo_servicio);

	

	

}
