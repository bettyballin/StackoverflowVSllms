import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProjectController {

    // Assuming taskRepo is a Spring Data JPA repository
    private final TaskRepository taskRepo;

    public ProjectController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @ModelAttribute("task")
    public Task getTask(@RequestParam(value="taskId") String taskId) {
        return taskRepo.get(taskId);
    }

    @RequestMapping(value="/project/task/update", method=RequestMethod.POST)
    public String updateTask(@ModelAttribute(value="task") Task task,
                             HttpServletRequest request, ModelMap modelMap) {
        // The task object is now the persisted object, and the request parameters will be bound to it
        taskRepo.merge(task);
        return "/project?id=" + task.getProject().getId();
    }

    public static void main(String[] args) {
    }
}