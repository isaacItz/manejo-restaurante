package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Pruebas {

	public static void main(String... strings) {
		System.out.println(JOptionPane.YES_OPTION);
		String cad = "Masc";
		System.out.println(cad.charAt(0));
		String arr[] = { "Masculino", "Femenino" };
		JOptionPane.showInputDialog(null, "hola", "Seleccione", 3, null, arr, arr[0]);

		JDateChooser jd = new JDateChooser();
		String message = "Choose start date:\n";
		Object[] params = { message, jd };
		JOptionPane.showConfirmDialog(null, params, "Start date", JOptionPane.PLAIN_MESSAGE);
		System.out.println(jd.getDate());
		System.out.println(LocalDate.ofInstant(jd.getDate().toInstant(), ZoneId.systemDefault()));
		System.out.println(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(jd.getDate())));
	}
}
