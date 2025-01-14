import java.lang.String;
public class ShippingStatusHandler {
    public enum UpsShippableStatus {
        YES('Y'),
        NO('N'),
        GREEN('G');

        private final char dbValue;

        UpsShippableStatus(char dbValue) {
            this.dbValue = dbValue;
        }

        public static UpsShippableStatus fromDbChar(char value) {
            for (UpsShippableStatus status : values()) {
                if (status.dbValue == value) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Unknown UPS shippable status: " + value);
        }
    }

    public String getShippingLabel(UpsShippableStatus status) {
        switch (status) {
            case YES:
                return "Shippable via UPS";
            case NO:
            case GREEN: // Assuming G and N mean similar in your business logic
                return "Not shippable via UPS";
            default:
                throw new IllegalStateException("Unexpected ups shippable status: " + status);
        }
    }
    public static void main(String[] args) {
    }
}