/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RmiServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            Registry registry = LocateRegistry.getRegistry();
            String string = httpServletRequest.getParameter("name");
            Remote remote = registry.lookup(string);
            String string2 = httpServletRequest.getParameter("method");
            Method method = remote.getClass().getMethod(string2, new Class[0]);
            Object object = method.invoke((Object)remote, new Object[0]);
            httpServletResponse.getWriter().write(object.toString());
        }
        catch (RemoteException remoteException) {
            httpServletResponse.sendError(500, remoteException.getMessage());
        }
        catch (NotBoundException notBoundException) {
            httpServletResponse.sendError(500, notBoundException.getMessage());
        }
        catch (NoSuchMethodException noSuchMethodException) {
            httpServletResponse.sendError(500, noSuchMethodException.getMessage());
        }
        catch (IllegalAccessException illegalAccessException) {
            httpServletResponse.sendError(500, illegalAccessException.getMessage());
        }
        catch (InvocationTargetException invocationTargetException) {
            httpServletResponse.sendError(500, invocationTargetException.getMessage());
        }
    }

    public static void main(String[] stringArray) {
    }
}
