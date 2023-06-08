package tracker;

public class UserInputHandler {
    private final InputProvider inputProvider;
    private final OutputProvider outputProvider;

    public UserInputHandler(InputProvider inputProvider, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
    }

    public void handleUserInput() {
        while (true) {
            String input = inputProvider.getInput();

            if (input.equals("exit")) {
                outputProvider.print("Bye!");
                break;
            }
        }
    }
}
