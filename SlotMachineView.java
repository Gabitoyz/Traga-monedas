/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo.com.app.mvc.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SlotMachineView extends JFrame {
    private JLabel reel1Label, reel2Label, reel3Label;
    private JButton spinButton;
    private JLabel resultLabel, balanceLabel;

    public SlotMachineView() {
        setTitle("Juego de Tragamonedas");
        setLayout(new BorderLayout());

        // Panel de rodillos
        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        reel1Label = new JLabel("🍒", SwingConstants.CENTER);
        reel2Label = new JLabel("🍋", SwingConstants.CENTER);
        reel3Label = new JLabel("🔔", SwingConstants.CENTER);

        // Establecer el tamaño de la fuente para los símbolos
        reel1Label.setFont(new Font("Serif", Font.PLAIN, 48));
        reel2Label.setFont(new Font("Serif", Font.PLAIN, 48));
        reel3Label.setFont(new Font("Serif", Font.PLAIN, 48));

        // Asignar colores a cada símbolo
        reel1Label.setForeground(Color.RED); // Para el símbolo de la cereza 🍒
        reel2Label.setForeground(Color.YELLOW); // Para el símbolo del limón 🍋
        reel3Label.setForeground(Color.GREEN); // Para el símbolo de la campana 🔔

        // Agregar los símbolos a los paneles
        reelsPanel.add(reel1Label);
        reelsPanel.add(reel2Label);
        reelsPanel.add(reel3Label);

        add(reelsPanel, BorderLayout.CENTER);

        // Botón para girar
        spinButton = new JButton("Girar");
        add(spinButton, BorderLayout.SOUTH);

        // Resultado y saldo
        resultLabel = new JLabel("¡Haz tu apuesta!", SwingConstants.CENTER);
        balanceLabel = new JLabel("Saldo: $0", SwingConstants.CENTER); // Saldo inicial predeterminado
        add(resultLabel, BorderLayout.NORTH);
        add(balanceLabel, BorderLayout.EAST);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int promptInitialBalance() {
        String input = JOptionPane.showInputDialog(this, "Introduce tu saldo inicial:", "Saldo Inicial", JOptionPane.PLAIN_MESSAGE);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return promptInitialBalance();
        }
    }

    public int promptNewBalance() {
        String input = JOptionPane.showInputDialog(this, "Saldo insuficiente. Introduce un nuevo saldo:", "Nuevo Saldo", JOptionPane.PLAIN_MESSAGE);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return promptNewBalance();
        }
    }

    public JButton getSpinButton() {
        return spinButton;
    }

    public void updateReels(List<String> symbols) {
        reel1Label.setText(symbols.get(0));
        reel2Label.setText(symbols.get(1));
        reel3Label.setText(symbols.get(2));

        // Reasignar colores a cada símbolo cuando se actualicen
        reel1Label.setForeground(Color.RED); // Cereza 🍒
        reel2Label.setForeground(Color.YELLOW); // Limón 🍋
        reel3Label.setForeground(Color.GREEN); // Campana 🔔
    }

    public void updateResult(String result, int balance) {
        resultLabel.setText(result);
        balanceLabel.setText("Saldo: $" + balance);
    }
}
