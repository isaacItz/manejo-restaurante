package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Utileria {
	public static Integer getEntero(String mensaje) {
		String texto = JOptionPane.showInputDialog(mensaje);
		try {
			return Integer.parseInt(texto);
		} catch (NumberFormatException e) {
			mensaje("Entrada no valida");
			return null;
		}
	}

	public static String getCadena(String mensaje) {
		String texto = null;
		do {
			texto = JOptionPane.showInputDialog(mensaje);
			if (texto == null || texto.isEmpty()) {
				mensaje("Texto no valido");
			}
		} while (texto == null || texto.isEmpty());
		return texto;
	}

	public static Character getChar(String mensaje) {
		String texto = JOptionPane.showInputDialog(mensaje);
		if (!texto.isEmpty()) {
			return texto.charAt(0);
		}
		mensaje("No se ha ingresado nada");
		return null;
	}

	public static LocalDate getFecha(String mensaje) {
		JDateChooser jd = new JDateChooser(new Date());
		Object[] params = { mensaje, jd };
		JOptionPane.showConfirmDialog(null, params, "Selecciona la fecha", JOptionPane.PLAIN_MESSAGE);
		try {
			return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(jd.getDate()));
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static boolean esAdulto(LocalDate fecha) {
		return fecha.isBefore(LocalDate.now().minusYears(18));
	}

	public static int getConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion", JOptionPane.YES_NO_OPTION);
	}

	public static <E> E getOpcion(String mensaje, E[] lista) {
		E showInputDialog = null;
		do {
			showInputDialog = (E) JOptionPane.showInputDialog(null, mensaje, "Seleccione", 3, null, lista, lista[0]);
			if (showInputDialog == null)
				mensaje("Seleccion no valida");
		} while (showInputDialog == null);
		return showInputDialog;
	}

	public static void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
