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
public class Crear extends JFrame {
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
	private JTextField apellido;
	private JTextField cedula;
	private JTextField edad;
	private JTextField cargo;

	public Crear(MouseListener mouse, MouseMotionListener motion) {
		properties = FileHandler.loadPropities();
		pr = new Color(255, 0, 56);
		sc = new Color(62, 0, 13);
		//
		fuente = new Font("Tahoma", 0, 20);
		ventanaI = new JPanel();
		crear = new JLabel(properties.getProperty("persistence.boton.crear2"), SwingConstants.CENTER);
		retroceder = new JLabel((properties.getProperty("persistence.boton.retroceder")), SwingConstants.CENTER);
		fantasma = new JLabel((properties.getProperty("persistence.titulo.crear")), SwingConstants.CENTER);
		botones = new JPanel();
		bots = new ArrayList<JLabel>();
		nombre = new JTextField();
		apellido = new JTextField();
		cedula = new JTextField();
		edad = new JTextField();
		cargo = new JTextField();
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
		botones.setBounds(0, 340, 600, 60);
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
		nombre.setBounds(50, 75, 500, 50);
		nombre.setBackground(Color.WHITE);
		nombre.setForeground(Color.BLACK);
		nombre.setBorder(
				(new TitledBorder(new MatteBorder(2, 2, 2, 2, sc), properties.getProperty("persistence.field.nombre"),
						0, SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		apellido.setFont(fuente.deriveFont(0, 18));
		apellido.setBounds(50, 125, 500, 50);
		apellido.setBackground(Color.WHITE);
		apellido.setForeground(Color.BLACK);
		apellido.setBorder(
				(new TitledBorder(new MatteBorder(2, 2, 2, 2, sc), properties.getProperty("persistence.field.apellido"),
						0, SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		cedula.setFont(fuente.deriveFont(0, 18));
		cedula.setBounds(50, 175, 500, 50);
		cedula.setBackground(Color.WHITE);
		cedula.setForeground(Color.BLACK);
		cedula.setBorder(
				(new TitledBorder(new MatteBorder(2, 2, 2, 2, sc), properties.getProperty("persistence.field.cedula"),
						0, SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		edad.setFont(fuente.deriveFont(0, 18));
		edad.setBounds(50, 225, 500, 50);
		edad.setBackground(Color.WHITE);
		edad.setForeground(Color.BLACK);
		edad.setBorder((new TitledBorder(new MatteBorder(2, 2, 2, 2, sc),
				properties.getProperty("persistence.field.edad"), 0, SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		cargo.setFont(fuente.deriveFont(0, 18));
		cargo.setBounds(50, 275, 500, 50);
		cargo.setBackground(Color.WHITE);
		cargo.setForeground(Color.BLACK);
		cargo.setBorder(
				(new TitledBorder(new MatteBorder(2, 2, 2, 2, sc), properties.getProperty("persistence.field.cargo"), 0,
						SwingConstants.CENTER, fuente.deriveFont(0, 16))));
		//
		this.setSize(600, 400);
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
		ventanaI.add(apellido);
		ventanaI.add(cedula);
		ventanaI.add(edad);
		ventanaI.add(cargo);
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
		if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || cedula.getText().isEmpty()
				|| edad.getText().isEmpty() || cargo.getText().isEmpty()) {
			return "0001";
		} else {
			try {
				Integer.parseInt(cedula.getText());
				Integer.parseInt(edad.getText());
				String aux = nombre.getText() + "%" + apellido.getText() + "%" + cedula.getText() + "%" + edad.getText()
						+ "%" + cargo.getText();
				return aux;
			}catch (Exception e) {
				return "0001";
			}
		}
	}
	
	public String getNombre() {
		return nombre.getText();
	}
	
	public String getApellido() {
		return apellido.getText();
	}
	
	public int getCedula() {
		return Integer.parseInt(cedula.getText());
	}
	
	public int getEdad() {
		return Integer.parseInt(edad.getText());
	}
	
	public String getCargo() {
		return cargo.getText();
	}
	
	public void limpiar() {
		nombre.setText("");
		apellido.setText("");
		cedula.setText("");
		edad.setText("");
		cargo.setText("");
	}

}
