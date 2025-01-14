// YourServiceImpl.java
package com.example;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebService(endpointInterface = "com.example.YourService")
public class YourServiceImpl implements YourService {

    @Resource
    private WebServiceContext wsContext;

    @Override
    public String yourOperation(String param) {
        HttpServletRequest request = (HttpServletRequest) wsContext.getMessageContext()
                .get(MessageContext.SERVLET_REQUEST);
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // Extract base64 encoded credentials
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
            // Credentials format: username:password
            final String[] values = credentials.split(":", 2);

            if (authenticate(values[0], values[1])) {
                return "Operation Success";
            }
        }

        throw new SOAPFaultException(SOAPUtil.createSimpleSOAPFault("Unauthorized", "401 Unauthorized"));
    }

    private boolean authenticate(String username, String password) {
        // Validate credentials against your database
        return DatabaseUtils.authenticate(username, password);
    }

    public static void main(String[] args) {
        // Entry point if needed
    }
}