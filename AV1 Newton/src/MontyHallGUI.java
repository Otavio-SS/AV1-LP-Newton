import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MontyHallGUI extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;

    public MontyHallGUI() {
        super("Porta dos Desesperados");

        label = new JLabel("PORTA DOS DESESPERADOS!!!");
        label.setBounds(50, 20, 200, 30);
        add(label);

        button = new JButton("Jogar");
        button.setBounds(100, 70, 100, 30);
        button.addActionListener(this);
        add(button);

        setSize(300, 150);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Random r = new Random();
            int minimo = 1;
            int maximo = 3;
            int portaPremiada = r.nextInt(maximo - minimo) + minimo;
            int portaEscolhida = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma porta de 1 a 3"));
            int portaVazia;

            do {
                portaVazia = r.nextInt(maximo - minimo) + minimo;
            } while (portaPremiada == portaVazia || portaVazia == portaEscolhida);

            int resposta = JOptionPane.showConfirmDialog(null, "O apresentador abriu a porta " + portaVazia + " e ela estava vazia, deseja trocar a sua porta escolhida?");

            if (resposta == JOptionPane.YES_OPTION && portaEscolhida == portaPremiada) {
                JOptionPane.showMessageDialog(null, "Você perdeu! A porta premiada era: " + portaPremiada);
            } else if (resposta == JOptionPane.YES_OPTION && portaEscolhida != portaPremiada) {
                JOptionPane.showMessageDialog(null, "Você venceu!!!");
            } else if (portaEscolhida == portaPremiada) {
                JOptionPane.showMessageDialog(null, "Você venceu!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Você perdeu! A porta premiada era: " + portaPremiada);
            }
            JOptionPane.showMessageDialog(null, "Porta Escolhida: " +portaEscolhida+ " Porta premiada: " +portaPremiada+ " Porta vazia: " +portaVazia);
        }
    }

    public static void main(String[] args) {
        new MontyHallGUI();
    }
}
