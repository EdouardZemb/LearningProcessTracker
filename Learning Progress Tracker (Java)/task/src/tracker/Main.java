package tracker;

public class Main {
    public static void main(String[] args) {
        OutputProvider outputProvider = new ConsoleOutputProvider();
        InputProvider inputProvider = new SystemInputProvider();
        CommandRegistry defaultCommandRegistry = new CommandRegistry();
        Command addStudentCommand = new AddStudentCommand(outputProvider);
        Command exitCommand = new ExitCommand(outputProvider);
        addStudentCommand.register(defaultCommandRegistry);
        exitCommand.register(defaultCommandRegistry);
        CommandExecutor commandExecutor = new DefaultCommandExecutor(outputProvider);
        UserInputHandler userInputHandler = new UserInputHandler(inputProvider, defaultCommandRegistry, commandExecutor);
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, userInputHandler);

        app.run();
    }
}
