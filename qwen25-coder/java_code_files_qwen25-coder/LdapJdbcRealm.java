package com.example;

import java.util.List;
import java.util.ArrayList;

import org.apache.catalina.Realm;
import org.apache.catalina.deploy.SecurityConstraint;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.realm.JNDIRealm;
import org.apache.catalina.LifecycleException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// For logging
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class LdapJdbcRealm extends JNDIRealm implements Realm {
    private DataSource dataSource;
    private static final Log log = LogFactory.getLog(LdapJdbcRealm.class);
    private String dbJndiName;

    public void setName(String name) {
        // Implement if necessary
    }

    @Override
    protected String getName() {
        return "LdapJdbcRealm";
    }

    @Override
    public Principal authenticate(String username, String credentials) {
        // Authenticate using LDAP
        Principal principal = super.authenticate(username, credentials);
        if (principal != null) {
            // If authentication is successful, get roles from JDBC
            List<String> roles = getUserRolesFromJdbc(principal.getName());
            return new GenericPrincipal(principal.getName(), credentials, roles);
        }
        return null;
    }

    private List<String> getUserRolesFromJdbc(String username) {
        List<String> roles = new ArrayList<>();
        String sql = "SELECT role_name FROM db_user_role_xref WHERE user_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                roles.add(rs.getString("role_name"));
            }
        } catch (SQLException e) {
            // Handle exception
            log.error("Failed to retrieve user roles from JDBC", e);
        }

        return roles;
    }

    @Override
    public void startInternal() throws LifecycleException {
        super.startInternal();
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup(getDbJndiName());
        } catch (NamingException e) {
            throw new LifecycleException("Failed to look up JDBC DataSource", e);
        }
    }

    public void setDbJndiName(String dbJndiName) {
        this.dbJndiName = dbJndiName;
    }

    public String getDbJndiName() {
        return this.dbJndiName;
    }

    public static void main(String[] args) {
    }
}