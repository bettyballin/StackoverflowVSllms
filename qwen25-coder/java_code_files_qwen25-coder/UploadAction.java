import java.io.File;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadForm uploadForm = (UploadForm) form;
        FormFile[] files = uploadForm.getMyfile();

        for (int i = 0; i < files.length; i++) {
            FormFile file = files[i];
            // Process each file here
            if (file != null) {
                String filepath = "/path/to/destination/" + file.getFileName();
                file.write(new File(filepath));
            }
        }

        return mapping.findForward("success");
    }

    public static void main(String[] args) {
    }
}