import java.security.Principal;
import java.util.Enumeration;

import org.apache.catalina.realm.GenericPrincipal;

public class Main_704 {
    public static void main(String[] args) {
        // Assuming you have a HttpServletRequest object named 'request'
        // For demonstration purposes, we will create a mock GenericPrincipal object
        GenericPrincipal principal = new GenericPrincipal("username", "password", new String[] {"role1", "role2"}, 
            new java.util.HashMap<String, String[]>() {{
                put("displayName", new String[] {"John Doe"});
            }}
        );

        if (principal instanceof GenericPrincipal) {
            GenericPrincipal gp = (GenericPrincipal) principal;
            Enumeration<String> attribs = gp.getAttributes().getAttributeNames();
            while (attribs.hasMoreElements()) {
                String attribName = attribs.nextElement();
                String[] attribValues = gp.getAttributes().getAttributeValues(attribName);
                if (attribName.equals("displayName")) {
                    String fullName = attribValues[0];
                    // Do something with the full name
                    System.out.println("Full Name: " + fullName);
                }
            }
        }
    }
}