package tracker;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;
    private final InputProvider inputProvider;

    public LearningProgressTrackerApp(OutputProvider outputProvider, InputProvider inputProvider) {
        this.outputProvider = outputProvider;
        this.inputProvider = inputProvider;
    }

    public void run() {
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);
        titlePrinter.printTitle();

        while (true) {
            String input = inputProvider.getInput();

            if (input.equals("exit")) {
                outputProvider.print("Bye!");
                break;
            }
        }
    }
}
