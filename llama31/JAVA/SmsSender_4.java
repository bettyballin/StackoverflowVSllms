import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

public class SmsSender_4_4 {
  public static void main(String[] args) {
    // Your Account SID from twilio.com/console
    String accountSid = "your_account_sid";
    // Your Auth Token from twilio.com/console
    String authToken = "your_auth_token";
    // The phone number you obtained from Twilio
    String fromNumber = "+1234567890";
    // The phone number you want to send to
    String toNumber = "+9876543210";
    // The message you want to send
    String message = "Hello from Java!";

    MessageCreator messageCreator = new MessageCreator(
      new PhoneNumber(toNumber),
      new PhoneNumber(fromNumber),
      message
    );

    try {
      Message sms = messageCreator.create(accountSid, authToken);
      System.out.println("SMS sent! SID: " + sms.getSid());
    } catch (Exception e) {
      System.out.println("Error sending SMS: " + e.getMessage());
    }
  }
}