package tracker;

public interface UserInputHandler {
    void handleUserInput();

    void handleBlankInput();

    void handleUnrecognizedInput();

    String getInput();
}
