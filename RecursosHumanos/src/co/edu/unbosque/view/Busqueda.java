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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.FileHandler;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {
	private JPanel ventanaI;
	private JPanel botones;
	private JLabel fantasma;
	private JLabel crear;
	private JLabel retroceder;
	private ArrayList<JLabel> bots;
	private Font fuente;
	private Properties properties;
	private Color pr, sc;
	private JTextField nombre;

	public Busqueda(MouseListener mouse, MouseMotionListener motion) {
		properties = FileHandler.loadPropities();
		pr = new Color(255, 0, 56);
		sc = new Color(62, 0, 13);
		//
		fuente = new Font("Tahoma", 0, 20);
		ventanaI = new JPanel();
		crear = new JLabel(properties.getProperty("persistence.boton.buscar"), SwingConstants.CENTER);
		retroceder = new JLabel((properties.getProperty("persistence.boton.retroceder")), SwingConstants.CENTER);
		fantasma = new JLabel((properties.getProperty("persistence.titulo.buscar")), SwingConstants.CENTER);
		botones = new JPanel();
		bots = new ArrayList<JLabel>();
		nombre = new JTextField();
		//
		bots.add(fantasma);
		bots.add(crear);
		bots.add(retroceder);
		//
		fantasma.setOpaque(true);
		fantasma.setBackground(sc);
		fantasma.setForeground(Color.WHITE);
		fantasma.setFont(fuente);
		fantasma.setBounds(0, 0, 600, 50);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(motion);
		//
		botones.setBounds(0, 240, 600, 60);
		botones.setLayout(new GridLayout(1, 5));
		//
		retroceder.setOpaque(true);
		retroceder.setBackground(pr);
		retroceder.setForeground(Color.WHITE);
		retroceder.setFont(fuente);
		retroceder.addMouseListener(mouse);
		retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		retroceder.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(retroceder);
		crear.setOpaque(true);
		crear.setBackground(pr);
		crear.setForeground(Color.WHITE);
		crear.setFont(fuente);
		crear.addMouseListener(mouse);
		crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		crear.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(crear);
		//
		nombre.setFont(fuente.deriveFont(0, 18));
		nombre.setBounds(50, 110, 500, 50);
		nombre.setBackground(Color.WHITE);
		nombre.setForeground(Color.BLACK);
		nombre.setBorder(
				(new TitledBorder(new MatteBorder(2, 2, 2, 2, sc), properties.getProperty("persistence.field.cedula"),
						0, SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		//
		this.setSize(600, 300);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventanaI.setBackground(Color.WHITE);
		ventanaI.setLayout(null);
		ventanaI.setSize(this.getSize());
		ventanaI.add(fantasma);
		ventanaI.add(botones);
		ventanaI.add(nombre);

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

	public String obtenerTextos() {
		return nombre.getText();
	}

	public void limpiar() {
		nombre.setText("");

	}

}
