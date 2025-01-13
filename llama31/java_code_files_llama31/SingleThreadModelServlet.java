/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.SingleThreadModel
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleThreadModelServlet
extends HttpServlet
implements SingleThreadModel {
    private final Object lock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object object = this.lock;
        synchronized (object) {
        }
    }

    public static void main(String[] stringArray) {
    }
}
