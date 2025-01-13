import java.lang.String;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        // Code to run at 11:30 PM every day
        System.out.println("Job executed at 11:30 PM");
    }

    public static void main(String[] args) throws SchedulerException {
        // Create a scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // Create a job
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "myGroup")
                .build();

        // Create a trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "myGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 30 23 * * ?"))
                .build();

        // Schedule the job
        scheduler.scheduleJob(job, trigger);

        // Start the scheduler
        scheduler.start();
    }
}