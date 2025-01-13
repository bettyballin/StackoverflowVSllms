import java.util.HashMap;
import java.util.Map;

public class QuestionCache {
    private Map<String, Question> cache;

    public QuestionCache() {
        cache = new HashMap<>();
    }

    public void prefetch(Question question) {
        cache.put(question.getId(), question);
    }

    public Question get(String questionId) {
        return cache.remove(questionId);
    }

    public static void main(String[] args) {
        QuestionCache cache = new QuestionCache();
        Question question = new Question("1", "What is your name?");
        cache.prefetch(question);
        Question retrievedQuestion = cache.get("1");
        System.out.println(retrievedQuestion.getText());
    }
}

class Question {
    private String id;
    private String text;

    public Question(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}