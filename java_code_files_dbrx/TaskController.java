import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    private String someErrorView = "errorView";

    @RequestMapping(value="/project/task/update", method=RequestMethod.POST)
    public String updateTask(@ModelAttribute("task_persisted") Task taskPersisted, @ModelAttribute("task") Task taskUpdated, // Newly mapped attribute
                             BindingResult result, ModelMap modelMap, HttpServletRequest request) {
        // Persist/Update Task entity from the form submit (Spring MVC), but also with updates from DWR
        if (result.hasErrors()) {
            return someErrorView;
        } else {
            BeanUtils.copyProperties(taskUpdated, taskPersisted);  // You need this when handling optimistic lock exceptions or other concurrency issues
            taskRepo.update(taskPersisted);   // Assuming your Repo has such update method
            return "/project?id=" + taskPersisted.getProject().getId();
        }
    }

    public static void main(String[] args) {
    }
}

class Task {
    public Project getProject() {
        return new Project();
    }
}

class Project {
    public int getId() {
        return 0;
    }
}

class TaskRepo {
    public void update(Task task) {
        // Dummy implementation
    }
}