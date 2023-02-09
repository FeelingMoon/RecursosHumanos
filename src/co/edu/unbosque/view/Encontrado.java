package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import co.edu.unbosque.model.persistence.FileHandler;

@SuppressWarnings("serial")
public class Encontrado extends JFrame {
	private JPanel ventanaI;
	private JPanel botones;
	private JLabel fantasma;
	private JLabel retroceder;
	private ArrayList<JLabel> bots;
	private Font fuente;
	private Properties properties;
	private Color pr, sc;
	private JTextArea info;

	public Encontrado(MouseListener mouse, MouseMotionListener motion) {
		properties = FileHandler.loadPropities();
		pr = new Color(255, 0, 56);
		sc = new Color(62, 0, 13);
		//
		fuente = new Font("Tahoma", 0, 20);
		ventanaI = new JPanel();
		retroceder = new JLabel((properties.getProperty("persistence.boton.retroceder2")), SwingConstants.CENTER);
		fantasma = new JLabel((properties.getProperty("persistence.titulo.encontrado")), SwingConstants.CENTER);
		botones = new JPanel();
		bots = new ArrayList<JLabel>();
		info = new JTextArea();
		//
		bots.add(fantasma);
		bots.add(retroceder);
		//
		fantasma.setOpaque(true);
		fantasma.setBackground(sc);
		fantasma.setForeground(Color.WHITE);
		fantasma.setFont(fuente);
		fantasma.setBounds(0, 0, 400, 50);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(motion);
		//
		botones.setBounds(0, 240, 400, 60);
		botones.setLayout(new GridLayout(1, 1));
		//
		retroceder.setOpaque(true);
		retroceder.setBackground(pr);
		retroceder.setForeground(Color.WHITE);
		retroceder.setFont(fuente);
		retroceder.addMouseListener(mouse);
		retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		retroceder.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(retroceder);
		//
		info.setBounds(25, 75, 350, 140);
		info.setEditable(false);
		info.setFont(fuente);
		info.setBorder(new MatteBorder(3, 3, 3, 3, sc));
		info.setLineWrap(true);
		info.setForeground(Color.BLACK);
		//
		this.setSize(400, 300);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventanaI.setBackground(Color.WHITE);
		ventanaI.setLayout(null);
		ventanaI.setSize(this.getSize());
		ventanaI.add(fantasma);
		ventanaI.add(botones);
		ventanaI.add(info);
		this.add(ventanaI);
		//
	}

	public JLabel obtenerLB(int x) {
		return bots.get(x);
	}

	public void interiorColor(int x) {
		bots.get(x).setBackground(sc);
	}

	public void exteriorColor(int x) {
		bots.get(x).setBackground(pr);
	}

	public void ubicacion(int x, int y) {
		this.setLocation(x, y);
	}

	public void limpiar() {
		info.setText("");
	}

	public void rellenarInfo(String nombre, String apellido, String cedula, int edad, String cargo) {
		info.setText("Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Cedula: " + cedula + "\n" + "Edad: "
				+ edad + "\n" + "Cargo: " + cargo + "\n");
	}

}
