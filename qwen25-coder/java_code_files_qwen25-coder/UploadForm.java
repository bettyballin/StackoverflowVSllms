import java.lang.String;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm {
    private FormFile[] myfile;

    public FormFile[] getMyfile() {
        return myfile;
    }

    public void setMyfile(FormFile[] myfile) {
        this.myfile = myfile;
    }

    public static void main(String[] args) {
    }
}