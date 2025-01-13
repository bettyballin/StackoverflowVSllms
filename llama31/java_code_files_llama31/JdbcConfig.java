/*
 * Decompiled with CFR 0.152.
 */
public class JdbcConfig {
    private String url;
    private String username;
    private String password;
    private String tnsAdmin;

    public JdbcConfig(String string, String string2, String string3, String string4) {
        this.url = string;
        this.username = string2;
        this.password = string3;
        this.tnsAdmin = string4;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getTnsAdmin() {
        return this.tnsAdmin;
    }

    public static void main(String[] stringArray) {
        JdbcConfig jdbcConfig = new JdbcConfig("jdbc:oracle:thin:@MYDB", "user", "pass", "/path/to/tnsnames.ora");
        System.out.println("URL: " + jdbcConfig.getUrl());
        System.out.println("Username: " + jdbcConfig.getUsername());
        System.out.println("Password: " + jdbcConfig.getPassword());
        System.out.println("TNS Admin: " + jdbcConfig.getTnsAdmin());
    }
}
