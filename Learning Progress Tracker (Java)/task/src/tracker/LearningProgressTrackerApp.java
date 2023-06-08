package tracker;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;
    private final UserInputHandler userInputHandler;

    public LearningProgressTrackerApp(OutputProvider outputProvider, UserInputHandler userInputHandler) {
        this.outputProvider = outputProvider;
        this.userInputHandler = userInputHandler;
    }

    public void run() {
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);
        titlePrinter.printTitle();

        userInputHandler.handleUserInput();
    }
}
