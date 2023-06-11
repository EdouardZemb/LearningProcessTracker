package tracker;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;
    private final DefaultUserInputHandler defaultUserInputHandler;

    public LearningProgressTrackerApp(OutputProvider outputProvider, DefaultUserInputHandler defaultUserInputHandler) {
        this.outputProvider = outputProvider;
        this.defaultUserInputHandler = defaultUserInputHandler;
    }

    public void run() {
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);
        titlePrinter.printTitle();

        defaultUserInputHandler.handleUserInput();
    }
}
