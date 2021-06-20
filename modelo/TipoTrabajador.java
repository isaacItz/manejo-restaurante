package modelo;

import java.util.List;

public class TipoTrabajador {
	private String tipo;
	private String zona;
	private List<String> beneficios;

	public TipoTrabajador() {
		super();
	}

	public TipoTrabajador(String tipo, String zona, List<String> beneficios) {
		super();
		this.tipo = tipo;
		this.zona = zona;
		this.beneficios = beneficios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((zona == null) ? 0 : zona.hashCode());
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
		TipoTrabajador other = (TipoTrabajador) obj;
		if (beneficios == null) {
			if (other.beneficios != null)
				return false;
		} else if (!beneficios.equals(other.beneficios))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (zona == null) {
			if (other.zona != null)
				return false;
		} else if (!zona.equals(other.zona))
			return false;
		return true;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public boolean existenBeneficios() {
		return this.beneficios != null && this.beneficios.size() > 0;
	}

	public String[] getBeneficios() {
		return beneficios.toArray(new String[beneficios.size()]);
	}

	public void setBeneficios(List<String> beneficios) {
		this.beneficios = beneficios;
	}

	@Override
	public String toString() {
		return "tipo: " + tipo + ", zona: " + zona + "";
	}

}
