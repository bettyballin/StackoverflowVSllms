import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.Model;

public class FileUploadPage extends WebPage {
    public FileUploadPage() {
        Form<Void> uploadForm = new Form<>("uploadForm");
        FileUploadField fileUploadField = new FileUploadField("fileUploadField", Model.of());
        uploadForm.add(fileUploadField);
        add(uploadForm);

        // Add an onSubmit JavaScript event to handle the AJAX request
        uploadForm.setOutputMarkupId(true);
        uploadForm.setMultiPart(true);
    }

    public static void main(String[] args) {
    }
}