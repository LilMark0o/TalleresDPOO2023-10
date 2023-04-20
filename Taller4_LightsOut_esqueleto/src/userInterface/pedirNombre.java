package userInterface;

import javax.swing.*;

public class pedirNombre extends JFrame {

    private static final long serialVersionUID = 1L;

	public pedirNombre() {
        // Configuramos la ventana
        this.setTitle("Cambio de Jugador Juego");
        this.setSize(350, 150);
        this.setLocationRelativeTo(null);

        // Creamos un panel para agregar los componentes
        JPanel panel = new JPanel();

        // Creamos una etiqueta para indicar al usuario que ingrese su nombre
        JLabel label = new JLabel("Ingrese el nombre del nuevo jugador:");
        panel.add(label);

        // Creamos un campo de texto para que el usuario ingrese su nombre
        JTextField textField = new JTextField(20);
        panel.add(textField);

        // Creamos un botón para que el usuario confirme su nombre
        JButton button = new JButton("Confirmar");
        button.addActionListener(e -> {
            String nombre = textField.getText();
            jugadorJugadaAbajo.actualizarNombre(nombre);
            mainInterface.nombre = nombre;
            dispose();
        });
        panel.add(button);

        // Agregamos el panel a la ventana
        this.add(panel);

        // Hacemos visible la ventana
        this.setVisible(true);
    }
}
