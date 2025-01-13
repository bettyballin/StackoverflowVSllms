/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class QuestionCache {
    private Map<String, Question> cache = new HashMap<String, Question>();

    public void prefetch(Question question) {
        this.cache.put(question.getId(), question);
    }

    public Question get(String string) {
        return this.cache.remove(string);
    }

    public static void main(String[] stringArray) {
        QuestionCache questionCache = new QuestionCache();
        Question question = new Question("1", "What is your name?");
        questionCache.prefetch(question);
        Question question2 = questionCache.get("1");
        System.out.println(question2.getText());
    }
}
