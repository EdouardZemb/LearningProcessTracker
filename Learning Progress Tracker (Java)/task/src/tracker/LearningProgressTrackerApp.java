package tracker;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;

    public LearningProgressTrackerApp(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void run() {
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);
        titlePrinter.printTitle();
    }
}
