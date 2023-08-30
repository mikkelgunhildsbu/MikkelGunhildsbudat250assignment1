package dat250exp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testFeetToMetersConversion() {
        double feetValue = 10.0;
        double expectedMetersValue = feetValue * 0.4048;

        double actualMetersValue = App.feetToMeters(feetValue);

        assertEquals(expectedMetersValue, actualMetersValue, 0.001);
    }

    @Test
    void testInchesToMetersConversion() {
        double inhesvalue = 10.0;
        double expectedMetersValue = inhesvalue * 0.0254;

        double actualMetersValue = App.inchesToMeters(feetValue);

        assertEquals(expectedMetersValue, actualMetersValue, 0.001);


    }

}
