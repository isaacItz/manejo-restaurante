package modelo;

import java.time.LocalDate;

public class Trabajador {

	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private LocalDate fechaNac;
	private char sexo;
	private TipoTrabajador tipoTrabajador;

	public Trabajador() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoM == null) ? 0 : apellidoM.hashCode());
		result = prime * result + ((apellidoP == null) ? 0 : apellidoP.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		if (apellidoM == null) {
			if (other.apellidoM != null)
				return false;
		} else if (!apellidoM.equals(other.apellidoM))
			return false;
		if (apellidoP == null) {
			if (other.apellidoP != null)
				return false;
		} else if (!apellidoP.equals(other.apellidoP))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public TipoTrabajador getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	public String getNombreCompleto() {
		return nombre.concat(" ").concat(apellidoP).concat(" ").concat(apellidoM);
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNac="
				+ fechaNac + ", sexo=" + sexo + ", tipoTrabajador=" + tipoTrabajador + "]";
	}

}
