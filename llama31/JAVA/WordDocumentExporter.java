import javax.servlet.http.HttpServletResponse;

public class WordDocumentExporter {
    public static void export(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=document.docx");
    }

    public static void main(String[] args) {
        // This main method is not being used in this example.
        // Typically, you would call the export method from a servlet or other web framework.
    }
}