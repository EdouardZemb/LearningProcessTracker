package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LastName Tests")
public class LastNameTests {

    @Test
    @DisplayName("Test Valid Last Name")
    public void testValidLastName() {
        Assertions.assertDoesNotThrow(() -> new LastName("Smith"));
    }

    @Test
    @DisplayName("Test Invalid Last Name")
    public void testInvalidLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LastName("123"));
    }
}
