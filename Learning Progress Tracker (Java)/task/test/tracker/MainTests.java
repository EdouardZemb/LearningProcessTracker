package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Main Tests")
public class MainTests {

    private static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile("\\R");

    @Test
    @DisplayName("Main main() should initialize and run LearningProgressTrackerApp")
    public void mainInitializeAndRunLearningProgressTrackerApp() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Set the input to simulate user interaction
        String input = "exit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Call the main() method
        Main.main(null);

        // Restore the standard output and input
        System.setOut(System.out);
        System.setIn(System.in);

        // Verify the output
        String expectedOutput = "Learning Progress Tracker\nBye!";

        // Normalize line separators
        expectedOutput = normalizeLineSeparators(expectedOutput);
        String actualOutput = normalizeLineSeparators(outputStream.toString().trim());
        assertEquals(expectedOutput, actualOutput);
    }

    // Additional test cases for Main class can be added here

    private static String normalizeLineSeparators(String text) {
        return LINE_SEPARATOR_PATTERN.matcher(text).replaceAll("\n");
    }
}
