package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider);
        app.run();
    }
}
