package userInterface;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.*;

public class mainInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Tablero tablero;
	public static int tamano = 5;
	public static String nombre;
	public static Top10 top10;
	public static int dificultad = 3;
	public static tableroJuego adentroIzquierda;
	public static arriba arriba;
	public static jugadorJugadaAbajo abajo;
	public static boolean sePuedeJugarGOOOD = false;
	public static boolean sePuedeJugarGOOODConNombre = false;

	public mainInterface() {
		tablero = new Tablero(tamano);
		top10 = new Top10();

		top10.cargarRecords(Top10.str2File(
				("./data/top10.csv")));

		setTitle("Lights Out Game");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Acá sirve el dispose on close,
		// sirve para guardar los cambos

		setLayout(new BorderLayout());

		arriba = new arriba();
		add(arriba, BorderLayout.NORTH);

		abajo = new jugadorJugadaAbajo();
		add(abajo, BorderLayout.SOUTH);

		JPanel centro = new JPanel(new GridBagLayout());
		centro.setPreferredSize(new Dimension(getWidth(), 60));
		centro.setBackground(Color.WHITE);
		add(centro, BorderLayout.CENTER);

		centro.setLayout(new BorderLayout(10, 10));

		adentroIzquierda = new tableroJuego();
		Dimension preferredSize = new Dimension(420, 420);
		adentroIzquierda.setPreferredSize(preferredSize);

		JPanel adentroDerecha = new rightSide(getWidth());
		centro.add(adentroIzquierda, BorderLayout.WEST);
		centro.add(adentroDerecha, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainInterface ventana = new mainInterface();
				ventana.setVisible(true);
			}
		});
	}
}