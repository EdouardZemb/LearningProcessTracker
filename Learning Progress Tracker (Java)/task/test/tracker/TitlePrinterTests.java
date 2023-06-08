package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TitlePrinter Tests")
public class TitlePrinterTests {

    @Test
    @DisplayName("TitlePrinter printTitle() should correctly print the title")
    public void titlePrinterPrintTitle() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of TitlePrinter
        OutputProvider outputProvider = new ConsoleOutputProvider();
        TitlePrinter titlePrinter = new TitlePrinter(outputProvider);

        // Call the printTitle() method
        titlePrinter.printTitle();

        // Restore the standard output
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Learning Progress Tracker";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    // Additional test cases for TitlePrinter can be added here
}
