public class ClassSchedulerDataContext : DataContext {\n    public Table<Class> Classes;\n    public Table<Schedule> Schedules;\n\n    public ClassSchedulerDataContext() :\n        base("name=ClassSchedulerConnectionString") { }\n}