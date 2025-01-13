/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class ExcelExporter {
    public static void main(String[] stringArray) {
        HttpServletResponse httpServletResponse = null;
        ExcelExporter.setResponse(httpServletResponse);
    }

    public static void setResponse(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"report.csv\"");
    }
}
