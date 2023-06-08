package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Main Tests")
public class MainTests {

    @Test
    @DisplayName("Main main() should initialize and run LearningProgressTrackerApp")
    public void mainInitializeAndRunLearningProgressTrackerApp() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main() method
        Main.main(null);

        // Restore the standard output
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Learning Progress Tracker";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    // Additional test cases for Main class can be added here
}
