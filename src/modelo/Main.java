package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	private static Trabajadores trabajadores;

	private static final String MENU = "Restaurante la Moldovita\n 1.- Registrar Trabajador\n 2.- Regisrar Tipo de Trabajador\n 3.- Modificar Trabajador\n 4.- Buscar Trabajador\n 5.- Eliminar Trabajador\n 6.- Listar Trabajadores\n 7.- Listar tipos de trabajadores\n 8.- Salir\n";

	public static void main(String... strings) {
		trabajadores = new Trabajadores();
		Integer op = 0;
		do {

			op = Utileria.getEntero(MENU);
			if (op == null)
				break;
			switch (op) {
			case 1:
				agregarTrabajador();
				break;
			case 2:
				agregarTipoEmpleado();
				break;
			case 3:
				modificarTrabajador();
				break;
			case 4:
				buscarTrabajador();
				break;
			case 5:
				eliminarTrabajador();
				break;
			case 6:
				listarTrabajadores(null);
				break;
			case 7:
				listarTiposTrabajador();
				break;
			case 8:
				break;
			default:
				Utileria.mensaje("Opcion no valida");
			}
		} while (op != null && op != 8);

	}

	private static void agregarTrabajador() {
		if (trabajadores.hayTiposTrabajador()) {
			Trabajador tra = new Trabajador();

			tra.setNombre(Utileria.getCadena("Ingresa el nombre de la persona"));
			tra.setApellidoP(Utileria.getCadena("Ingresa el apellido paterno"));
			tra.setApellidoM(Utileria.getCadena("Ingresa el apellido materno"));
			String o = Utileria.getOpcion("Ingresa el sexo", new String[] { "Masculino", "Femenino" });
			tra.setSexo(Character.toLowerCase(o.charAt(0)));
			LocalDate fecha = null;
			do {
				fecha = Utileria.getFecha("Ingresa la fecha de nacimiento");
				if (fecha == null)
					fecha = LocalDate.now();
				else if (!Utileria.esAdulto(fecha))
					Utileria.mensaje("La persona debe ser adulta");
			} while (!Utileria.esAdulto(fecha));
			tra.setFechaNac(fecha);
			tra.setTipoTrabajador(Utileria.getOpcion("Seleccione el tipo de Trabajador", trabajadores.getTipos()));
			trabajadores.agregarTrabajador(tra);
			Utileria.mensaje("Trabajador regisrado con exito");
		} else {
			Utileria.mensaje("Debe registar un tipo de trabajador primero");
		}
	}

	public static void listarTiposTrabajador() {
		if (trabajadores.hayTiposTrabajador()) {
			String salida = "Tipos de Empleados del Restaurante: \n";
			for (TipoTrabajador t : trabajadores.getTipos()) {
				salida += "Tipo: ".concat(t.getTipo()).concat(" Zona: ").concat(t.getZona()).concat("\n");
				if (t.existenBeneficios()) {
					salida += "Beneficios: \n";
					for (String b : t.getBeneficios()) {
						salida += "   ·".concat(b).concat("\n");
					}
				}
				salida += "\n";
			}
			Utileria.mensaje(salida);
		} else {
			Utileria.mensaje("Aun no hay tipos de trabajadores registrados");
		}
	}

	public static void modificarTrabajador() {
		if (trabajadores.hayTrabajadores()) {
			String nombre = Utileria.getCadena("Ingresa el nombre del trabajador a buscar");
			String ap = Utileria.getCadena("Ingresa el apellido Paterno del trabajador a buscar");
			String am = Utileria.getCadena("Ingresa el apellido materno del trabajador a buscar");
			Trabajador trabajador = new Trabajador();
			trabajador.setNombre(nombre);
			trabajador.setApellidoP(ap);
			trabajador.setApellidoM(am);
			trabajador = trabajadores.getTrabajador(trabajador);
			if (trabajador != null) {
				trabajador.setNombre(
						Utileria.getCadena("Ingresa el nuevo nombre para: " + trabajador.getNombreCompleto()));
				trabajador.setApellidoP(Utileria
						.getCadena("Ingresa el nuevo apellido paterno para: " + trabajador.getNombreCompleto()));
				trabajador.setApellidoM(Utileria
						.getCadena("Ingresa el nuevo apellido materno para: " + trabajador.getNombreCompleto()));
				String o = Utileria.getOpcion("Ingresa el nuevo sexo para: " + trabajador.getNombreCompleto(),
						new String[] { "Masculino", "Femenino" });
				trabajador.setSexo(Character.toLowerCase(o.charAt(0)));
				LocalDate fecha = null;
				do {
					fecha = Utileria
							.getFecha("Ingresa la nueva fecha de nacimiento para: " + trabajador.getNombreCompleto());
					if (fecha == null)
						fecha = LocalDate.now();
					else if (!Utileria.esAdulto(fecha))
						Utileria.mensaje("La persona debe ser adulta");
				} while (!Utileria.esAdulto(fecha));
				trabajador.setFechaNac(fecha);
				trabajador.setTipoTrabajador(
						Utileria.getOpcion("Seleccione el tipo de Trabajador", trabajadores.getTipos()));
				Utileria.mensaje("Trabajador actualizado con exito");
			} else {
				Utileria.mensaje("El trabajador no existe");
			}
		} else {
			Utileria.mensaje("No hay trabajadores que coincidan con la busqueda");
		}
	}

	public static void buscarTrabajador() {
		if (trabajadores.hayTrabajadores()) {
			String nombre = Utileria.getCadena("Ingresa el nombre del trabajador a buscar");
			String ap = Utileria.getCadena("Ingresa el apellido Paterno del trabajador a buscar");
			String am = Utileria.getCadena("Ingresa el apellido materno del trabajador a buscar");
			Trabajador trabajador = new Trabajador();
			trabajador.setNombre(nombre);
			trabajador.setApellidoP(ap);
			trabajador.setApellidoM(am);
			listarTrabajadores(trabajadores.getFiltro(trabajador));

		} else {
			Utileria.mensaje("No hay trabajadores que coincidan con la busqueda");
		}
	}

	public static void eliminarTrabajador() {
		if (trabajadores.hayTrabajadores()) {

			String nombre = Utileria.getCadena("Ingresa el nombre del trabajador a buscar");
			String ap = Utileria.getCadena("Ingresa el apellido Paterno del trabajador a buscar");
			String am = Utileria.getCadena("Ingresa el apellido materno del trabajador a buscar");
			Trabajador trabajador = new Trabajador();
			trabajador.setNombre(nombre);
			trabajador.setApellidoP(ap);
			trabajador.setApellidoM(am);
			trabajadores.eliminarTrabajador(trabajador);
			Utileria.mensaje("Trabajador Eliminado");
		} else {
			Utileria.mensaje("No hay trabajadores registrados");
		}
	}

	private static void agregarTipoEmpleado() {
		String tipo = Utileria.getCadena("Ingresa el tipo de Trabajador a registrar");
		if (!trabajadores.existeTipoTrabajador(tipo)) {
			TipoTrabajador tipoTra = new TipoTrabajador();
			tipoTra.setTipo(tipo);
			String zona = Utileria.getCadena("Ingresa la zona de trabajo para el tipo de trabajador");
			tipoTra.setZona(zona);
			if (Utileria.getConfirmacion("¿Este tipo de trabajador tendra beneficios?") == JOptionPane.YES_OPTION) {
				int op = 0;
				List<String> beneficios = new ArrayList<>();
				do {
					String beneficio = Utileria.getCadena("Ingresa el beneficio para el trabajador");
					if (!beneficios.contains(beneficio))
						beneficios.add(beneficio);
					tipoTra.setBeneficios(beneficios);
					op = Utileria.getConfirmacion("¿Desea agregar otro beneficio?");
				} while (op == 0);
			}
			trabajadores.agregarTipo(tipoTra);
			Utileria.mensaje("Tipo de trabajador agregado con exito");
		} else {
			Utileria.mensaje("El tipo de trabajador ya esta registrado");
		}
	}

	private static void listarTrabajadores(Trabajador[] trabajadores) {
		if (trabajadores == null || trabajadores.length == 0) {
			trabajadores = Main.trabajadores.getTrabajadores();
		}

		if (Main.trabajadores.hayTrabajadores()) {
			String salida = "Lista de trabajadores\n";
			for (Trabajador t : trabajadores) {
				salida += t.getNombreCompleto().concat("\n");
				salida += "Fecha de nacimiento: ".concat(t.getFechaNac().toString().concat("\n"));
				salida += "Tipo de trabajador: ".concat(t.getTipoTrabajador().getTipo()).concat("\n");
				salida += "Zona del trabajador: ".concat(t.getTipoTrabajador().getZona()).concat("\n");
				if (t.getTipoTrabajador().existenBeneficios()) {
					salida += "Beneficios: \n";
					for (String b : t.getTipoTrabajador().getBeneficios()) {
						salida += "   ·".concat(b).concat("\n");
					}
				}
			}
			salida += "\n";
			salida += "\n";
			Utileria.mensaje(salida);

		} else {
			Utileria.mensaje("No hay trabajadores registrados");
		}
	}
}
