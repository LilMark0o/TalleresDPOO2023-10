package userInterface;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rightSide extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton buttonNuevo;
	private JButton buttonReiniciar;
	private JButton buttonTopTen;
	private JButton buttonCambiarJugador;

	public rightSide(int width) {
		setLayout(new GridLayout(9, 1));
		setPreferredSize(new Dimension((int) (width * 0.27), 480));
		setBackground(Color.white);
		add(new JLabel(""));
		buttonNuevo = new JButton();
		buttonNuevo.addActionListener(this);
		buttonNuevo.setText("Nuevo");
		buttonNuevo.setFocusable(false);
		buttonNuevo.setBackground(new Color(102, 178, 255));
		buttonNuevo.setForeground(Color.WHITE);

		add(buttonNuevo);

		add(new JLabel(""));

		buttonReiniciar = new JButton();
		buttonReiniciar.addActionListener(this);
		buttonReiniciar.setText("Reiniciar");
		buttonReiniciar.setFocusable(false);
		buttonReiniciar.setEnabled(false);
		buttonReiniciar.setBackground(new Color(102, 178, 255));
		buttonReiniciar.setForeground(Color.WHITE);

		add(buttonReiniciar);
		add(new JLabel(""));
		buttonTopTen = new JButton();
		buttonTopTen.addActionListener(this);
		buttonTopTen.setText("Top - 10");
		buttonTopTen.setFocusable(false);
		buttonTopTen.setBackground(new Color(102, 178, 255));
		buttonTopTen.setForeground(Color.WHITE);

		add(buttonTopTen);
		add(new JLabel(""));

		buttonCambiarJugador = new JButton();
		buttonCambiarJugador.addActionListener(this);
		buttonCambiarJugador.setText("Cambiar Jugador");
		buttonCambiarJugador.setFocusable(false);
		buttonCambiarJugador.setBackground(new Color(102, 178, 255));
		buttonCambiarJugador.setForeground(Color.WHITE);

		add(buttonCambiarJugador);
		add(new JLabel(""));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonNuevo) {
			mainInterface.tablero = new Tablero(mainInterface.tamano);
			mainInterface.tablero.desordenar(mainInterface.dificultad);
			mainInterface.adentroIzquierda.actualizar();
			mainInterface.abajo.actualizarJugada();
			buttonReiniciar.setEnabled(true);
			mainInterface.sePuedeJugarGOOOD = true;

		} else if (e.getSource() == buttonReiniciar) {
			mainInterface.tablero.reiniciar();
			mainInterface.adentroIzquierda.actualizar();
			mainInterface.abajo.actualizarJugada();
		} else if (e.getSource() == buttonTopTen) {
			new ShowTopTen();
		} else if (e.getSource() == buttonCambiarJugador) {
			new pedirNombre();
			mainInterface.sePuedeJugarGOOODConNombre = true;
		}
	}
}
