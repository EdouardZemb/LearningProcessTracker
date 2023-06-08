package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        InputProvider inputProvider = new SystemInputProvider();
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, inputProvider);
        app.run();
    }
}
