package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Persona implements LimitsDB, IPersona{
	private String sEmail; // PK
	private String sContrasenia, sNombre, sApellidos, sTelefono; // Valores NN
	private String sExperiencia, sCiudad;

	public Persona(String sEmail, String sContrasenia, String sNombre, String sApellidos, String sTelefono,
			String sExperiencia, String sCiudad) {
		setsEmail(sEmail);
		setsContrasenia(sContrasenia);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setsTelefono(sTelefono);
		setsExperiencia(sExperiencia);
		setsCiudad(sCiudad);
	}

	public Persona(String sEmail) {
		setsEmail(sEmail);
	}

	// Getters and Setters
	public String getsEmail() {
		return sEmail;
	}
	
	private boolean setsEmail(String sEmail) {
		boolean bExito = false;
		if (sEmail != null && sEmail.contains("@")) {
			this.sEmail = sEmail;
			bExito = true;
		}
		return bExito;
	}

	public String getsContrasenia() {
		return sContrasenia;
	}

	@Override
	public boolean setsContrasenia(String sContrasenia) {
		boolean bExito = false;
		if (sContrasenia != null && sContrasenia.length() > MINCHARPASSWORD
				&& sContrasenia.length() < MAXCHARPASSWORD) {
			this.sContrasenia = encryptSha512(sContrasenia);
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsNombre() {
		return sNombre;
	}

	@Override
	public boolean setsNombre(String sNombre) {
		boolean bExito = false;
		if(sNombre != null) {
			this.sNombre = sNombre;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsApellidos() {
		return sApellidos;
	}

	@Override
	public boolean setsApellidos(String sApellidos) {
		boolean bExito = false;
		if(sNombre != null) {
			this.sApellidos = sApellidos;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsTelefono() {
		return sTelefono;
	}

	@Override
	public boolean setsTelefono(String sTelefono) {
		boolean bExito = false;
		if(sNombre != null) {
			this.sTelefono = sTelefono;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsExperiencia() {
		return sExperiencia;
	}

	@Override
	public boolean setsExperiencia(String sExperiencia) {
		boolean bExito = false;
		if(sNombre != null) {
			this.sExperiencia = sExperiencia;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsCiudad() {
		return sCiudad;
	}

	@Override
	public boolean setsCiudad(String sCiudad) {
		boolean bExito = false;
		if(sNombre != null) {
			this.sCiudad = sCiudad;
			bExito = true;
		}
		return bExito;
	}

	// ---------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "Email: " + getsEmail() + "\n";
		sResultado += "Nombre: " + getsNombre() + "\n";
		sResultado += "Apellidos: " + getsApellidos() + "\n";
		sResultado += "Telefono: " + getsTelefono() + "/n";
		sResultado += "Ciudad: " + getsCiudad() + "/n";
		sResultado += "Experiencia: " + getsExperiencia() + " anios/n";
		return sResultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sEmail == null) ? 0 : sEmail.hashCode());
		return result;
	}

	@Override
	 public boolean equals (Object obj) {
		boolean bExito = false;
		Persona other = (Persona) obj;
		if(checkUser() && other.checkUser() && this.sEmail.equals(other.sEmail)) {
		    bExito = true;
		}
		return bExito;
	    } 

	// ---------------------------------------------------------------------------------------------------

	// Metodo de encriptacion de la contrasenia
	@Override
	public String encryptSha512(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	// Metodo para comprobar que el usuario intriduce bien los datos NN
	@Override
	public boolean checkUser() {
		boolean bExito = false;
		if (this.sEmail != null && this.sContrasenia != null && this.sNombre != null && 
				this.sApellidos != null && this.sTelefono != null) {
			bExito = true;
		}
		return bExito;
	}

	//Metodo para comprobar si el login de un usuario es correcto
	@Override
    public boolean checkLogin(Object obj) {
	boolean bExito = false;
	Persona other = (Persona) obj;
	if(checkUser() && other.checkUser() && this.sEmail.equals(other.sEmail) && this.sContrasenia.equals(other.sContrasenia)) {
	    bExito = true;
	}
	return bExito;
    }
}
