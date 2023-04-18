package userInterface;

import java.awt.*;

import javax.swing.*;

public class jugadorJugadaAbajo extends JPanel {
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;

    public jugadorJugadaAbajo() {
        // Establecemos el layout del panel como GridLayout con 4 columnas y 1 fila
        this.setLayout(new GridLayout(1, 4));
        setPreferredSize(new Dimension(getWidth(), 60));
        setBackground(Color.white);

        // Creamos los JLabel y les asignamos el texto correspondiente
        label1 = new JLabel("Jugadas:");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label2 = new JLabel("0");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label3 = new JLabel("Jugador:");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label4 = new JLabel(" ");
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregamos los JLabel al panel en el orden deseado
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
    }

    public static void actualizarNombre(String nombre) {
        // Actualizamos el valor del JLabel
        label4.setText(nombre);
    }

    public void actualizarJugada() {
        // Actualizamos el valor del JLabel
        int jugada = mainInterface.tablero.darJugadas();
        label2.setText(String.valueOf(jugada));
    }
}
