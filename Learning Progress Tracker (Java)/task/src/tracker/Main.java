package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        InputProvider inputProvider = new SystemInputProvider();
        CommandRegistry commandRegistry = new CommandRegistry(outputProvider);
        CommandExecutor commandExecutor = new DefaultCommandExecutor(outputProvider);
        UserInputHandler userInputHandler = new UserInputHandler(inputProvider, commandRegistry, commandExecutor);
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, userInputHandler);

        app.run();
    }
}
