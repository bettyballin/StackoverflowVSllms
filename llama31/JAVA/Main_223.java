import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.Birthday;
import com.google.gdata.data.extensions.Website;
import java.net.URL;
import java.net.MalformedURLException;

public class Main_223 {
    public static void main(String[] args) throws Exception {
        // Set up the ContactsService
        ContactsService service = new ContactsService("your_app_name");

        // Set the namespace
        String namespace = "http://schemas.google.com/contact/2008";

        // Retrieve the contacts
        URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full");
        ContactFeed feed = service.getFeed(feedUrl, ContactFeed.class);

        // Loop through the contacts
        for (ContactEntry entry : feed.getEntries()) {
            // Get the birthday and website
            Birthday birthday = entry.getExtension(namespace, Birthday.class);
            Website website = entry.getExtension(namespace, Website.class);

            // Do something with the birthday and website
            if(birthday != null)
                System.out.println("Birthday: " + birthday.getValue());
            else
                System.out.println("Birthday: Not provided");
            if(website != null)
                System.out.println("Website: " + website.getValue());
            else
                System.out.println("Website: Not provided");
        }
    }
}