package Controllers;


import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;
    private final UserInterface ui;

    public InputHandler(UserInterface ui) {
        this.ui = ui;

        sc = new Scanner(System.in);
    }

    public int intInput(List<Integer> allowedInputs) {
        int input = 0;
        do {
            String choice = sc.next();
            try {
                input = Integer.parseInt(choice);

                if (!allowedInputs.contains(input)) {
                    System.out.println("Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                ui.HandleNumberFormatException();
            }
        } while (input == 0 || !allowedInputs.contains(input));

        return input;
    }

    public String strInput() {
        return sc.next();
    }
}
