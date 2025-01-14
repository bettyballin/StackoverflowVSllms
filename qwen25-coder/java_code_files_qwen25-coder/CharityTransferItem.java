import java.io.Serializable;

public class CharityTransferItem implements Serializable {
    private Long transferNumber;
    private String item;
    // Other fields...

    public static class Id implements Serializable {
        private Long transferNumber;
        private String item;

        // Getters and setters...
        public Long getTransferNumber() {
            return transferNumber;
        }

        public void setTransferNumber(Long transferNumber) {
            this.transferNumber = transferNumber;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        // Override equals and hashCode methods for composite key
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;

            Id id = (Id) o;

            if (transferNumber != null ? !transferNumber.equals(id.transferNumber) : id.transferNumber != null)
                return false;
            return item != null ? item.equals(id.item) : id.item == null;
        }

        @Override
        public int hashCode() {
            int result = transferNumber != null ? transferNumber.hashCode() : 0;
            result = 31 * result + (item != null ? item.hashCode() : 0);
            return result;
        }
    }

    // Getters, setters, and other methods...
    public Long getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(Long transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

	public static void main(String[] args) {
		// Application entry point
	}
}