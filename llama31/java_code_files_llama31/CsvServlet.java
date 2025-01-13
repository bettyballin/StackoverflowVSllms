/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class CsvServlet {
    public void doGet(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=generated_file.csv");
    }
}
