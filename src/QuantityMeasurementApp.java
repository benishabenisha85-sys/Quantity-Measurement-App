public class QuantityMeasurementApp {

    // Enum (base = FEET)
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.0328084); // 1 cm = 0.0328084 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    //  Generic Quantity Class
    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            // Epsilon comparison (fix for precision issue)
            double diff = Math.abs(this.toFeet() - other.toFeet());
            return diff < 0.0001;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Demo
    public static void main(String[] args) {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println("1 yard == 3 feet → " + q1.equals(q2));

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength q4 = new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println("1 cm == 0.393701 inch → " + q3.equals(q4));
    }
}