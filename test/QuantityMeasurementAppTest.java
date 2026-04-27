import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    @Test
    void testFeet_SameValue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeet_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeet_NullComparison() {
        QuantityMeasurementApp.Feet value = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(value, null);
    }

    @Test
    void testFeet_NonNumericInput() {
        QuantityMeasurementApp.Feet value = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(value, "1.0");
    }

    @Test
    void testFeet_SameReference() {
        QuantityMeasurementApp.Feet value = new QuantityMeasurementApp.Feet(1.0);
        assertEquals(value, value);
    }

    // ---------- INCHES TESTS ----------

    @Test
    void testInches_SameValue() {
        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }

    @Test
    void testInches_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }

    @Test
    void testInches_NullComparison() {
        QuantityMeasurementApp.Inches value = new QuantityMeasurementApp.Inches(1.0);
        assertNotEquals(value, null);
    }

    @Test
    void testInches_NonNumericInput() {
        QuantityMeasurementApp.Inches value = new QuantityMeasurementApp.Inches(1.0);
        assertNotEquals(value, "1.0");
    }

    @Test
    void testInches_SameReference() {
        QuantityMeasurementApp.Inches value = new QuantityMeasurementApp.Inches(1.0);
        assertEquals(value, value);
    }
}