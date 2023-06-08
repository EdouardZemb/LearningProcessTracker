package tracker;

import java.util.Scanner;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;

    public LearningProgressTrackerApp(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void run() {
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);
        titlePrinter.printTitle();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String next = scanner.next();

                if (next.equals("exit")) {
                    outputProvider.print("Bye!");
                    System.exit(0);
                }
            }
        }
    }
}
