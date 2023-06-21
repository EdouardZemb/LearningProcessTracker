package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("FirstName Tests")
public class FirstNameTests {

    @Test
    @DisplayName("Test Valid First Name")
    public void testValidFirstName() {
        Assertions.assertDoesNotThrow(() -> new FirstName("John"));
    }

    @Test
    @DisplayName("Test Invalid First Name")
    public void testInvalidFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FirstName("123"));
    }
}
