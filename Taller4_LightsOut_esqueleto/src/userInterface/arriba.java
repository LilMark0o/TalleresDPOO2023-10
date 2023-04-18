package userInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class arriba extends JPanel implements ActionListener {
    private JComboBox<String> sizeComboBox;
    private JRadioButton easyRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton hardRadioButton;

    public arriba() {
        this.setLayout(new GridLayout(1, 7));
        setPreferredSize(new Dimension(getWidth(), 60));
        setBackground(new Color(102, 178, 255));

        JLabel sizeLabel = new JLabel("Tamano:");
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(sizeLabel);

        String[] sizes = { "5x5", "7x7", "9x9" };
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        sizeComboBox.addActionListener(this);
        this.add(sizeComboBox);

        JLabel difficultyLabel = new JLabel("Dificultad:");
        difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        difficultyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        this.add(difficultyLabel);

        ButtonGroup difficultyGroup = new ButtonGroup();

        easyRadioButton = new JRadioButton("Facil");
        easyRadioButton.setSelected(true);
        easyRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
        easyRadioButton.addActionListener(this);
        difficultyGroup.add(easyRadioButton);
        this.add(easyRadioButton);

        mediumRadioButton = new JRadioButton("Medio");
        mediumRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
        mediumRadioButton.addActionListener(this);
        difficultyGroup.add(mediumRadioButton);
        this.add(mediumRadioButton);

        hardRadioButton = new JRadioButton("Dificil");
        hardRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
        hardRadioButton.addActionListener(this);
        difficultyGroup.add(hardRadioButton);
        this.add(hardRadioButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyRadioButton) {
            mainInterface.dificultad = 3;
            System.out.println("Se colocó la dificultad: fácil");
        } else if (e.getSource() == mediumRadioButton) {
            mainInterface.dificultad = 5;
            System.out.println("Se colocó la dificultad: medio");
        } else if (e.getSource() == hardRadioButton) {
            mainInterface.dificultad = 7;
            System.out.println("Se colocó la dificultad: difícil");
        } else if (e.getSource() == sizeComboBox) {
            int index = sizeComboBox.getSelectedIndex();
            if (index == 0) {
                mainInterface.tamano = 5;
            } else if (index == 1) {
                mainInterface.tamano = 7;
            } else if (index == 2) {
                mainInterface.tamano = 9;
            }
        }
    }
}
