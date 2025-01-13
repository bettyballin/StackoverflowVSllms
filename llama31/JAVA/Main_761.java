public class Main_761 {
    public static void main(String[] args) {
        PaddedStringBuilder query = new PaddedStringBuilder();
        query.append("SELECT").append("FROM").append("table_name");
        System.out.println(query.toString()); // Output: "SELECT FROM table_name"
    }
}

class PaddedStringBuilder {
    private StringBuilder sb;

    public PaddedStringBuilder() {
        this.sb = new StringBuilder();
    }

    public PaddedStringBuilder append(String str) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(str);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}