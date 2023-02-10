package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class PopUp {
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "RECURSOS HUMANOS", JOptionPane.INFORMATION_MESSAGE);
	}
}
