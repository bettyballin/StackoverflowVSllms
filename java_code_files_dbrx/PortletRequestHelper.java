import javax.portlet.PortletRequest;
import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import java.util.Enumeration;
import java.util.Locale;
import java.security.Principal;
import java.util.Map;

public class PortletRequestHelper {

    PortletRequest request = (PortletRequest) this.getExternalContext().getRequest();
    String hidePanel = (String) request.getAttribute("hidePanel");

    public static void main(String[] args) {
    }

    public ExternalContext getExternalContext() {
        return new ExternalContext();
    }

    public class ExternalContext {
        public Object getRequest() {
            return new MyPortletRequest();
        }
    }

    public class MyPortletRequest implements PortletRequest {
        @Override
        public Object getAttribute(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String getAuthType() {
            return null;
        }

        @Override
        public String getContextPath() {
            return null;
        }

        @Override
        public String getRemoteUser() {
            return null;
        }

        @Override
        public Principal getUserPrincipal() {
            return null;
        }

        @Override
        public boolean isUserInRole(String role) {
            return false;
        }

        @Override
        public String getRequestedSessionId() {
            return null;
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            return false;
        }

        @Override
        public String getResponseContentType() {
            return null;
        }

        @Override
        public Enumeration<String> getResponseContentTypes() {
            return null;
        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return null;
        }

        @Override
        public String getScheme() {
            return null;
        }

        @Override
        public String getServerName() {
            return null;
        }

        @Override
        public int getServerPort() {
            return 0;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public void removeAttribute(String name) {
        }

        @Override
        public void setAttribute(String name, Object o) {
        }

        @Override
        public String getProperty(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getProperties(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getPropertyNames() {
            return null;
        }

        @Override
        public PortalContext getPortalContext() {
            return null;
        }

        @Override
        public Map<String, String[]> getPrivateParameterMap() {
            return null;
        }

        @Override
        public String getContextPath2() {
            return null;
        }

        @Override
        public Map<String, String[]> getPublicParameterMap() {
            return null;
        }

        @Override
        public String getWindowID() {
            return null;
        }

        @Override
        public PortletMode getPortletMode() {
            return null;
        }

        @Override
        public WindowState getWindowState() {
            return null;
        }

        @Override
        public String getETag() {
            return null;
        }

        @Override
        public String getParameter(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return null;
        }

        @Override
        public String[] getParameterValues(String name) {
            return null;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return null;
        }

        @Override
        public boolean isPortletModeAllowed(PortletMode mode) {
            return false;
        }

        @Override
        public boolean isWindowStateAllowed(WindowState state) {
            return false;
        }

        @Override
        public String getUserAgent() {
            return null;
        }
    }
}