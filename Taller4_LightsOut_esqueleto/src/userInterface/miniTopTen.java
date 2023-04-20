package userInterface;

import javax.swing.*;
import java.awt.*;

public class miniTopTen extends JPanel {
    private static final long serialVersionUID = 1L;
	private int num;
    private String nombre;
    private int puntaje;

    public miniTopTen(int num, String nombre, int puntaje) {
        this.num = num;
        this.nombre = nombre;
        this.puntaje = puntaje;
        setLayout(new GridLayout(1, 3));

        JLabel numeroEnLista = new JLabel();
        numeroEnLista.setText(String.valueOf(num) + ")");
        numeroEnLista.setHorizontalAlignment(SwingConstants.CENTER);
        numeroEnLista.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel nombreJugador = new JLabel(nombre);
        nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJugador.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel puntajeJugador = new JLabel(String.valueOf(puntaje));
        puntajeJugador.setHorizontalAlignment(SwingConstants.CENTER);
        puntajeJugador.setFont(new Font("Arial", Font.PLAIN, 14));

        add(numeroEnLista);
        add(nombreJugador);
        add(puntajeJugador);
    }

    public int getNum() {
        return num;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
