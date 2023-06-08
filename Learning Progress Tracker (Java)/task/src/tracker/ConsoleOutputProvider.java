package tracker;

public class ConsoleOutputProvider implements OutputProvider {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
