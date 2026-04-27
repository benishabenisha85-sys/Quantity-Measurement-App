public class QuantityMeasurementApp {

    // Enum (Base = FEET)
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(1.0 / 30.48);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    //  Quantity Class
    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        //  Conversion Method (UC5)
        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double baseValue = this.toFeet(); // convert to feet
            return targetUnit.fromFeet(baseValue); // convert to target
        }

        //  Static conversion API
        public static double convert(double value, LengthUnit from, LengthUnit to) {
            if (from == null || to == null)
                throw new IllegalArgumentException("Units cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            double base = from.toFeet(value);
            return to.fromFeet(base);
        }

        //  equals (with epsilon)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(this.toFeet() - other.toFeet()) < 1e-5;
        }

        @Override
        public int hashCode() {
            long rounded = Math.round(this.toFeet() * 100000);
            return Long.hashCode(rounded);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    //  Demo Methods (Overloading)

    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = QuantityLength.convert(value, from, to);
        System.out.println(value + " " + from + " = " + result + " " + to);
    }

    public static void demonstrateLengthConversion(QuantityLength q, LengthUnit to) {
        double result = q.convertTo(to);
        System.out.println(q + " = " + result + " " + to);
    }

    public static void demonstrateLengthEquality(QuantityLength q1, QuantityLength q2) {
        System.out.println(q1 + " == " + q2 + " → " + q1.equals(q2));
    }

    // Main
    public static void main(String[] args) {

        demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCH);

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        demonstrateLengthConversion(yard, LengthUnit.INCH);

        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength inch = new QuantityLength(0.393700787, LengthUnit.INCH);

        demonstrateLengthEquality(cm, inch);
    }
}