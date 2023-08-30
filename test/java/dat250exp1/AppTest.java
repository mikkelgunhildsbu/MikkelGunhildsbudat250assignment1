package dat250exp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testFeetToMetersConversion() {
        double feetValue = 10.0;
        double expectedMetersValue = feetValue * 0.3048;

        double actualMetersValue = App.feetToMeters(feetValue);

        assertEquals(expectedMetersValue, actualMetersValue, 0.001);
    }

    @Test
    void testInchesToMetersConversion() {
        // Add similar test cases for other conversions
    }

    // Add more test methods as needed
}
