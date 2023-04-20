package userInterface;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

import java.awt.*;
import java.util.Collection;

public class ShowTopTen extends JFrame {
    private static final long serialVersionUID = 1L;
	private JList<miniTopTen> lista;

    public ShowTopTen() {
        super("Top 10");
        setSize(300, 200);
        setLocationRelativeTo(null);
        Collection<RegistroTop10> top10Bien = mainInterface.top10.darRegistros();
        DefaultListModel<miniTopTen> modelo = new DefaultListModel<>();
        int topNum = 1;
        for (RegistroTop10 elemento : top10Bien) {
            miniTopTen panelcito = new miniTopTen(topNum, elemento.darNombre(), elemento.darPuntos());
            if (topNum == 1) {
                panelcito.setBackground(Color.BLUE);
                panelcito.setForeground(Color.WHITE);
            } else if (topNum < 4) {
                panelcito.setBackground(Color.WHITE);
                panelcito.setForeground(Color.RED);
            }
            modelo.addElement(panelcito);
            topNum += 1;
        }
        lista = new JList<>(modelo);
        lista.setCellRenderer(new RenderizadorLista());

        JScrollPane scroll = new JScrollPane(lista);

        Container panel = getContentPane();
        panel.setLayout(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    private class RenderizadorLista extends JPanel implements ListCellRenderer<miniTopTen> {
        private static final long serialVersionUID = 1L;
		private JLabel label1 = new JLabel();
        private JLabel label2 = new JLabel();
        private JLabel label3 = new JLabel();

        public RenderizadorLista() {
            setLayout(new GridLayout(1, 3));
            add(label1);
            add(label2);
            add(label3);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends miniTopTen> list, miniTopTen value, int index,
                boolean isSelected, boolean cellHasFocus) {
            label1.setText(String.valueOf(value.getNum()) + ")");
            label2.setText(value.getNombre());
            label3.setText(String.valueOf(value.getPuntaje()));

            setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);

            return this;
        }
    }
}