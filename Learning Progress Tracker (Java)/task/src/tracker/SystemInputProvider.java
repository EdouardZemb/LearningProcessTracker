package tracker;

import java.util.Scanner;

public class SystemInputProvider implements InputProvider {
    private final Scanner scanner;

    public SystemInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}