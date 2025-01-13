/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class StatefulService {
    private HttpSession session = new HttpSession();

    public String startConversation(String string) {
        this.session.setAttribute("conversationId", UUID.randomUUID().toString());
        return "Conversation started with message: " + string;
    }

    public String continueConversation(String string) {
        String string2 = (String)this.session.getAttribute("conversationId");
        if (string2 == null) {
            return "No conversation to continue.";
        }
        return "Continuing conversation " + string2 + " with message: " + string;
    }

    public static void main(String[] stringArray) {
        StatefulService statefulService = new StatefulService();
        System.out.println(statefulService.startConversation("Hello!"));
        System.out.println(statefulService.continueConversation("How are you?"));
    }
}
