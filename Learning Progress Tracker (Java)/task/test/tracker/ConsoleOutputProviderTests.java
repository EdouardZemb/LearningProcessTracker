package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ConsoleOutputProvider Tests")
public class ConsoleOutputProviderTests {

    @Test
    @DisplayName("ConsoleOutputProvider print() should correctly print the message")
    public void consoleOutputProviderPrint() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of ConsoleOutputProvider
        OutputProvider outputProvider = new ConsoleOutputProvider();

        // Call the print() method
        String message = "Test Message";
        outputProvider.print(message);

        // Restore the standard output
        System.setOut(System.out);

        // Verify the output
        String actualOutput = outputStream.toString().trim();
        assertEquals(message, actualOutput);
    }

    // Additional test cases for ConsoleOutputProvider can be added here
}