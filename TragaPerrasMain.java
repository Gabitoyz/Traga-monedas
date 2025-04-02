/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pablo.com.app.mvc.view;

/**
 *
 * @author pdiaz
 */

import pablo.com.app.mvc.view.SlotMachineController;
public class TragaPerrasMain {
    public static void main(String[] args) {
        SlotMachineView view = new SlotMachineView();
        int initialBalance = view.promptInitialBalance(); // Pedir saldo inicial al usuario
        SlotMachine model = new SlotMachine(initialBalance);
        new SlotMachineController(model, view);
    }
}