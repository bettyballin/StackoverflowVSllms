import org.apache.wicket.ajax.AjaxButton;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;

public class UploadPage extends WebPage {
    private FileUploadField fileInput;

    public UploadPage() {
        Form<Void> uploadForm = new Form<>("uploadForm");
        uploadForm.setMultiPart(true); // Added this line to enable multipart/form-data
        add(uploadForm);

        fileInput = new FileUploadField("fileInput");
        uploadForm.add(fileInput);

        AjaxButton uploadButton = new AjaxButton("uploadButton") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                FileUpload fileUpload = fileInput.getFileUpload();
                if (fileUpload != null) {
                    // Process the uploaded file
                }
            }
        };
        uploadForm.add(uploadButton);
    }
}