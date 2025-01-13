import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.lang.String;

public class FormatFileSizeTag extends SimpleTagSupport {
    private long fileSize;

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(FileUtils.formatFileSize(fileSize));
    }

    public static void main(String[] args) {
    }
}