import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
   // -------- YARD TESTS --------

    @Test
    void testEquality_YardToYard_SameValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    // -------- CENTIMETER TESTS --------

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        var q2 = new QuantityMeasurementApp.QuantityLength(0.393700787, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    // -------- TRANSITIVE PROPERTY --------

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        var yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        var inch = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    // -------- NULL & EDGE CASES --------

    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
    }

    @Test
    void testEquality_YardSameReference() {
        var q = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(q, q);
    }

    @Test
    void testEquality_YardNullComparison() {
        var q = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertNotEquals(q, null);
    }

    @Test
    void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
    }

    @Test
    void testEquality_CentimetersSameReference() {
        var q = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);

        assertEquals(q, q);
    }

    @Test
    void testEquality_CentimetersNullComparison() {
        var q = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);

        assertNotEquals(q, null);
    }

    // -------- COMPLEX SCENARIO --------

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        var yard = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        var feet = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.FEET);
        var inch = new QuantityMeasurementApp.QuantityLength(72.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }
}