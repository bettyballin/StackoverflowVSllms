import java.lang.String;
import java.lang.Integer;

public class Point_1 {
    private final int x;
    private final int y;

    private Point_1(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
    }

    public static Builder newPoint() {
        return new Builder();
    }

    public static class Builder {
        private Integer x;
        private Integer y;

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Point_1 build() {
            if (x == null || y == null) {
                throw new IllegalArgumentException("Both x and y must be set");
            }
            return new Point_1(this);
        }
    }

    public static void main(String[] args) {
    }
}