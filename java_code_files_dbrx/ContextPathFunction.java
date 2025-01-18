package functions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public final class ContextPathFunction {
    private static final String METHOD_GET_CONTEXT_PATH = "getContextPath";

    public static String contextPath() {
        return getContextPath();
    }

    @SuppressWarnings("deprecation")
    private static String getContextPath() {
        HttpServletRequest request = null;
        try {
            Class<?> clazz = Thread.currentThread().getStackTrace()[2].getClassLoader()
                    .loadClass("javax.servlet.http.HttpServletRequest");
            Method method = clazz.getMethod(METHOD_GET_CONTEXT_PATH);
            Object returnObject = method.invoke(request);
            if (returnObject instanceof String) {
                return (String) returnObject;
            } else {
                throw new IllegalStateException("getContextPath method returned invalid value.");
            }
        } catch (ClassNotFoundException e) {
            try {
                Method method = Thread.currentThread().getStackTrace()[2]
                        .getMethod(METHOD_GET_CONTEXT_PATH, HttpServletRequest.class);
                Object returnObject = method.invoke(request);
                if (returnObject instanceof String) {
                    return (String) returnObject;
                } else {
                    throw new IllegalStateException("getContextPath method returned undefined value.");
                }
            } catch (ClassCastException e1) {
                try {
                    Method method = Thread.currentThread().getStackTrace()[2]
                            .getMethod(METHOD_GET_CONTEXT_PATH, ServletRequest.class);
                    return getContextFromServlet(request);
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Unexpected exception", e1);
                } catch (NoSuchMethodException | InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (NoSuchMethodException | InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } catch (NoSuchMethodException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
        return null;
    }

    private static String getContextFromServlet(HttpServletRequest request) {
        if (request == null || request.getContextPath() == null) {
            return "/";
        } else {
            return request.getServletContext().getContextPath();
        }
    }

    public static void main(String[] args) {
    }
}