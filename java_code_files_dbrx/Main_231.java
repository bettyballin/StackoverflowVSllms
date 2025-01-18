import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

public class Main {
    public static void main(String[] args) {
        WebClient webClient = new WebClient();
        HtmlPage MyPage = null;
        try {
            // Replace with the actual URL you want to load
            MyPage = webClient.getPage("http://example.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (MyPage == null) {
            System.out.println("Failed to load the page, exiting.");
            return;
        }

        HtmlForm tempForm = null;
        try {
            tempForm = MyPage.getFormByName("menu_form");
            if (tempForm != null) {
                HtmlTextInput userIdField = tempForm.getInputByName("userId");
                if(userIdField != null){
                    userIdField.setValueAttribute("myusername");
                } else{
                    System.out.println("Unable to find input element with name 'userId'.");
                }
            } else {
                System.out.println("Form not found within the page context, Unable to proceed");
            }
        } catch (Exception e) {
            System.out.println("Error while attempting to fill form: " + e);
        }

        HtmlPage editSubscriberPage = null;
        try{
            if (tempForm != null) {
                HtmlSubmitInput submitButton = tempForm.getInputByName("submit_button");
                if(submitButton != null){
                    editSubscriberPage = submitButton.click();
                } else {
                    System.out.println("Unable to find input element with name 'submit_button'.");
                }
            } else {
                System.out.println("Form is null, unable to proceed.");
            }
        } catch (Exception e) {
            System.out.println("Failed due an exception while submitting the form: " + e);
        }
    }
}