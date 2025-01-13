/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileListServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = this.getServletContext().getRealPath(httpServletRequest.getRequestURI());
        File file = new File(string);
        File file2 = file.getParentFile();
        File[] fileArray = file2.listFiles();
        httpServletResponse.setContentType("text/plain");
        PrintWriter printWriter = httpServletResponse.getWriter();
        if (fileArray != null) {
            for (File file3 : fileArray) {
                printWriter.println(file3.getName());
            }
        } else {
            printWriter.println("Directory is empty or not accessible.");
        }
        printWriter.close();
    }
}
