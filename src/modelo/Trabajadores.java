package modelo;

import java.util.ArrayList;
import java.util.List;

public class Trabajadores {

	private List<Trabajador> trabajadores;
	private List<TipoTrabajador> tiposTrabajador;

	public Trabajadores() {
		this.trabajadores = new ArrayList<>();
		this.tiposTrabajador = new ArrayList<>();
	}

	public boolean agregarTrabajador(Trabajador tra) {
		return this.trabajadores.add(tra);
	}

	public Trabajador[] getFiltro(Trabajador tra) {
		List<Trabajador> filtrados = new ArrayList<>();
		for (int i = 0; i < trabajadores.size(); i++) {
			if (trabajadores.get(i).equals(tra))
				filtrados.add(trabajadores.get(i));
		}
		return filtrados.toArray(new Trabajador[trabajadores.size()]);
	}

	public boolean eliminarTrabajador(Trabajador trabajador) {
		return trabajadores.remove(trabajador);
	}

	public Trabajador getTrabajador(int cve) {
		return this.trabajadores.get(cve);
	}

	public String toString() {
		return this.trabajadores.toString();
	}

	public void agregarTipo(TipoTrabajador tipo) {
		tiposTrabajador.add(tipo);
	}

	public boolean hayTiposTrabajador() {
		return this.tiposTrabajador.size() > 0;
	}

	public boolean existeTipoTrabajador(String tipo) {
		for (TipoTrabajador t : tiposTrabajador) {
			if (t.getTipo().equals(tipo)) {
				return true;
			}
		}
		return false;
	}

	public boolean hayTrabajadores() {
		return this.trabajadores.size() > 0;
	}

	public Trabajador[] getTrabajadores() {
		return trabajadores.toArray(new Trabajador[trabajadores.size()]);
	}

	public TipoTrabajador[] getTipos() {
		return tiposTrabajador.toArray(new TipoTrabajador[tiposTrabajador.size()]);
	}

}
