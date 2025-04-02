/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo.com.app.mvc.view;

/**
 *
 * @author pdiaz
 */
public class SlotMachine {
    private int playerBalance;
    private String[] symbols = {"🍒", "🍋", "🔔", "🍉", "⭐", "7️⃣"};

    public SlotMachine(int initialBalance) {
        this.playerBalance = initialBalance;
    }

    public String spinReel() {
        return symbols[(int) (Math.random() * symbols.length)];
    }

    public int calculateReward(String symbol1, String symbol2, String symbol3, int bet) {
        if (symbol1.equals(symbol2) && symbol2.equals(symbol3)) {
            switch (symbol1) {
                case "🍒": return bet * 2;
                case "🍋": return bet * 3;
                case "🔔": return bet * 5;
                case "🍉": return bet * 6;
                case "⭐": return bet * 10;
                case "7️⃣": return bet * 20;
                default: return 0;
            }
        }
        return 0;
    }

    public void updateBalance(int reward, int bet) {
        playerBalance += (reward - bet);
    }

    public void addBalance(int amount) {
        playerBalance += amount;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }
}