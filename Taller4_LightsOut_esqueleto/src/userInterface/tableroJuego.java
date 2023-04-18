package userInterface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Top10;

public class tableroJuego extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;
    private int ladoTablero;

    public tableroJuego() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        // Graphics2D g2d = (Graphics2D) g;

        boolean[][] tableroJuego = mainInterface.tablero.darTablero();
        ladoTablero = mainInterface.tamano;

        int ancho = getWidth() / ladoTablero - 1;
        int alto = getHeight() / ladoTablero - 1;

        for (int i = 0; i < ladoTablero; i++) {
            for (int j = 0; j < ladoTablero; j++) {
                if (tableroJuego[i][j] == true) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(i * ancho, j * alto, ancho, alto);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * ancho, j * alto, ancho, alto);

                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * ancho, j * alto, ancho, alto);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * ancho, j * alto, ancho, alto);
                }

            }

        }
    }

    public void mousePressed(MouseEvent e) {
        if (mainInterface.sePuedeJugarGOOOD && mainInterface.sePuedeJugarGOOODConNombre) {
            int click_x = e.getX();
            int click_y = e.getY();
            int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
            // cuenta los clicks por casilla
            // cantidades[casilla[0]][casilla[1]]++;
            // Hace click
            // JOptionPane.showMessageDialog( this, "Hizo click en \n fila:"+ casilla[0]
            // +"\n columna" +casilla[1] );
            mainInterface.tablero.jugar(casilla[1], casilla[0]);
            // guarda las ultimas coordenadas
            // this.ultima_fila = casilla[0];
            // this.ultima_columna = casilla[1];
            repaint();
            mainInterface.abajo.actualizarJugada();
            if (mainInterface.tablero.tableroIluminado()) {
                // pop up de felicitaciones
                String message = "Ganaste!, tu puntaje es de " + mainInterface.tablero.calcularPuntaje();

                mainInterface.top10.agregarRegistro(mainInterface.nombre, mainInterface.tablero.calcularPuntaje());
                if (mainInterface.top10.esTop10(mainInterface.tablero.calcularPuntaje())) {
                    message += "\n Quedaste en el TOP 10 :D";
                }
                JOptionPane.showMessageDialog(new JFrame(), message, "Â¡GANADOR!",
                        JOptionPane.INFORMATION_MESSAGE);
                try {
                    mainInterface.top10.salvarRecords(Top10.str2File(
                            "/Users/marco/eclipse-workspace/DPOO/TalleresDPOO2023-10/Taller4_LightsOut_esqueleto/data/top10.csv"));
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                }
            }
        } else {
            String message = "Tienes que poner un nombre (Boton cambiar nombre) e iniciar el juego (Boton nuevo) para empezar a jugar";
            JOptionPane.showMessageDialog(new JFrame(), message, "Precaucion",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        // poner el mensaje de completado
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        // int ladoTablero = tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

    public void actualizar() {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
