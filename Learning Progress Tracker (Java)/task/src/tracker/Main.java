package tracker;

public class Main {
    private final OutputProvider outputProvider;
    private final InputProvider inputProvider;
    private final CommandRegistry commandRegistry;
    private final LearningProgressTrackerApp app;

    public Main(OutputProvider outputProvider,
                InputProvider inputProvider, CommandRegistry commandRegistry,
                LearningProgressTrackerApp app) {
        this.outputProvider = outputProvider;
        this.inputProvider = inputProvider;
        this.commandRegistry = commandRegistry;
        this.app = app;
    }

    private void registerCommands() {
        CommandRegistry addStudentCommandRegistry = new CommandRegistry();
        Command backCommand = new BackCommand(outputProvider);
        backCommand.register(addStudentCommandRegistry);
        StudentRepository studentRepository = new StudentRepository();
        Command addStudentCommand = new AddStudentsCommand(outputProvider, inputProvider, studentRepository);
        Command exitCommand = new ExitCommand(outputProvider);
        Command listCommand = new ListCommand(outputProvider, studentRepository);
        PointsInputHandler pointsInputHandler = new PointsInputHandler(inputProvider, outputProvider, studentRepository);
        Command addPointsCommand = new AddPointsCommand(outputProvider, pointsInputHandler);
        Command findCommand = new FindCommand(outputProvider, inputProvider, studentRepository);
        Command UnhandledBackCommand = new UnhandledBackCommand(outputProvider);
        addStudentCommand.register(commandRegistry);
        exitCommand.register(commandRegistry);
        listCommand.register(commandRegistry);
        addPointsCommand.register(commandRegistry);
        findCommand.register(commandRegistry);
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

        Main main = new Main(outputProvider, inputProvider, commandRegistry, app);
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

