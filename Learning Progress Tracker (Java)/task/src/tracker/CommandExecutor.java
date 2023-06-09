package tracker;

public interface CommandExecutor {
    void handleBlankInput();

    void executeCommand(Command command) throws ExitProgramException;

    void handleUnrecognizedCommand(String input);
}
