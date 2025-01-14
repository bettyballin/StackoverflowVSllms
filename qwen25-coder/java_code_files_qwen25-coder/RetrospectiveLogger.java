import java.util.List;
import java.util.ArrayList;

class LessonLearned {
    String sprintNumber;
    String description;
    String recommendedAction;

    public LessonLearned(String sprintNumber, String description, String recommendedAction) {
        this.sprintNumber = sprintNumber;
        this.description = description;
        this.recommendedAction = recommendedAction;
    }
}

public class RetrospectiveLogger {
    private List<LessonLearned> lessonsLearnedList = new ArrayList<>();

    public void addLesson(LessonLearned lesson) {
        lessonsLearnedList.add(lesson);
    }

    public void printLessons() {
        System.out.println("Retrospective Lessons Learned:");
        for (LessonLearned lesson : lessonsLearnedList) {
            System.out.printf("[Sprint %s] Description: %s | Recommended Action: %s%n", 
                              lesson.sprintNumber, lesson.description, lesson.recommendedAction);
        }
    }

    public static void main(String[] args) {
        RetrospectiveLogger logger = new RetrospectiveLogger();
        logger.addLesson(new LessonLearned("01", "Estimates were too optimistic.", "Refine our estimation techniques."));
        logger.printLessons();
    }
}