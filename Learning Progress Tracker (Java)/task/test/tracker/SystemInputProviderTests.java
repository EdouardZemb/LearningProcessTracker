package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("SystemInputProvider Tests")
public class SystemInputProviderTests {

    @Test
    @DisplayName("getInput() returns user input")
    void testGetInputReturnsUserInput() {
        String expectedInput = "test input";
        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        SystemInputProvider inputProvider = new SystemInputProvider();
        String actualInput = inputProvider.getInput();

        assertEquals(expectedInput, actualInput);
        System.setIn(System.in); // Reset System.in to its original state
    }
}
