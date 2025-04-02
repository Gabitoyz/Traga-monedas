/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo.com.app.mvc.view;
import java.util.ArrayList;
import java.util.List;
import pablo.com.app.mvc.view.SlotMachine;
import pablo.com.app.mvc.view.SlotMachineView;

public class SlotMachineController {
    private SlotMachine model;
    private SlotMachineView view;
    private final Object lock = new Object(); // Monitor para sincronización

    public SlotMachineController(SlotMachine model, SlotMachineView view) {
        this.model = model;
        this.view = view;

        view.getSpinButton().addActionListener(e -> startGame());
    }

    private void startGame() {
        int bet = 10; // Apuesta fija como ejemplo

        Thread gameLogicThread = new Thread(() -> {
            synchronized (lock) {
                // Verificar si el saldo actual es suficiente para apostar
                if (model.getPlayerBalance() < bet) {
                    int newBalance = view.promptNewBalance();
                    model.addBalance(newBalance); // Actualizar el saldo del jugador
                    view.updateResult("Nuevo saldo agregado.", model.getPlayerBalance());
                }

                String symbol1 = model.spinReel();
                String symbol2 = model.spinReel();
                String symbol3 = model.spinReel();

                int reward = model.calculateReward(symbol1, symbol2, symbol3, bet);
                model.updateBalance(reward, bet);

                List<String> finalSymbols = List.of(symbol1, symbol2, symbol3);

                synchronized (lock) {
                    view.updateReels(finalSymbols);

                    if (reward > 0) {
                        view.updateResult("¡Ganaste $" + reward + "!", model.getPlayerBalance());
                    } else {
                        view.updateResult("¡Inténtalo de nuevo!", model.getPlayerBalance());
                    }
                }
            }
        });

        Thread uiAnimationThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    List<String> spinningSymbols = List.of("🍒", "🍋", "🔔", "🍉", "⭐", "7️⃣");
                    for (int i = 0; i < 15; i++) { // Animación de 15 ciclos
                        List<String> currentSymbols = new ArrayList<>();
                        for (int j = 0; j < 3; j++) {
                            int index = (i + j) % spinningSymbols.size();
                            currentSymbols.add(spinningSymbols.get(index));
                        }

                        view.updateReels(currentSymbols);
                        Thread.sleep(50); // Control de la velocidad
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.err.println("Hilo de animación interrumpido: " + ex.getMessage());
                }
            }
        });

        uiAnimationThread.start();
        gameLogicThread.start();
    }
}