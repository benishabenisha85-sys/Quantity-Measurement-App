import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class QuantityLengthConversionTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                1.0,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                24.0,
                QuantityMeasurementApp.LengthUnit.INCH,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARD,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(36.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToYards() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                72.0,
                QuantityMeasurementApp.LengthUnit.INCH,
                QuantityMeasurementApp.LengthUnit.YARD
        );

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                2.54,
                QuantityMeasurementApp.LengthUnit.CENTIMETER,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(1.0, result, 1e-4); // slightly higher tolerance
    }

    @Test
    void testConversion_FeetToYard() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                6.0,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.YARD
        );

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_RoundTrip_PreservesValue() {
        double value = 5.0;

        double converted = QuantityMeasurementApp.QuantityLength.convert(
                value,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        double back = QuantityMeasurementApp.QuantityLength.convert(
                converted,
                QuantityMeasurementApp.LengthUnit.INCH,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertEquals(value, back, EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                0.0,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                -1.0,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.QuantityLength.convert(
                    1.0,
                    null,
                    QuantityMeasurementApp.LengthUnit.FEET
            );
        });
    }

    @Test
    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.QuantityLength.convert(
                    Double.NaN,
                    QuantityMeasurementApp.LengthUnit.FEET,
                    QuantityMeasurementApp.LengthUnit.INCH
            );
        });

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.QuantityLength.convert(
                    Double.POSITIVE_INFINITY,
                    QuantityMeasurementApp.LengthUnit.FEET,
                    QuantityMeasurementApp.LengthUnit.INCH
            );
        });
    }

    @Test
    void testConversion_PrecisionTolerance() {
        double result = QuantityMeasurementApp.QuantityLength.convert(
                1.0,
                QuantityMeasurementApp.LengthUnit.CENTIMETER,
                QuantityMeasurementApp.LengthUnit.INCH
        );

        assertEquals(0.3937, result, 1e-4);
    }
}