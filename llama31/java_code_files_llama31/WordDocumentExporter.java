/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class WordDocumentExporter {
    public static void export(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=document.docx");
    }

    public static void main(String[] stringArray) {
    }
}
