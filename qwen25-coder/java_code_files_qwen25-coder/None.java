public class None {
    // Example snippet showing how a task could be added programmatically in an Eclipse RCP app:
    public static void main(String[] args) {
        ITaskList taskList = TasksUiPlugin.getTaskList();
        TaskRepository repository = new RepositoryTemplate().createRepository("example");
        LocalTask localTask = new LocalTask(repository);
        localTask.setSummary("Example Task");
        taskList.addTask(localTask, null);
    }
}

class ITaskList {
    public void addTask(LocalTask task, Object obj) {
        // Implementation here
    }
}

class TasksUiPlugin {
    public static ITaskList getTaskList() {
        return new ITaskList();
    }
}

class TaskRepository {
    // Implementation here
}

class RepositoryTemplate {
    public TaskRepository createRepository(String name) {
        return new TaskRepository();
    }
}

class LocalTask {
    public LocalTask(TaskRepository repository) {
        // Implementation here
    }
    public void setSummary(String summary) {
        // Implementation here
    }
}