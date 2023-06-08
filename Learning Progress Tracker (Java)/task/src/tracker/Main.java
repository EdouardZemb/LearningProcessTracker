package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        InputProvider inputProvider = new SystemInputProvider();
        CommandRegistry commandRegistry = new CommandRegistry(outputProvider);
        UserInputHandler userInputHandler = new UserInputHandler(inputProvider, commandRegistry);
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, userInputHandler);

        app.run();
    }
}
