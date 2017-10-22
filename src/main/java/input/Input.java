package input;

import java.util.Scanner;

public class Input {
    public String readLineFromConsole() {
        Scanner scanner = new Scanner(System.in);

        String lineContent = scanner.nextLine();

        scanner.close();

        return lineContent;
    }
}
