package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        InputProvider inputProvider = new SystemInputProvider();
        UserInputHandler userInputHandler = new UserInputHandler(inputProvider, outputProvider);
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, userInputHandler);

        app.run();
    }
}
