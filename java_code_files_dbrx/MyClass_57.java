import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Date;

public class MyClass {

    public void scheduleNestedJob(String jobName, String triggerName, Date date){
        try{
            // Obtain the scheduler from Quartz
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            
            // Start the scheduler
            sched.start();

            JobKey jobKey = new JobKey(jobName);
            if (sched.checkExists(jobKey)) { // check if that specific Job is already scheduled with some trigger and remove it first
                for (Trigger trigger : sched.getTriggersOfJob(jobKey)) {
                    sched.unscheduleJob(trigger.getKey());
                }
            }

            // Define job and tie it to our Job class
            JobDetail job = JobBuilder.newJob(MyJobClass.class)
                .withIdentity(jobKey)
                .build();

            // Build trigger
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName)
                .startAt(date)
                .build();

            // Schedule the job with the trigger
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e){
             // Handle exception here, like logging or custom error message
             e.printStackTrace();
        }
    }

    // Define an example Job class
    public static class MyJobClass implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            // Job execution logic
            System.out.println("Executing job: " + context.getJobDetail().getKey().getName());
        }
    }

}