public enum DealType {
    BASE("Base"), EXTRA("Extra");

    private final String value;

    DealType(String value) { this.value = value; }

    public String getValue() { return value; }
}