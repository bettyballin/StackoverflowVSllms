public class EscapeUnderscoreInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        if (sql != null) {
            return sql.replace("LIKE '", "LIKE '[_]'");
        }
        return super.onPrepareStatement(sql);
    }

    // Override other methods as needed

    public static void main(String[] args) {
        // You can test the onPrepareStatement method here if you want.
    }
}

class EmptyInterceptor {
    public String onPrepareStatement(String sql) {
        return sql;
    }
}