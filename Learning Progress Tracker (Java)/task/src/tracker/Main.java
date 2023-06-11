package tracker;

public class Main {
    private final OutputProvider outputProvider;
    private final CommandRegistry commandRegistry;
    private final LearningProgressTrackerApp app;

    public Main(OutputProvider outputProvider,
                CommandRegistry commandRegistry,
                LearningProgressTrackerApp app) {
        this.outputProvider = outputProvider;
        this.commandRegistry = commandRegistry;
        this.app = app;
    }

    private void registerCommands() {
        CommandRegistry addStudentCommandRegistry = new CommandRegistry();
        Command backCommand = new BackCommand(outputProvider);
        backCommand.register(addStudentCommandRegistry);
        Command addStudentCommand = new AddStudentCommand(outputProvider);
        Command exitCommand = new ExitCommand(outputProvider);
        Command UnhandledBackCommand = new UnhandledBackCommand(outputProvider);
        addStudentCommand.register(commandRegistry);
        exitCommand.register(commandRegistry);
        UnhandledBackCommand.register(commandRegistry);
    }

    public void run() {
        registerCommands();
        app.run();
    }

    public static void main(String[] args) {
        OutputProvider outputProvider = createOutputProvider();
        InputProvider inputProvider = createInputProvider();
        CommandRegistry commandRegistry = createCommandRegistry();
        CommandExecutor commandExecutor = new DefaultCommandExecutor(outputProvider);
        UserInputHandler defaultUserInputHandler = new DefaultUserInputHandler(inputProvider, commandRegistry, commandExecutor);
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider, defaultUserInputHandler);

        Main main = new Main(outputProvider, commandRegistry, app);
        main.run();
    }

    private static OutputProvider createOutputProvider() {
        return new ConsoleOutputProvider();
    }

    private static InputProvider createInputProvider() {
        return new SystemInputProvider();
    }

    private static CommandRegistry createCommandRegistry() {
        return new CommandRegistry();
    }
}

