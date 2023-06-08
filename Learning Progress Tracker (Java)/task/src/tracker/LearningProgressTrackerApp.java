package tracker;

public class LearningProgressTrackerApp {
    private final OutputProvider outputProvider;

    public LearningProgressTrackerApp(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void run() {
        outputProvider.print("Learning Progress Tracker");
    }
}
